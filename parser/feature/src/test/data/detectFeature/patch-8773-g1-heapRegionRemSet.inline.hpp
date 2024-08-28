@@ -119,7 +119,7 @@ void HeapRegionRemSet::split_card(OopOrNarrowOopStar from, uint& card_region, ui
   size_t offset = pointer_delta(from, _heap_base_address, 1);
   card_region = (uint)(offset >> _split_card_shift);
   card_within_region = (uint)((offset & _split_card_mask) >> CardTable::card_shift());
-  assert(card_within_region < ((uint)1 << G1CardSetContainer::LogCardsPerRegionLimit), "must be");
+  assert(card_within_region < G1CardSetContainer::cards_per_region_limit(), "must be");
 }
 
 void HeapRegionRemSet::add_reference(OopOrNarrowOopStar from, uint tid) {