@@ -772,7 +772,7 @@ void MacroAssembler::call_VM(Register oop_result,
 void MacroAssembler::get_vm_result(Register oop_result, Register java_thread) {
   ldr(oop_result, Address(java_thread, JavaThread::vm_result_offset()));
   str(zr, Address(java_thread, JavaThread::vm_result_offset()));
-  verify_oop(oop_result, "broken oop in call_VM_base");
+  verify_oop_msg(oop_result, "broken oop in call_VM_base");
 }
 
 void MacroAssembler::get_vm_result_2(Register metadata_result, Register java_thread) {
@@ -1139,15 +1139,15 @@ void MacroAssembler::clinit_barrier(Register klass, Register scratch, Label* L_f
   }
 }
 
-void MacroAssembler::verify_oop(Register reg, const char* s) {
+void MacroAssembler::_verify_oop(Register reg, const char* s, const char* file, int line) {
   if (!VerifyOops) return;
 
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
@@ -1172,14 +1172,14 @@ void MacroAssembler::verify_oop(Register reg, const char* s) {
   BLOCK_COMMENT("} verify_oop");
 }
 
-void MacroAssembler::verify_oop_addr(Address addr, const char* s) {
+void MacroAssembler::_verify_oop_addr(Address addr, const char* s, const char* file, int line) {
   if (!VerifyOops) return;
 
   const char* b = NULL;
   {
     ResourceMark rm;
     stringStream ss;
-    ss.print("verify_oop_addr: %s", s);
+    ss.print("verify_oop_addr: %s (%s:%d)", s, file, line);
     b = code_string(ss.as_string());
   }
   BLOCK_COMMENT("verify_oop_addr {");
@@ -3792,7 +3792,7 @@ void MacroAssembler::encode_heap_oop(Register d, Register s) {
 #ifdef ASSERT
   verify_heapbase("MacroAssembler::encode_heap_oop: heap base corrupted?");
 #endif
-  verify_oop(s, "broken oop in encode_heap_oop");
+  verify_oop_msg(s, "broken oop in encode_heap_oop");
   if (CompressedOops::base() == NULL) {
     if (CompressedOops::shift() != 0) {
       assert (LogMinObjAlignmentInBytes == CompressedOops::shift(), "decode alg wrong");
@@ -3825,7 +3825,7 @@ void MacroAssembler::encode_heap_oop_not_null(Register r) {
     bind(ok);
   }
 #endif
-  verify_oop(r, "broken oop in encode_heap_oop_not_null");
+  verify_oop_msg(r, "broken oop in encode_heap_oop_not_null");
   if (CompressedOops::base() != NULL) {
     sub(r, r, rheapbase);
   }
@@ -3845,7 +3845,7 @@ void MacroAssembler::encode_heap_oop_not_null(Register dst, Register src) {
     bind(ok);
   }
 #endif
-  verify_oop(src, "broken oop in encode_heap_oop_not_null2");
+  verify_oop_msg(src, "broken oop in encode_heap_oop_not_null2");
 
   Register data = src;
   if (CompressedOops::base() != NULL) {
@@ -3877,7 +3877,7 @@ void  MacroAssembler::decode_heap_oop(Register d, Register s) {
     add(d, rheapbase, s, Assembler::LSL, LogMinObjAlignmentInBytes);
     bind(done);
   }
-  verify_oop(d, "broken oop in decode_heap_oop");
+  verify_oop_msg(d, "broken oop in decode_heap_oop");
 }
 
 void  MacroAssembler::decode_heap_oop_not_null(Register r) {