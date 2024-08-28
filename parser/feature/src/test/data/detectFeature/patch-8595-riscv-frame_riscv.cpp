@@ -259,22 +259,25 @@ bool frame::safe_for_sender(JavaThread *thread) {
 void frame::patch_pc(Thread* thread, address pc) {
   assert(_cb == CodeCache::find_blob(pc), "unexpected pc");
   address* pc_addr = &(((address*) sp())[-1]);
+
   if (TracePcPatching) {
     tty->print_cr("patch_pc at address " INTPTR_FORMAT " [" INTPTR_FORMAT " -> " INTPTR_FORMAT "]",
                   p2i(pc_addr), p2i(*pc_addr), p2i(pc));
   }
+
   // Either the return address is the original one or we are going to
   // patch in the same address that's already there.
-  assert(_pc == *pc_addr || pc == *pc_addr, "must be");
+  assert(_pc == *pc_addr || pc == *pc_addr || *pc_addr == 0, "must be");
+  DEBUG_ONLY(address old_pc = _pc;)
   *pc_addr = pc;
+  _pc = pc; // must be set before call to get_deopt_original_pc
   address original_pc = CompiledMethod::get_deopt_original_pc(this);
   if (original_pc != NULL) {
-    assert(original_pc == _pc, "expected original PC to be stored before patching");
+    assert(original_pc == old_pc, "expected original PC to be stored before patching");
     _deopt_state = is_deoptimized;
-    // leave _pc as is
+    _pc = original_pc;
   } else {
     _deopt_state = not_deoptimized;
-    _pc = pc;
   }
 }
 
@@ -378,6 +381,7 @@ void frame::verify_deopt_original_pc(CompiledMethod* nm, intptr_t* unextended_sp
 
 //------------------------------------------------------------------------------
 // frame::adjust_unextended_sp
+#ifdef ASSERT
 void frame::adjust_unextended_sp() {
   // On riscv, sites calling method handle intrinsics and lambda forms are treated
   // as any other call site. Therefore, no special action is needed when we are
@@ -394,6 +398,8 @@ void frame::adjust_unextended_sp() {
     }
   }
 }
+#endif
+
 
 //------------------------------------------------------------------------------
 // frame::sender_for_interpreter_frame