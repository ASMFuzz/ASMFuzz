@@ -208,6 +208,15 @@ class PhaseMacroExpand : public Phase {
 
   PhaseIterGVN &igvn() const { return _igvn; }
 
+#ifndef PRODUCT
+    static int _objs_scalar_replaced_counter;
+    static int _monitor_objects_removed_counter;
+    static int _GC_barriers_removed_counter;
+    static int _memory_barriers_removed_counter;
+    static void print_statistics();
+    static int count_MemBar(Compile *C);
+#endif
+
   // Members accessed from BarrierSetC2
   void replace_node(Node* source, Node* target) { _igvn.replace_node(source, target); }
   Node* intcon(jint con)        const { return _igvn.intcon(con); }