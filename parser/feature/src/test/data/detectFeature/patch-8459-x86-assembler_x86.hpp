@@ -2746,6 +2746,10 @@ class Assembler : public AbstractAssembler  {
   void evpmovm2d(XMMRegister dst, KRegister src, int vector_len);
   void evpmovm2q(XMMRegister dst, KRegister src, int vector_len);
 
+  // floating point class tests
+  void vfpclassss(KRegister kdst, XMMRegister src, uint8_t imm8);
+  void vfpclasssd(KRegister kdst, XMMRegister src, uint8_t imm8);
+
   // Vector blends
   void blendvps(XMMRegister dst, XMMRegister src);
   void blendvpd(XMMRegister dst, XMMRegister src);