@@ -159,6 +159,11 @@ CallNode* PhaseMacroExpand::make_slow_call(CallNode *oldcall, const TypeFunc* sl
 void PhaseMacroExpand::eliminate_gc_barrier(Node* p2x) {
   BarrierSetC2 *bs = BarrierSet::barrier_set()->barrier_set_c2();
   bs->eliminate_gc_barrier(this, p2x);
+#ifndef PRODUCT
+  if (PrintOptoStatistics) {
+    Atomic::inc(&PhaseMacroExpand::_GC_barriers_removed_counter);
+  }
+#endif
 }
 
 // Search for a memory operation for the specified memory slice.
@@ -2309,6 +2314,7 @@ void PhaseMacroExpand::expand_subtypecheck_node(SubTypeCheckNode *check) {
 void PhaseMacroExpand::eliminate_macro_nodes() {
   if (C->macro_count() == 0)
     return;
+  NOT_PRODUCT(int membar_before = count_MemBar(C);)
 
   // Before elimination may re-mark (change to Nested or NonEscObj)
   // all associated (same box and obj) lock and unlock nodes.
@@ -2334,6 +2340,11 @@ void PhaseMacroExpand::eliminate_macro_nodes() {
       DEBUG_ONLY(int old_macro_count = C->macro_count();)
       if (n->is_AbstractLock()) {
         success = eliminate_locking_node(n->as_AbstractLock());
+#ifndef PRODUCT
+        if (success && PrintOptoStatistics) {
+          Atomic::inc(&PhaseMacroExpand::_monitor_objects_removed_counter);
+        }
+#endif
       }
       assert(success == (C->macro_count() < old_macro_count), "elimination reduces macro count");
       progress = progress || success;
@@ -2352,6 +2363,11 @@ void PhaseMacroExpand::eliminate_macro_nodes() {
       case Node::Class_Allocate:
       case Node::Class_AllocateArray:
         success = eliminate_allocate_node(n->as_Allocate());
+#ifndef PRODUCT
+        if (success && PrintOptoStatistics) {
+          Atomic::inc(&PhaseMacroExpand::_objs_scalar_replaced_counter);
+        }
+#endif
         break;
       case Node::Class_CallStaticJava:
         success = eliminate_boxing_node(n->as_CallStaticJava());
@@ -2381,6 +2397,12 @@ void PhaseMacroExpand::eliminate_macro_nodes() {
       progress = progress || success;
     }
   }
+#ifndef PRODUCT
+  if (PrintOptoStatistics) {
+    int membar_after = count_MemBar(C);
+    Atomic::add(&PhaseMacroExpand::_memory_barriers_removed_counter, membar_before - membar_after);
+  }
+#endif
 }
 
 //------------------------------expand_macro_nodes----------------------
@@ -2569,3 +2591,38 @@ bool PhaseMacroExpand::expand_macro_nodes() {
   _igvn.set_delay_transform(false);
   return false;
 }
+
+#ifndef PRODUCT
+int PhaseMacroExpand::_objs_scalar_replaced_counter = 0;
+int PhaseMacroExpand::_monitor_objects_removed_counter = 0;
+int PhaseMacroExpand::_GC_barriers_removed_counter = 0;
+int PhaseMacroExpand::_memory_barriers_removed_counter = 0;
+
+void PhaseMacroExpand::print_statistics() {
+  tty->print("Objects scalar replaced = %d, ", Atomic::load(&_objs_scalar_replaced_counter));
+  tty->print("Monitor objects removed = %d, ", Atomic::load(&_monitor_objects_removed_counter));
+  tty->print("GC barriers removed = %d, ", Atomic::load(&_GC_barriers_removed_counter));
+  tty->print_cr("Memory barriers removed = %d", Atomic::load(&_memory_barriers_removed_counter));
+}
+
+int PhaseMacroExpand::count_MemBar(Compile *C) {
+  if (!PrintOptoStatistics) {
+    return 0;
+  }
+  Unique_Node_List ideal_nodes;
+  int total = 0;
+  ideal_nodes.map(C->live_nodes(), NULL);
+  ideal_nodes.push(C->root());
+  for (uint next = 0; next < ideal_nodes.size(); ++next) {
+    Node* n = ideal_nodes.at(next);
+    if (n->is_MemBar()) {
+      total++;
+    }
+    for (DUIterator_Fast imax, i = n->fast_outs(imax); i < imax; i++) {
+      Node* m = n->fast_out(i);
+      ideal_nodes.push(m);
+    }
+  }
+  return total;
+}
+#endif