@@ -44,36 +44,13 @@
 #include "utilities/growableArray.hpp"
 #include "utilities/powerOfTwo.hpp"
 
-uint HeapRegionRemSet::_split_card_shift = 0;
-size_t HeapRegionRemSet::_split_card_mask = 0;
 HeapWord* HeapRegionRemSet::_heap_base_address = nullptr;
 
 const char* HeapRegionRemSet::_state_strings[] =  {"Untracked", "Updating", "Complete"};
 const char* HeapRegionRemSet::_short_state_strings[] =  {"UNTRA", "UPDAT", "CMPLT"};
 
 void HeapRegionRemSet::initialize(MemRegion reserved) {
-  const uint BitsInUint = sizeof(uint) * BitsPerByte;
-  const uint CardBitsWithinCardRegion = MIN2((uint)HeapRegion::LogCardsPerRegion, G1CardSetContainer::LogCardsPerRegionLimit);
-
-  // Check if the number of cards within a region fits an uint.
-  if (CardBitsWithinCardRegion > BitsInUint) {
-    vm_exit_during_initialization("Can not represent all cards in a card region within uint.");
-  }
-
-  _split_card_shift = CardBitsWithinCardRegion + CardTable::card_shift();
-  _split_card_mask = ((size_t)1 << _split_card_shift) - 1;
-
-  // Check if the card region/region within cards combination can cover the heap.
-  const uint HeapSizeBits = log2i_exact(round_up_power_of_2(reserved.byte_size()));
-  if (HeapSizeBits > (BitsInUint + _split_card_shift)) {
-    FormatBuffer<> fmt("Can not represent all cards in the heap with card region/card within region. "
-                       "Heap %zuB (%u bits) Remembered set covers %u bits.",
-                       reserved.byte_size(),
-                       HeapSizeBits,
-                       BitsInUint + _split_card_shift);
-    vm_exit_during_initialization(fmt, "Decrease heap size.");
-  }
-
+  G1CardSet::initialize(reserved);
   _heap_base_address = reserved.start();
 }
 