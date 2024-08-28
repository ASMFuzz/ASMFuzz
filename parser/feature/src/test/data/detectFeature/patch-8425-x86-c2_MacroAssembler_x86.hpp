@@ -88,6 +88,11 @@
                  XMMRegister zero, XMMRegister one,
                  Register scratch);
 
+  void vector_compress_expand(int opcode, XMMRegister dst, XMMRegister src, KRegister mask,
+                              bool merge, BasicType bt, int vec_enc);
+
+  void vector_mask_compress(KRegister dst, KRegister src, Register rtmp1, Register rtmp2, int mask_len);
+
   void vextendbw(bool sign, XMMRegister dst, XMMRegister src, int vector_len);
   void vextendbw(bool sign, XMMRegister dst, XMMRegister src);
   void vextendbd(bool sign, XMMRegister dst, XMMRegister src, int vector_len);
@@ -137,7 +142,6 @@
 #ifdef _LP64
  void vpbroadcast(BasicType elem_bt, XMMRegister dst, Register src, int vlen_enc);
 #endif
- void vpadd(BasicType elem_bt, XMMRegister dst, XMMRegister src1, XMMRegister src2, int vlen_enc);
 
   // blend
   void evpcmp(BasicType typ, KRegister kdmask, KRegister ksmask, XMMRegister src1, AddressLiteral adr, int comparison, int vector_len, Register scratch = rscratch1);
@@ -341,34 +345,89 @@
                               AddressLiteral new_mxcsr, Register scratch, int vec_enc);
 #endif
 
+  void udivI(Register rax, Register divisor, Register rdx);
+  void umodI(Register rax, Register divisor, Register rdx);
+  void udivmodI(Register rax, Register divisor, Register rdx, Register tmp);
+
+#ifdef _LP64
+  void udivL(Register rax, Register divisor, Register rdx);
+  void umodL(Register rax, Register divisor, Register rdx);
+  void udivmodL(Register rax, Register divisor, Register rdx, Register tmp);
+#endif
+
   void evpternlog(XMMRegister dst, int func, KRegister mask, XMMRegister src2, XMMRegister src3,
                   bool merge, BasicType bt, int vlen_enc);
 
   void evpternlog(XMMRegister dst, int func, KRegister mask, XMMRegister src2, Address src3,
                   bool merge, BasicType bt, int vlen_enc);
 
-  void vector_signum_avx(int opcode, XMMRegister dst, XMMRegister src, XMMRegister zero, XMMRegister one,
-                         XMMRegister xtmp1, int vec_enc);
+  void vector_reverse_bit(BasicType bt, XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                          XMMRegister xtmp2, Register rtmp, int vec_enc);
 
-  void vector_signum_evex(int opcode, XMMRegister dst, XMMRegister src, XMMRegister zero, XMMRegister one,
-                          KRegister ktmp1, int vec_enc);
+  void vector_reverse_bit_gfni(BasicType bt, XMMRegister dst, XMMRegister src, XMMRegister xtmp,
+                               AddressLiteral mask, Register rtmp, int vec_enc);
 
-  void udivI(Register rax, Register divisor, Register rdx);
-  void umodI(Register rax, Register divisor, Register rdx);
-  void udivmodI(Register rax, Register divisor, Register rdx, Register tmp);
-
-  #ifdef _LP64
-  void udivL(Register rax, Register divisor, Register rdx);
-  void umodL(Register rax, Register divisor, Register rdx);
-  void udivmodL(Register rax, Register divisor, Register rdx, Register tmp);
-  #endif
+  void vector_reverse_byte(BasicType bt, XMMRegister dst, XMMRegister src, Register rtmp, int vec_enc);
 
   void vector_popcount_int(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
-                           XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp,
-                           int vec_enc);
+                           XMMRegister xtmp2, Register rtmp, int vec_enc);
 
   void vector_popcount_long(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
-                            XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp,
-                            int vec_enc);
+                            XMMRegister xtmp2, Register rtmp, int vec_enc);
 
+  void vector_popcount_short(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                             XMMRegister xtmp2, Register rtmp, int vec_enc);
+
+  void vector_popcount_byte(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                            XMMRegister xtmp2, Register rtmp, int vec_enc);
+
+  void vector_popcount_integral(BasicType bt, XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                XMMRegister xtmp2, Register rtmp, int vec_enc);
+
+  void vector_popcount_integral_evex(BasicType bt, XMMRegister dst, XMMRegister src,
+                                     KRegister mask, bool merge, int vec_enc);
+
+  void vbroadcast(BasicType bt, XMMRegister dst, int imm32, Register rtmp, int vec_enc);
+
+  void vector_reverse_byte64(BasicType bt, XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                             XMMRegister xtmp2, Register rtmp, int vec_enc);
+
+  void vector_count_leading_zeros_evex(BasicType bt, XMMRegister dst, XMMRegister src,
+                                       XMMRegister xtmp1, XMMRegister xtmp2, XMMRegister xtmp3,
+                                       KRegister ktmp, Register rtmp, bool merge, int vec_enc);
+
+  void vector_count_leading_zeros_byte_avx(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                           XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp, int vec_enc);
+
+  void vector_count_leading_zeros_short_avx(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                            XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp, int vec_enc);
+
+  void vector_count_leading_zeros_int_avx(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                          XMMRegister xtmp2, XMMRegister xtmp3, int vec_enc);
+
+  void vector_count_leading_zeros_long_avx(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                           XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp, int vec_enc);
+
+  void vector_count_leading_zeros_avx(BasicType bt, XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                      XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp, int vec_enc);
+
+  void vpadd(BasicType bt, XMMRegister dst, XMMRegister src1, XMMRegister src2, int vec_enc);
+
+  void vpsub(BasicType bt, XMMRegister dst, XMMRegister src1, XMMRegister src2, int vec_enc);
+
+  void vector_count_trailing_zeros_evex(BasicType bt, XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                        XMMRegister xtmp2, XMMRegister xtmp3, XMMRegister xtmp4, KRegister ktmp,
+                                        Register rtmp, int vec_enc);
+
+  void vector_swap_nbits(int nbits, int bitmask, XMMRegister dst, XMMRegister src,
+                         XMMRegister xtmp1, Register rtmp, int vec_enc);
+
+  void vector_count_trailing_zeros_avx(BasicType bt, XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                       XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp, int vec_enc);
+
+  void vector_signum_avx(int opcode, XMMRegister dst, XMMRegister src, XMMRegister zero, XMMRegister one,
+                         XMMRegister xtmp1, int vec_enc);
+
+  void vector_signum_evex(int opcode, XMMRegister dst, XMMRegister src, XMMRegister zero, XMMRegister one,
+                          KRegister ktmp1, int vec_enc);
 #endif // CPU_X86_C2_MACROASSEMBLER_X86_HPP