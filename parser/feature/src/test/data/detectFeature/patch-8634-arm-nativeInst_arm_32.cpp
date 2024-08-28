@@ -337,3 +337,25 @@ NativeCall* rawNativeCall_before(address return_address) {
   return nativeCall_at(call);
 }
 
+void NativePostCallNop::make_deopt() {
+  NativeDeoptInstruction::insert(addr_at(0));
+}
+
+void NativePostCallNop::patch(jint diff) {
+  // unsupported for now
+}
+
+void NativeDeoptInstruction::verify() {
+}
+
+// Inserts an undefined instruction at a given pc
+void NativeDeoptInstruction::insert(address code_pos) {
+  // UDF, Encoding A1:
+  // 1 1 1 0 | 0 1 1 1 | 1 1 1 1 | imm12 | 1 1 1 1 | imm4 |
+  // e       | 7       | f       | dec   | f       | a    |
+  // 0xe7              | 0xfd, 0xec      | 0xfa
+  uint32_t insn = 0xe7fdecfa;
+  uint32_t *pos = (uint32_t *) code_pos;
+  *pos = insn;
+  ICache::invalidate_range(code_pos, 4);
+}