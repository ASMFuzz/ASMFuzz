@@ -32,11 +32,14 @@
 #include "memory/allocation.inline.hpp"
 #include "runtime/atomic.hpp"
 #include "runtime/globals_extension.hpp"
+#include "runtime/java.hpp"
 #include "utilities/bitMap.inline.hpp"
 #include "utilities/concurrentHashTable.inline.hpp"
 #include "utilities/globalDefinitions.hpp"
 
 G1CardSet::ContainerPtr G1CardSet::FullCardSet = (G1CardSet::ContainerPtr)-1;
+uint G1CardSet::_split_card_shift = 0;
+size_t G1CardSet::_split_card_mask = 0;
 
 static uint default_log2_card_regions_per_region() {
   uint log2_card_regions_per_heap_region = 0;
@@ -367,6 +370,30 @@ G1CardSet::~G1CardSet() {
   _mm->flush();
 }
 
+void G1CardSet::initialize(MemRegion reserved) {
+  const uint BitsInUint = sizeof(uint) * BitsPerByte;
+  const uint CardBitsWithinCardRegion = MIN2((uint)HeapRegion::LogCardsPerRegion, G1CardSetContainer::LogCardsPerRegionLimit);
+
+  // Check if the number of cards within a region fits an uint.
+  if (CardBitsWithinCardRegion > BitsInUint) {
+    vm_exit_during_initialization("Can not represent all cards in a card region within uint.");
+  }
+
+  _split_card_shift = CardBitsWithinCardRegion;
+  _split_card_mask = ((size_t)1 << _split_card_shift) - 1;
+
+  // Check if the card region/region within cards combination can cover the heap.
+  const uint HeapSizeBits = log2i_exact(round_up_power_of_2(reserved.byte_size()));
+  if (HeapSizeBits > (BitsInUint + _split_card_shift + G1CardTable::card_shift())) {
+    FormatBuffer<> fmt("Can not represent all cards in the heap with card region/card within region. "
+                       "Heap %zuB (%u bits) Card set only covers %u bits.",
+                       reserved.byte_size(),
+                       HeapSizeBits,
+                       BitsInUint + _split_card_shift + G1CardTable::card_shift());
+    vm_exit_during_initialization(fmt, "Decrease heap size.");
+  }
+}
+
 uint G1CardSet::container_type_to_mem_object_type(uintptr_t type) const {
   assert(type == G1CardSet::ContainerArrayOfCards ||
          type == G1CardSet::ContainerBitMap ||
@@ -707,6 +734,28 @@ G1CardSetHashTableValue* G1CardSet::get_container(uint card_region) {
   return _table->get(card_region);
 }
 
+void G1CardSet::split_card(uintptr_t card, uint& card_region, uint& card_within_region) const {
+  card_region = (uint)(card >> _split_card_shift);
+  card_within_region = (uint)(card & _split_card_mask);
+  assert(card_within_region < _config->max_cards_in_region(), "must be");
+}
+
+G1AddCardResult G1CardSet::add_card(uintptr_t card) {
+  uint card_region;
+  uint card_within_region;
+  split_card(card, card_region, card_within_region);
+
+  return add_card(card_region, card_within_region, true /* increment_total */);
+}
+
+bool G1CardSet::contains_card(uintptr_t card) {
+  uint card_region;
+  uint card_within_region;
+  split_card(card, card_region, card_within_region);
+
+  return contains_card(card_region, card_within_region);
+}
+
 G1AddCardResult G1CardSet::add_card(uint card_region, uint card_in_region, bool increment_total) {
   G1AddCardResult add_result;
   ContainerPtr to_transfer = nullptr;
@@ -785,7 +834,12 @@ bool G1CardSet::contains_card(uint card_region, uint card_in_region) {
   return false;
 }
 
-void G1CardSet::print_info(outputStream* st, uint card_region, uint card_in_region) {
+void G1CardSet::print_info(outputStream* st, uintptr_t card) {
+  uint card_region;
+  uint card_in_region;
+
+  split_card(card, card_region, card_in_region);
+
   G1CardSetHashTableValue* table_entry = get_container(card_region);
   if (table_entry == nullptr) {
     st->print("NULL card set");