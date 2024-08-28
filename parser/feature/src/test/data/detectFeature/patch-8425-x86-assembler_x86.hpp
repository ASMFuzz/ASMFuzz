@@ -1878,8 +1878,10 @@ class Assembler : public AbstractAssembler  {
   void popcntl(Register dst, Address src);
   void popcntl(Register dst, Register src);
 
-  void vpopcntd(XMMRegister dst, XMMRegister src, int vector_len);
-  void vpopcntq(XMMRegister dst, XMMRegister src, int vector_len);
+  void evpopcntb(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evpopcntw(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evpopcntd(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evpopcntq(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
 
 #ifdef _LP64
   void popcntq(Register dst, Address src);
@@ -1945,6 +1947,12 @@ class Assembler : public AbstractAssembler  {
   void punpckldq(XMMRegister dst, Address src);
   void vpunpckldq(XMMRegister dst, XMMRegister nds, XMMRegister src, int vector_len);
 
+  // Interleave High Word
+  void vpunpckhwd(XMMRegister dst, XMMRegister nds, XMMRegister src, int vector_len);
+
+  // Interleave Low Word
+  void vpunpcklwd(XMMRegister dst, XMMRegister nds, XMMRegister src, int vector_len);
+
   // Interleave High Doublewords
   void vpunpckhdq(XMMRegister dst, XMMRegister nds, XMMRegister src, int vector_len);
 
@@ -2206,9 +2214,8 @@ class Assembler : public AbstractAssembler  {
   void shrxq(Register dst, Register src1, Register src2);
 
   void bzhiq(Register dst, Register src1, Register src2);
-  void pdep(Register dst, Register src1, Register src2);
   void pext(Register dst, Register src1, Register src2);
-
+  void pdep(Register dst, Register src1, Register src2);
 
   //====================VECTOR ARITHMETIC=====================================
   // Add Packed Floating-Point Values
@@ -2437,6 +2444,8 @@ class Assembler : public AbstractAssembler  {
   void evpternlogq(XMMRegister dst, int imm8, KRegister mask, XMMRegister src2, XMMRegister src3, bool merge, int vector_len);
   void evpternlogq(XMMRegister dst, int imm8, KRegister mask, XMMRegister src2, Address src3, bool merge, int vector_len);
 
+  void evplzcntd(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evplzcntq(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
 
   // Sub packed integers
   void psubb(XMMRegister dst, XMMRegister src);
@@ -2581,6 +2590,21 @@ class Assembler : public AbstractAssembler  {
   void vpternlogd(XMMRegister dst, int imm8, XMMRegister src2, Address     src3, int vector_len);
   void vpternlogq(XMMRegister dst, int imm8, XMMRegister src2, XMMRegister src3, int vector_len);
 
+  // Vector compress/expand instructions.
+  void evpcompressb(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evpcompressw(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evpcompressd(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evpcompressq(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evcompressps(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evcompresspd(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+
+  void evpexpandb(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evpexpandw(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evpexpandd(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evpexpandq(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evexpandps(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evexpandpd(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+
   // Vector Rotate Left/Right instruction.
   void evprolvd(XMMRegister dst, XMMRegister src, XMMRegister shift, int vector_len);
   void evprolvq(XMMRegister dst, XMMRegister src, XMMRegister shift, int vector_len);
@@ -2737,6 +2761,10 @@ class Assembler : public AbstractAssembler  {
   void evpblendmw(XMMRegister dst, KRegister mask, XMMRegister nds, XMMRegister src, bool merge, int vector_len);
   void evpblendmd(XMMRegister dst, KRegister mask, XMMRegister nds, XMMRegister src, bool merge, int vector_len);
   void evpblendmq(XMMRegister dst, KRegister mask, XMMRegister nds, XMMRegister src, bool merge, int vector_len);
+
+  // Galois field affine transformation instructions.
+  void vgf2p8affineqb(XMMRegister dst, XMMRegister src2, XMMRegister src3, int imm8, int vector_len);
+
  protected:
   // Next instructions require address alignment 16 bytes SSE mode.
   // They should be called only from corresponding MacroAssembler instructions.