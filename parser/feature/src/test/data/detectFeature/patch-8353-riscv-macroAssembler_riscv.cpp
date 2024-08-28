@@ -569,24 +569,14 @@ void MacroAssembler::emit_static_call_stub() {
 void MacroAssembler::call_VM_leaf_base(address entry_point,
                                        int number_of_arguments,
                                        Label *retaddr) {
-  call_native_base(entry_point, retaddr);
-}
-
-void MacroAssembler::call_native(address entry_point, Register arg_0) {
-  pass_arg0(this, arg_0);
-  call_native_base(entry_point);
-}
-
-void MacroAssembler::call_native_base(address entry_point, Label *retaddr) {
-  Label E, L;
   int32_t offset = 0;
-  push_reg(0x80000040, sp);   // push << t0 & xmethod >> to sp
+  push_reg(RegSet::of(t0, xmethod), sp);   // push << t0 & xmethod >> to sp
   movptr_with_offset(t0, entry_point, offset);
   jalr(x1, t0, offset);
   if (retaddr != NULL) {
     bind(*retaddr);
   }
-  pop_reg(0x80000040, sp);   // pop << t0 & xmethod >> from sp
+  pop_reg(RegSet::of(t0, xmethod), sp);   // pop << t0 & xmethod >> from sp
 }
 
 void MacroAssembler::call_VM_leaf(address entry_point, int number_of_arguments) {