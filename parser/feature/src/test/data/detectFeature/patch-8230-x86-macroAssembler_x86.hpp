@@ -1147,49 +1147,64 @@ class MacroAssembler: public Assembler {
 
 
   // AVX512 Unaligned
-  void evmovdqu(BasicType type, KRegister kmask, Address dst, XMMRegister src, int vector_len);
-  void evmovdqu(BasicType type, KRegister kmask, XMMRegister dst, Address src, int vector_len);
-
-  void evmovdqub(Address dst, XMMRegister src, bool merge, int vector_len) { Assembler::evmovdqub(dst, src, merge, vector_len); }
-  void evmovdqub(XMMRegister dst, Address src, bool merge, int vector_len) { Assembler::evmovdqub(dst, src, merge, vector_len); }
-  void evmovdqub(XMMRegister dst, XMMRegister src, bool merge, int vector_len) { Assembler::evmovdqub(dst, src, merge, vector_len); }
+  void evmovdqu(BasicType type, KRegister kmask, Address dst, XMMRegister src,  bool merge, int vector_len);
+  void evmovdqu(BasicType type, KRegister kmask, XMMRegister dst, Address src, bool merge, int vector_len);
+
+  void evmovdqub(XMMRegister dst, XMMRegister src, int vector_len) { Assembler::evmovdqub(dst, src, vector_len); }
+  void evmovdqub(XMMRegister dst, Address src, int vector_len) { Assembler::evmovdqub(dst, src, vector_len); }
+  void evmovdqub(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+    if (dst->encoding() != src->encoding() || mask != k0)  {
+      Assembler::evmovdqub(dst, mask, src, merge, vector_len);
+    }
+  }
   void evmovdqub(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len) { Assembler::evmovdqub(dst, mask, src, merge, vector_len); }
   void evmovdqub(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len) { Assembler::evmovdqub(dst, mask, src, merge, vector_len); }
   void evmovdqub(XMMRegister dst, KRegister mask, AddressLiteral src, bool merge, int vector_len, Register scratch_reg);
 
-  void evmovdquw(Address dst, XMMRegister src, bool merge, int vector_len) { Assembler::evmovdquw(dst, src, merge, vector_len); }
-  void evmovdquw(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len) { Assembler::evmovdquw(dst, mask, src, merge, vector_len); }
-  void evmovdquw(XMMRegister dst, Address src, bool merge, int vector_len) { Assembler::evmovdquw(dst, src, merge, vector_len); }
+  void evmovdquw(XMMRegister dst, Address src, int vector_len) { Assembler::evmovdquw(dst, src, vector_len); }
+  void evmovdquw(Address dst, XMMRegister src, int vector_len) { Assembler::evmovdquw(dst, src, vector_len); }
+  void evmovdquw(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+    if (dst->encoding() != src->encoding() || mask != k0) {
+      Assembler::evmovdquw(dst, mask, src, merge, vector_len);
+    }
+  }
   void evmovdquw(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len) { Assembler::evmovdquw(dst, mask, src, merge, vector_len); }
+  void evmovdquw(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len) { Assembler::evmovdquw(dst, mask, src, merge, vector_len); }
   void evmovdquw(XMMRegister dst, KRegister mask, AddressLiteral src, bool merge, int vector_len, Register scratch_reg);
 
+  void evmovdqul(XMMRegister dst, XMMRegister src, int vector_len) {
+     if (dst->encoding() != src->encoding()) {
+       Assembler::evmovdqul(dst, src, vector_len);
+     }
+  }
   void evmovdqul(Address dst, XMMRegister src, int vector_len) { Assembler::evmovdqul(dst, src, vector_len); }
   void evmovdqul(XMMRegister dst, Address src, int vector_len) { Assembler::evmovdqul(dst, src, vector_len); }
-  void evmovdqul(XMMRegister dst, XMMRegister src, int vector_len) {
-     if (dst->encoding() == src->encoding()) return;
-     Assembler::evmovdqul(dst, src, vector_len);
+
+  void evmovdqul(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+    if (dst->encoding() != src->encoding() || mask != k0)  {
+      Assembler::evmovdqul(dst, mask, src, merge, vector_len);
+    }
   }
-  void evmovdqul(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len) { Assembler::evmovdqul(dst, mask, src, merge, vector_len); }
   void evmovdqul(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len) { Assembler::evmovdqul(dst, mask, src, merge, vector_len); }
-  void evmovdqul(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
-    if (dst->encoding() == src->encoding() && mask == k0) return;
-    Assembler::evmovdqul(dst, mask, src, merge, vector_len);
-   }
+  void evmovdqul(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len) { Assembler::evmovdqul(dst, mask, src, merge, vector_len); }
   void evmovdqul(XMMRegister dst, KRegister mask, AddressLiteral src, bool merge, int vector_len, Register scratch_reg);
 
+  void evmovdquq(XMMRegister dst, XMMRegister src, int vector_len) {
+    if (dst->encoding() != src->encoding()) {
+      Assembler::evmovdquq(dst, src, vector_len);
+    }
+  }
   void evmovdquq(XMMRegister dst, Address src, int vector_len) { Assembler::evmovdquq(dst, src, vector_len); }
   void evmovdquq(Address dst, XMMRegister src, int vector_len) { Assembler::evmovdquq(dst, src, vector_len); }
   void evmovdquq(XMMRegister dst, AddressLiteral src, int vector_len, Register rscratch);
-  void evmovdquq(XMMRegister dst, XMMRegister src, int vector_len) {
-    if (dst->encoding() == src->encoding()) return;
-    Assembler::evmovdquq(dst, src, vector_len);
-  }
-  void evmovdquq(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len) { Assembler::evmovdquq(dst, mask, src, merge, vector_len); }
-  void evmovdquq(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len) { Assembler::evmovdquq(dst, mask, src, merge, vector_len); }
+
   void evmovdquq(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
-    if (dst->encoding() == src->encoding() && mask == k0) return;
-    Assembler::evmovdquq(dst, mask, src, merge, vector_len);
+    if (dst->encoding() != src->encoding() || mask != k0) {
+      Assembler::evmovdquq(dst, mask, src, merge, vector_len);
+    }
   }
+  void evmovdquq(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len) { Assembler::evmovdquq(dst, mask, src, merge, vector_len); }
+  void evmovdquq(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len) { Assembler::evmovdquq(dst, mask, src, merge, vector_len); }
   void evmovdquq(XMMRegister dst, KRegister mask, AddressLiteral src, bool merge, int vector_len, Register scratch_reg);
 
   // Move Aligned Double Quadword