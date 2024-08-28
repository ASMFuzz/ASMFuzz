@@ -2577,8 +2577,9 @@ void MacroAssembler::vmovdqu(XMMRegister dst, AddressLiteral src, Register scrat
 }
 
 void MacroAssembler::vmovdqu(XMMRegister dst, AddressLiteral src, Register scratch_reg, int vector_len) {
-  assert(vector_len <= AVX_256bit, "AVX2 vector length");
-  if (vector_len == AVX_256bit) {
+  if (vector_len == AVX_512bit) {
+    evmovdquq(dst, src, AVX_512bit, scratch_reg);
+  } else if (vector_len == AVX_256bit) {
     vmovdqu(dst, src, scratch_reg);
   } else {
     movdqu(dst, src, scratch_reg);
@@ -3229,6 +3230,15 @@ void MacroAssembler::vpbroadcastw(XMMRegister dst, XMMRegister src, int vector_l
   Assembler::vpbroadcastw(dst, src, vector_len);
 }
 
+void MacroAssembler::vpbroadcastq(XMMRegister dst, AddressLiteral src, int vector_len, Register rscratch) {
+  if (reachable(src)) {
+    Assembler::vpbroadcastq(dst, as_Address(src), vector_len);
+  } else {
+    lea(rscratch, src);
+    Assembler::vpbroadcastq(dst, Address(rscratch, 0), vector_len);
+  }
+}
+
 void MacroAssembler::vbroadcastsd(XMMRegister dst, AddressLiteral src, int vector_len, Register rscratch) {
   if (reachable(src)) {
     Assembler::vbroadcastsd(dst, as_Address(src), vector_len);