@@ -26,6 +26,7 @@
 #define SHARE_GC_G1_G1CARDSET_HPP
 
 #include "memory/allocation.hpp"
+#include "memory/memRegion.hpp"
 #include "utilities/concurrentHashTable.hpp"
 
 class G1CardSetAllocOptions;
@@ -185,11 +186,19 @@ class G1CardSetCoarsenStats {
 class G1CardSet : public CHeapObj<mtGCCardSet> {
   friend class G1CardSetTest;
   friend class G1CardSetMtTestTask;
+  friend class G1CheckCardClosure;
 
   friend class G1TransferCard;
 
   friend class G1ReleaseCardsets;
 
+  // When splitting addresses into region and card within that region, the logical
+  // shift value to get the region.
+  static uint _split_card_shift;
+  // When splitting addresses into region and card within that region, the mask
+  // to get the offset within the region.
+  static size_t _split_card_mask;
+
   static G1CardSetCoarsenStats _coarsen_stats; // Coarsening statistics since VM start.
   static G1CardSetCoarsenStats _last_coarsen_stats; // Coarsening statistics before last GC.
 public:
@@ -294,20 +303,36 @@ class G1CardSet : public CHeapObj<mtGCCardSet> {
   uint8_t* allocate_mem_object(uintptr_t type);
   void free_mem_object(ContainerPtr container);
 
+  void split_card(uintptr_t card, uint& card_region, uint& card_within_region) const;
+
+  G1AddCardResult add_card(uint card_region, uint card_in_region, bool increment_total = true);
+
+  bool contains_card(uint card_region, uint card_in_region);
+
+  // Testing API
+  class CardClosure {
+  public:
+    virtual void do_card(uint region_idx, uint card_idx) = 0;
+  };
+
+  void iterate_cards(CardClosure& cl);
+
 public:
   G1CardSetConfiguration* config() const { return _config; }
 
   // Create a new remembered set for a particular heap region.
   G1CardSet(G1CardSetConfiguration* config, G1CardSetMemoryManager* mm);
   virtual ~G1CardSet();
 
+  static void initialize(MemRegion reserved);
+
   // Adds the given card to this set, returning an appropriate result.
   // If incremental_count is true and the card has been added, updates the total count.
-  G1AddCardResult add_card(uint card_region, uint card_in_region, bool increment_total = true);
+  G1AddCardResult add_card(uintptr_t card);
 
-  bool contains_card(uint card_region, uint card_in_region);
+  bool contains_card(uintptr_t card);
 
-  void print_info(outputStream* st, uint card_region, uint card_in_region);
+  void print_info(outputStream* st, uintptr_t card);
 
   // Returns whether this remembered set (and all sub-sets) have an occupancy
   // that is less or equal to the given occupancy.
@@ -352,17 +377,10 @@ class G1CardSet : public CHeapObj<mtGCCardSet> {
 
   class ContainerPtrClosure {
   public:
-    virtual void do_containerptr(uint region_idx, size_t num_occupied, ContainerPtr container) = 0;
+    virtual void do_containerptr(uint card_region_idx, size_t num_occupied, ContainerPtr container) = 0;
   };
 
   void iterate_containers(ContainerPtrClosure* cl, bool safepoint = false);
-
-  class CardClosure {
-  public:
-    virtual void do_card(uint region_idx, uint card_idx) = 0;
-  };
-
-  void iterate_cards(CardClosure& cl);
 };
 
 class G1CardSetHashTableValue {