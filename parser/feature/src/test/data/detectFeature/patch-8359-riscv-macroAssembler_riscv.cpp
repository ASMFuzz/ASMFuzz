@@ -324,7 +324,7 @@ void MacroAssembler::call_VM_base(Register oop_result,
 void MacroAssembler::get_vm_result(Register oop_result, Register java_thread) {
   ld(oop_result, Address(java_thread, JavaThread::vm_result_offset()));
   sd(zr, Address(java_thread, JavaThread::vm_result_offset()));
-  verify_oop(oop_result, "broken oop in call_VM_base");
+  verify_oop_msg(oop_result, "broken oop in call_VM_base");
 }
 
 void MacroAssembler::get_vm_result_2(Register metadata_result, Register java_thread) {
@@ -362,15 +362,15 @@ void MacroAssembler::clinit_barrier(Register klass, Register tmp, Label* L_fast_
   }
 }
 
-void MacroAssembler::verify_oop(Register reg, const char* s) {
+void MacroAssembler::_verify_oop(Register reg, const char* s, const char* file, int line) {
   if (!VerifyOops) { return; }
 
   // Pass register number to verify_oop_subroutine
   const char* b = NULL;
   {
     ResourceMark rm;
     stringStream ss;
-    ss.print("verify_oop: %s: %s", reg->name(), s);
+    ss.print("verify_oop: %s: %s (%s:%d)", reg->name(), s, file, line);
     b = code_string(ss.as_string());
   }
   BLOCK_COMMENT("verify_oop {");
@@ -391,7 +391,7 @@ void MacroAssembler::verify_oop(Register reg, const char* s) {
   BLOCK_COMMENT("} verify_oop");
 }
 
-void MacroAssembler::verify_oop_addr(Address addr, const char* s) {
+void MacroAssembler::_verify_oop_addr(Address addr, const char* s, const char* file, int line) {
   if (!VerifyOops) {
     return;
   }
@@ -400,7 +400,7 @@ void MacroAssembler::verify_oop_addr(Address addr, const char* s) {
   {
     ResourceMark rm;
     stringStream ss;
-    ss.print("verify_oop_addr: %s", s);
+    ss.print("verify_oop_addr: %s (%s:%d)", s, file, line);
     b = code_string(ss.as_string());
   }
   BLOCK_COMMENT("verify_oop_addr {");
@@ -1827,7 +1827,7 @@ void MacroAssembler::access_store_at(BasicType type, DecoratorSet decorators,
 
 // Algorithm must match CompressedOops::encode.
 void MacroAssembler::encode_heap_oop(Register d, Register s) {
-  verify_oop(s, "broken oop in encode_heap_oop");
+  verify_oop_msg(s, "broken oop in encode_heap_oop");
   if (CompressedOops::base() == NULL) {
     if (CompressedOops::shift() != 0) {
       assert (LogMinObjAlignmentInBytes == CompressedOops::shift(), "decode alg wrong");
@@ -1985,7 +1985,7 @@ void  MacroAssembler::decode_heap_oop(Register d, Register s) {
     shadd(d, s, xheapbase, d, LogMinObjAlignmentInBytes);
     bind(done);
   }
-  verify_oop(d, "broken oop in decode_heap_oop");
+  verify_oop_msg(d, "broken oop in decode_heap_oop");
 }
 
 void MacroAssembler::store_heap_oop(Address dst, Register src, Register tmp1,