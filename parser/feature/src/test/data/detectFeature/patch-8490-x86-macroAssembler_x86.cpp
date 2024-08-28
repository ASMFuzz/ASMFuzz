@@ -5277,10 +5277,28 @@ void MacroAssembler::clear_mem(Register base, int cnt, Register rtmp, XMMRegiste
 
   int vector64_count = (cnt & (~0x7)) >> 3;
   cnt = cnt & 0x7;
+  const int fill64_per_loop = 4;
+  const int max_unrolled_fill64 = 8;
 
   // 64 byte initialization loop.
   vpxor(xtmp, xtmp, xtmp, use64byteVector ? AVX_512bit : AVX_256bit);
-  for (int i = 0; i < vector64_count; i++) {
+  int start64 = 0;
+  if (vector64_count > max_unrolled_fill64) {
+    Label LOOP;
+    Register index = rtmp;
+
+    start64 = vector64_count - (vector64_count % fill64_per_loop);
+
+    movl(index, 0);
+    BIND(LOOP);
+    for (int i = 0; i < fill64_per_loop; i++) {
+      fill64(Address(base, index, Address::times_1, i * 64), xtmp, use64byteVector);
+    }
+    addl(index, fill64_per_loop * 64);
+    cmpl(index, start64 * 64);
+    jccb(Assembler::less, LOOP);
+  }
+  for (int i = start64; i < vector64_count; i++) {
     fill64(base, i * 64, xtmp, use64byteVector);
   }
 
@@ -8874,22 +8892,29 @@ void MacroAssembler::fill32_masked(uint shift, Register dst, int disp,
 }
 
 
-void MacroAssembler::fill32(Register dst, int disp, XMMRegister xmm) {
+void MacroAssembler::fill32(Address dst, XMMRegister xmm) {
   assert(MaxVectorSize >= 32, "vector length should be >= 32");
-  vmovdqu(Address(dst, disp), xmm);
+  vmovdqu(dst, xmm);
 }
 
-void MacroAssembler::fill64(Register dst, int disp, XMMRegister xmm, bool use64byteVector) {
+void MacroAssembler::fill32(Register dst, int disp, XMMRegister xmm) {
+  fill32(Address(dst, disp), xmm);
+}
+
+void MacroAssembler::fill64(Address dst, XMMRegister xmm, bool use64byteVector) {
   assert(MaxVectorSize >= 32, "vector length should be >= 32");
-  BasicType type[] = {T_BYTE,  T_SHORT,  T_INT,   T_LONG};
   if (!use64byteVector) {
-    fill32(dst, disp, xmm);
-    fill32(dst, disp + 32, xmm);
+    fill32(dst, xmm);
+    fill32(dst.plus_disp(32), xmm);
   } else {
-    evmovdquq(Address(dst, disp), xmm, Assembler::AVX_512bit);
+    evmovdquq(dst, xmm, Assembler::AVX_512bit);
   }
 }
 
+void MacroAssembler::fill64(Register dst, int disp, XMMRegister xmm, bool use64byteVector) {
+  fill64(Address(dst, disp), xmm, use64byteVector);
+}
+
 #ifdef _LP64
 void MacroAssembler::generate_fill_avx3(BasicType type, Register to, Register value,
                                         Register count, Register rtmp, XMMRegister xtmp) {