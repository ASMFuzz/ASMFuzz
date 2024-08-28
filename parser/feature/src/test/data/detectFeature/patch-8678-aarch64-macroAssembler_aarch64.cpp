@@ -830,6 +830,7 @@ void MacroAssembler::post_call_nop() {
   if (!Continuations::enabled()) {
     return;
   }
+  InstructionMark im(this);
   relocate(post_call_nop_Relocation::spec());
   nop();
 }