@@ -1998,6 +1998,7 @@ void MacroAssembler::post_call_nop() {
   if (!Continuations::enabled()) {
     return;
   }
+  InstructionMark im(this);
   relocate(post_call_nop_Relocation::spec());
   emit_int8((int8_t)0x0f);
   emit_int8((int8_t)0x1f);