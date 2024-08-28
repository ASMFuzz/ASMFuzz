@@ -161,6 +161,8 @@ class G1CardSetCoarsenStats {
 
   void reset();
 
+  void set(G1CardSetCoarsenStats& other);
+
   void subtract_from(G1CardSetCoarsenStats& other);
 
   // Record a coarsening for the given tag/category. Collision should be true if
@@ -189,7 +191,7 @@ class G1CardSet : public CHeapObj<mtGCCardSet> {
   friend class G1ReleaseCardsets;
 
   static G1CardSetCoarsenStats _coarsen_stats; // Coarsening statistics since VM start.
-  static G1CardSetCoarsenStats _last_coarsen_stats; // Coarsening statistics at last GC.
+  static G1CardSetCoarsenStats _last_coarsen_stats; // Coarsening statistics before last GC.
 public:
   // Two lower bits are used to encode the card set container types
   static const uintptr_t ContainerPtrHeaderSize = 2;