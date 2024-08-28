@@ -778,6 +778,11 @@ class IdealLoopTree : public ResourceObj {
 
   void remove_main_post_loops(CountedLoopNode *cl, PhaseIdealLoop *phase);
 
+#ifdef ASSERT
+  // Tell whether the body contains nodes marked as reductions.
+  bool has_reduction_nodes() const;
+#endif // ASSERT
+
 #ifndef PRODUCT
   void dump_head() const;       // Dump loop head only
   void dump() const;            // Dump this loop recursively