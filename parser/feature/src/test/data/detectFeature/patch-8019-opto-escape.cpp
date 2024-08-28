@@ -233,6 +233,7 @@ bool ConnectionGraph::compute_escape() {
 
   if (non_escaped_allocs_worklist.length() == 0) {
     _collecting = false;
+    NOT_PRODUCT(escape_state_statistics(java_objects_worklist);)
     return false; // Nothing to do.
   }
   // Add final simple edges to graph.
@@ -262,14 +263,18 @@ bool ConnectionGraph::compute_escape() {
   // processing, calls to CI to resolve symbols (types, fields, methods)
   // referenced in bytecode. During symbol resolution VM may throw
   // an exception which CI cleans and converts to compilation failure.
-  if (C->failing())  return false;
+  if (C->failing()) {
+    NOT_PRODUCT(escape_state_statistics(java_objects_worklist);)
+    return false;
+  }
 
   // 2. Finish Graph construction by propagating references to all
   //    java objects through graph.
   if (!complete_connection_graph(ptnodes_worklist, non_escaped_allocs_worklist,
                                  java_objects_worklist, oop_fields_worklist)) {
     // All objects escaped or hit time or iterations limits.
     _collecting = false;
+    NOT_PRODUCT(escape_state_statistics(java_objects_worklist);)
     return false;
   }
 
@@ -339,7 +344,10 @@ bool ConnectionGraph::compute_escape() {
     // Now use the escape information to create unique types for
     // scalar replaceable objects.
     split_unique_types(alloc_worklist, arraycopy_worklist, mergemem_worklist);
-    if (C->failing())  return false;
+    if (C->failing()) {
+      NOT_PRODUCT(escape_state_statistics(java_objects_worklist);)
+      return false;
+    }
     C->print_method(PHASE_AFTER_EA, 2);
 
 #ifdef ASSERT
@@ -375,6 +383,7 @@ bool ConnectionGraph::compute_escape() {
     }
   }
 
+  NOT_PRODUCT(escape_state_statistics(java_objects_worklist);)
   return has_non_escaping_obj;
 }
 
@@ -3631,6 +3640,10 @@ void ConnectionGraph::split_unique_types(GrowableArray<Node *>  &alloc_worklist,
 }
 
 #ifndef PRODUCT
+int ConnectionGraph::_no_escape_counter = 0;
+int ConnectionGraph::_arg_escape_counter = 0;
+int ConnectionGraph::_global_escape_counter = 0;
+
 static const char *node_type_names[] = {
   "UnknownType",
   "JavaObject",
@@ -3739,6 +3752,30 @@ void ConnectionGraph::dump(GrowableArray<PointsToNode*>& ptnodes_worklist) {
   }
 }
 
+void ConnectionGraph::print_statistics() {
+  tty->print_cr("No escape = %d, Arg escape = %d, Global escape = %d", Atomic::load(&_no_escape_counter), Atomic::load(&_arg_escape_counter), Atomic::load(&_global_escape_counter));
+}
+
+void ConnectionGraph::escape_state_statistics(GrowableArray<JavaObjectNode*>& java_objects_worklist) {
+  if (!PrintOptoStatistics || (_invocation > 0)) { // Collect data only for the first invocation
+    return;
+  }
+  for (int next = 0; next < java_objects_worklist.length(); ++next) {
+    JavaObjectNode* ptn = java_objects_worklist.at(next);
+    if (ptn->ideal_node()->is_Allocate()) {
+      if (ptn->escape_state() == PointsToNode::NoEscape) {
+        Atomic::inc(&ConnectionGraph::_no_escape_counter);
+      } else if (ptn->escape_state() == PointsToNode::ArgEscape) {
+        Atomic::inc(&ConnectionGraph::_arg_escape_counter);
+      } else if (ptn->escape_state() == PointsToNode::GlobalEscape) {
+        Atomic::inc(&ConnectionGraph::_global_escape_counter);
+      } else {
+        assert(false, "Unexpected Escape State");
+      }
+    }
+  }
+}
+
 void ConnectionGraph::trace_es_update_helper(PointsToNode* ptn, PointsToNode::EscapeState es, bool fields, const char* reason) const {
   if (_compile->directive()->TraceEscapeAnalysisOption) {
     assert(ptn != nullptr, "should not be null");