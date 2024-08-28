@@ -1552,27 +1552,33 @@ class Assembler : public AbstractAssembler  {
   void vmovdqu(XMMRegister dst, XMMRegister src);
 
    // Move Unaligned 512bit Vector
-  void evmovdqub(Address dst, XMMRegister src, bool merge, int vector_len);
-  void evmovdqub(XMMRegister dst, Address src, bool merge, int vector_len);
-  void evmovdqub(XMMRegister dst, XMMRegister src, bool merge, int vector_len);
+  void evmovdqub(XMMRegister dst, XMMRegister src, int vector_len);
+  void evmovdqub(XMMRegister dst, Address src, int vector_len);
+  void evmovdqub(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
   void evmovdqub(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len);
   void evmovdqub(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
-  void evmovdquw(Address dst, XMMRegister src, bool merge, int vector_len);
-  void evmovdquw(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
-  void evmovdquw(XMMRegister dst, Address src, bool merge, int vector_len);
+
+  void evmovdquw(XMMRegister dst, Address src, int vector_len);
+  void evmovdquw(Address dst, XMMRegister src, int vector_len);
+  void evmovdquw(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
   void evmovdquw(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len);
-  void evmovdqul(Address dst, XMMRegister src, int vector_len);
-  void evmovdqul(XMMRegister dst, Address src, int vector_len);
+  void evmovdquw(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+
   void evmovdqul(XMMRegister dst, XMMRegister src, int vector_len);
-  void evmovdqul(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
-  void evmovdqul(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len);
+  void evmovdqul(XMMRegister dst, Address src, int vector_len);
+  void evmovdqul(Address dst, XMMRegister src, int vector_len);
+
   void evmovdqul(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evmovdqul(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len);
+  void evmovdqul(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+
   void evmovdquq(Address dst, XMMRegister src, int vector_len);
   void evmovdquq(XMMRegister dst, Address src, int vector_len);
   void evmovdquq(XMMRegister dst, XMMRegister src, int vector_len);
-  void evmovdquq(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
-  void evmovdquq(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len);
+
   void evmovdquq(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
+  void evmovdquq(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len);
+  void evmovdquq(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len);
 
   // Move lower 64bit to high 64bit in 128bit register
   void movlhps(XMMRegister dst, XMMRegister src);