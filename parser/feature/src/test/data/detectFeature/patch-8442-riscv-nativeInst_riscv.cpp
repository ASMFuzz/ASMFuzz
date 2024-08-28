@@ -339,7 +339,7 @@ void NativeIllegalInstruction::insert(address code_pos) {
 }
 
 bool NativeInstruction::is_stop() {
-  return uint_at(0) == 0xffffffff; // an illegal instruction
+  return uint_at(0) == 0xc0101073; // an illegal instruction, 'csrrw x0, time, x0'
 }
 
 //-------------------------------------------------------------------