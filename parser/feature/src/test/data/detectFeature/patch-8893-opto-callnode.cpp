@@ -1095,10 +1095,16 @@ Node* CallStaticJavaNode::Ideal(PhaseGVN* phase, bool can_reshape) {
   return CallNode::Ideal(phase, can_reshape);
 }
 
+//----------------------------is_uncommon_trap----------------------------
+// Returns true if this is an uncommon trap.
+bool CallStaticJavaNode::is_uncommon_trap() const {
+  return (_name != NULL && !strcmp(_name, "uncommon_trap"));
+}
+
 //----------------------------uncommon_trap_request----------------------------
 // If this is an uncommon trap, return the request code, else zero.
 int CallStaticJavaNode::uncommon_trap_request() const {
-  if (_name != NULL && !strcmp(_name, "uncommon_trap")) {
+  if (is_uncommon_trap()) {
     return extract_uncommon_trap_request(this);
   }
   return 0;
@@ -1474,9 +1480,10 @@ SafePointScalarObjectNode::SafePointScalarObjectNode(const TypeOopPtr* tp,
 {
 #ifdef ASSERT
   if (!alloc->is_Allocate()
-      && !(alloc->Opcode() == Op_VectorBox)) {
+      && !(alloc->Opcode() == Op_VectorBox)
+      && !alloc->is_ReducedAllocationMerge()) {
     alloc->dump();
-    assert(false, "unexpected call node");
+    assert(false, "unexpected node.");
   }
 #endif
   init_class_id(Class_SafePointScalarObject);