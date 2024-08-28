@@ -186,7 +186,7 @@ void ShenandoahBarrierSetAssembler::resolve_forward_pointer(MacroAssembler* masm
   __ bind(is_null);
 }
 
-// IMPORTANT: This must preserve all registers, even rscratch1 and rscratch2, except those explicitely
+// IMPORTANT: This must preserve all registers, even rscratch1 and rscratch2, except those explicitly
 // passed in.
 void ShenandoahBarrierSetAssembler::resolve_forward_pointer_not_null(MacroAssembler* masm, Register dst, Register tmp) {
   assert(ShenandoahLoadRefBarrier || ShenandoahCASBarrier, "Should be enabled");