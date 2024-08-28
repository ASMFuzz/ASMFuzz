@@ -100,8 +100,9 @@ class PhaseMacroExpand : public Phase {
 
   bool eliminate_boxing_node(CallStaticJavaNode *boxing);
   bool eliminate_allocate_node(AllocateNode *alloc);
-  bool can_eliminate_allocation(AllocateNode *alloc, GrowableArray <SafePointNode *>& safepoints);
-  bool scalar_replacement(AllocateNode *alloc, GrowableArray <SafePointNode *>& safepoints_done);
+  bool eliminate_reduced_allocation_merge(ReducedAllocationMergeNode *ram);
+  bool can_eliminate_allocation(AllocateNode *alloc, GrowableArray <SafePointNode *>& safepoints, GrowableArray <ReducedAllocationMergeNode *>& rams);
+  bool scalar_replacement(AllocateNode *alloc, GrowableArray <SafePointNode *>& safepoints_done, GrowableArray <ReducedAllocationMergeNode *>& rams);
   void process_users_of_allocation(CallNode *alloc);
 
   void eliminate_gc_barrier(Node *p2x);