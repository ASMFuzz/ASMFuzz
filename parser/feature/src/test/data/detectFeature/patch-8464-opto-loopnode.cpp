@@ -3886,6 +3886,17 @@ uint IdealLoopTree::est_loop_flow_merge_sz() const {
   return 0;
 }
 
+#ifdef ASSERT
+bool IdealLoopTree::has_reduction_nodes() const {
+  for (uint i = 0; i < _body.size(); i++) {
+    if (_body[i]->is_reduction()) {
+      return true;
+    }
+  }
+  return false;
+}
+#endif // ASSERT
+
 #ifndef PRODUCT
 //------------------------------dump_head--------------------------------------
 // Dump 1 liner for loop header info