@@ -119,8 +119,8 @@
   void evgather(BasicType typ, XMMRegister dst, KRegister mask, Register base, XMMRegister idx, int vector_len);
   void evscatter(BasicType typ, Register base, XMMRegister idx, KRegister mask, XMMRegister src, int vector_len);
 
-  void evmovdqu(BasicType type, KRegister kmask, XMMRegister dst, Address src, int vector_len);
-  void evmovdqu(BasicType type, KRegister kmask, Address dst, XMMRegister src, int vector_len);
+  void evmovdqu(BasicType type, KRegister kmask, XMMRegister dst, Address src, bool merge, int vector_len);
+  void evmovdqu(BasicType type, KRegister kmask, Address dst, XMMRegister src, bool merge, int vector_len);
 
   // extract
   void extract(BasicType typ, Register dst, XMMRegister src, int idx);