@@ -132,6 +132,13 @@
   void vectortest(int bt, int vlen, XMMRegister src1, XMMRegister src2,
                   XMMRegister vtmp1 = xnoreg, XMMRegister vtmp2 = xnoreg, KRegister mask = knoreg);
 
+ // Covert B2X
+ void vconvert_b2x(BasicType to_elem_bt, XMMRegister dst, XMMRegister src, int vlen_enc);
+#ifdef _LP64
+ void vpbroadcast(BasicType elem_bt, XMMRegister dst, Register src, int vlen_enc);
+#endif
+ void vpadd(BasicType elem_bt, XMMRegister dst, XMMRegister src1, XMMRegister src2, int vlen_enc);
+
   // blend
   void evpcmp(BasicType typ, KRegister kdmask, KRegister ksmask, XMMRegister src1, AddressLiteral adr, int comparison, int vector_len, Register scratch = rscratch1);
   void evpcmp(BasicType typ, KRegister kdmask, KRegister ksmask, XMMRegister src1, XMMRegister src2, int comparison, int vector_len);