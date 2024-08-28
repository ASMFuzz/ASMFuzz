@@ -51,12 +51,6 @@ class HeapRegionRemSet : public CHeapObj<mtGC> {
 
   HeapRegion* _hr;
 
-  // When splitting addresses into region and card within that region, the logical
-  // shift value to get the region.
-  static uint _split_card_shift;
-  // When splitting addresses into region and card within that region, the mask
-  // to get the offset within the region.
-  static size_t _split_card_mask;
   // Cached value of heap base address.
   static HeapWord* _heap_base_address;
 
@@ -95,6 +89,8 @@ class HeapRegionRemSet : public CHeapObj<mtGC> {
   // Coarsening statistics since VM start.
   static G1CardSetCoarsenStats coarsen_stats() { return G1CardSet::coarsen_stats(); }
 
+  inline uintptr_t to_card(OopOrNarrowOopStar from) const;
+
 private:
   enum RemSetState {
     Untracked,