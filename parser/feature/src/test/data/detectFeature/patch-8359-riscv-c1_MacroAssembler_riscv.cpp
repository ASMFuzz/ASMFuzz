@@ -342,7 +342,7 @@ void C1_MacroAssembler::verify_stack_oop(int stack_offset) {
   if (!VerifyOops) {
     return;
   }
-  verify_oop_addr(Address(sp, stack_offset), "oop");
+  verify_oop_addr(Address(sp, stack_offset));
 }
 
 void C1_MacroAssembler::verify_not_null_oop(Register r) {