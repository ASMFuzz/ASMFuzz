@@ -115,11 +115,9 @@ inline void HeapRegionRemSet::iterate_for_merge(CardOrRangeVisitor& cl) {
   _card_set.iterate_containers(&cl2, true /* at_safepoint */);
 }
 
-void HeapRegionRemSet::split_card(OopOrNarrowOopStar from, uint& card_region, uint& card_within_region) const {
-  size_t offset = pointer_delta(from, _heap_base_address, 1);
-  card_region = (uint)(offset >> _split_card_shift);
-  card_within_region = (uint)((offset & _split_card_mask) >> CardTable::card_shift());
-  assert(card_within_region < G1CardSetContainer::cards_per_region_limit(), "must be");
+
+uintptr_t HeapRegionRemSet::to_card(OopOrNarrowOopStar from) const {
+  return pointer_delta(from, _heap_base_address, 1) >> CardTable::card_shift();
 }
 
 void HeapRegionRemSet::add_reference(OopOrNarrowOopStar from, uint tid) {
@@ -135,30 +133,15 @@ void HeapRegionRemSet::add_reference(OopOrNarrowOopStar from, uint tid) {
    return;
   }
 
-  uint card_region;
-  uint card_within_region;
-
-  split_card(from, card_region, card_within_region);
-
-  _card_set.add_card(card_region, card_within_region);
+  _card_set.add_card(to_card(from));
 }
 
 bool HeapRegionRemSet::contains_reference(OopOrNarrowOopStar from) {
-  uint card_region;
-  uint card_within_region;
-
-  split_card(from, card_region, card_within_region);
-
-  return _card_set.contains_card(card_region, card_within_region);
+  return _card_set.contains_card(to_card(from));
 }
 
 void HeapRegionRemSet::print_info(outputStream* st, OopOrNarrowOopStar from) {
-  uint card_region;
-  uint card_within_region;
-
-  split_card(from, card_region, card_within_region);
-
-  _card_set.print_info(st, card_region, card_within_region);
+  _card_set.print_info(st, to_card(from));
 }
 
 #endif // SHARE_VM_GC_G1_HEAPREGIONREMSET_INLINE_HPP