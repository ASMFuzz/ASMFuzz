@@ -4202,7 +4202,7 @@ void MacroAssembler::movoop(Register dst, jobject obj, bool immediate) {
   // ordered with respected to oop accesses.
   // Using immediate literals would necessitate ISBs.
   BarrierSet* bs = BarrierSet::barrier_set();
-  if ((bs->barrier_set_nmethod() != NULL && bs->barrier_set_assembler()->nmethod_code_patching()) || !immediate) {
+  if ((bs->barrier_set_nmethod() != NULL && !bs->barrier_set_assembler()->nmethod_code_patching()) || !immediate) {
     address dummy = address(uintptr_t(pc()) & -wordSize); // A nearby aligned address
     ldr_constant(dst, Address(dummy, rspec));
   } else