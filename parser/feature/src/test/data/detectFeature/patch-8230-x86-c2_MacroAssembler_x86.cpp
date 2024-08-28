@@ -1983,12 +1983,12 @@ void C2_MacroAssembler::reduce8D(int opcode, XMMRegister dst, XMMRegister src, X
   reduce4D(opcode, dst, vtmp1, vtmp1, vtmp2);
 }
 
-void C2_MacroAssembler::evmovdqu(BasicType type, KRegister kmask, XMMRegister dst, Address src, int vector_len) {
-  MacroAssembler::evmovdqu(type, kmask, dst, src, vector_len);
+void C2_MacroAssembler::evmovdqu(BasicType type, KRegister kmask, XMMRegister dst, Address src, bool merge, int vector_len) {
+  MacroAssembler::evmovdqu(type, kmask, dst, src, merge, vector_len);
 }
 
-void C2_MacroAssembler::evmovdqu(BasicType type, KRegister kmask, Address dst, XMMRegister src, int vector_len) {
-  MacroAssembler::evmovdqu(type, kmask, dst, src, vector_len);
+void C2_MacroAssembler::evmovdqu(BasicType type, KRegister kmask, Address dst, XMMRegister src, bool merge, int vector_len) {
+  MacroAssembler::evmovdqu(type, kmask, dst, src, merge, vector_len);
 }
 
 