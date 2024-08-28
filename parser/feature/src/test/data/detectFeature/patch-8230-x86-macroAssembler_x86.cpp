@@ -2606,18 +2606,10 @@ void MacroAssembler::kmovwl(KRegister dst, AddressLiteral src, Register scratch_
 void MacroAssembler::evmovdqub(XMMRegister dst, KRegister mask, AddressLiteral src, bool merge,
                                int vector_len, Register scratch_reg) {
   if (reachable(src)) {
-    if (mask == k0) {
-      Assembler::evmovdqub(dst, as_Address(src), merge, vector_len);
-    } else {
-      Assembler::evmovdqub(dst, mask, as_Address(src), merge, vector_len);
-    }
+    Assembler::evmovdqub(dst, mask, as_Address(src), merge, vector_len);
   } else {
     lea(scratch_reg, src);
-    if (mask == k0) {
-      Assembler::evmovdqub(dst, Address(scratch_reg, 0), merge, vector_len);
-    } else {
-      Assembler::evmovdqub(dst, mask, Address(scratch_reg, 0), merge, vector_len);
-    }
+    Assembler::evmovdqub(dst, mask, Address(scratch_reg, 0), merge, vector_len);
   }
 }
 
@@ -5292,46 +5284,46 @@ void MacroAssembler::clear_mem(Register base, int cnt, Register rtmp, XMMRegiste
         movq(Address(base, disp), xtmp);
         break;
       case 2:
-        evmovdqu(T_LONG, k0, Address(base, disp), xtmp, Assembler::AVX_128bit);
+        evmovdqu(T_LONG, k0, Address(base, disp), xtmp, false, Assembler::AVX_128bit);
         break;
       case 3:
         movl(rtmp, 0x7);
         kmovwl(mask, rtmp);
-        evmovdqu(T_LONG, mask, Address(base, disp), xtmp, Assembler::AVX_256bit);
+        evmovdqu(T_LONG, mask, Address(base, disp), xtmp, true, Assembler::AVX_256bit);
         break;
       case 4:
-        evmovdqu(T_LONG, k0, Address(base, disp), xtmp, Assembler::AVX_256bit);
+        evmovdqu(T_LONG, k0, Address(base, disp), xtmp, false, Assembler::AVX_256bit);
         break;
       case 5:
         if (use64byteVector) {
           movl(rtmp, 0x1F);
           kmovwl(mask, rtmp);
-          evmovdqu(T_LONG, mask, Address(base, disp), xtmp, Assembler::AVX_512bit);
+          evmovdqu(T_LONG, mask, Address(base, disp), xtmp, true, Assembler::AVX_512bit);
         } else {
-          evmovdqu(T_LONG, k0, Address(base, disp), xtmp, Assembler::AVX_256bit);
+          evmovdqu(T_LONG, k0, Address(base, disp), xtmp, false, Assembler::AVX_256bit);
           movq(Address(base, disp + 32), xtmp);
         }
         break;
       case 6:
         if (use64byteVector) {
           movl(rtmp, 0x3F);
           kmovwl(mask, rtmp);
-          evmovdqu(T_LONG, mask, Address(base, disp), xtmp, Assembler::AVX_512bit);
+          evmovdqu(T_LONG, mask, Address(base, disp), xtmp, true, Assembler::AVX_512bit);
         } else {
-          evmovdqu(T_LONG, k0, Address(base, disp), xtmp, Assembler::AVX_256bit);
-          evmovdqu(T_LONG, k0, Address(base, disp + 32), xtmp, Assembler::AVX_128bit);
+          evmovdqu(T_LONG, k0, Address(base, disp), xtmp, false, Assembler::AVX_256bit);
+          evmovdqu(T_LONG, k0, Address(base, disp + 32), xtmp, false, Assembler::AVX_128bit);
         }
         break;
       case 7:
         if (use64byteVector) {
           movl(rtmp, 0x7F);
           kmovwl(mask, rtmp);
-          evmovdqu(T_LONG, mask, Address(base, disp), xtmp, Assembler::AVX_512bit);
+          evmovdqu(T_LONG, mask, Address(base, disp), xtmp, true, Assembler::AVX_512bit);
         } else {
-          evmovdqu(T_LONG, k0, Address(base, disp), xtmp, Assembler::AVX_256bit);
+          evmovdqu(T_LONG, k0, Address(base, disp), xtmp, false, Assembler::AVX_256bit);
           movl(rtmp, 0x7);
           kmovwl(mask, rtmp);
-          evmovdqu(T_LONG, mask, Address(base, disp + 32), xtmp, Assembler::AVX_256bit);
+          evmovdqu(T_LONG, mask, Address(base, disp + 32), xtmp, true, Assembler::AVX_256bit);
         }
         break;
       default:
@@ -6303,7 +6295,7 @@ void MacroAssembler::vectorized_mismatch(Register obja, Register objb, Register
 
     bind(VECTOR64_LOOP);
     // AVX512 code to compare 64 byte vectors.
-    evmovdqub(rymm0, Address(obja, result), false, Assembler::AVX_512bit);
+    evmovdqub(rymm0, Address(obja, result), Assembler::AVX_512bit);
     evpcmpeqb(k7, rymm0, Address(objb, result), Assembler::AVX_512bit);
     kortestql(k7, k7);
     jcc(Assembler::aboveEqual, VECTOR64_NOT_EQUAL);     // mismatch
@@ -8144,7 +8136,7 @@ void MacroAssembler::char_array_compress(Register src, Register dst, Register le
     negptr(len);
 
     bind(copy_32_loop);
-    evmovdquw(tmp1Reg, Address(src, len, Address::times_2), /*merge*/ false, Assembler::AVX_512bit);
+    evmovdquw(tmp1Reg, Address(src, len, Address::times_2), Assembler::AVX_512bit);
     evpcmpuw(mask1, tmp1Reg, tmp2Reg, Assembler::le, Assembler::AVX_512bit);
     kortestdl(mask1, mask1);
     jcc(Assembler::carryClear, return_zero);
@@ -8314,7 +8306,7 @@ void MacroAssembler::byte_array_inflate(Register src, Register dst, Register len
     // inflate 32 chars per iter
     bind(copy_32_loop);
     vpmovzxbw(tmp1, Address(src, len, Address::times_1), Assembler::AVX_512bit);
-    evmovdquw(Address(dst, len, Address::times_2), tmp1, /*merge*/ false, Assembler::AVX_512bit);
+    evmovdquw(Address(dst, len, Address::times_2), tmp1, Assembler::AVX_512bit);
     addptr(len, 32);
     jcc(Assembler::notZero, copy_32_loop);
 
@@ -8416,47 +8408,47 @@ void MacroAssembler::byte_array_inflate(Register src, Register dst, Register len
 }
 
 
-void MacroAssembler::evmovdqu(BasicType type, KRegister kmask, XMMRegister dst, Address src, int vector_len) {
+void MacroAssembler::evmovdqu(BasicType type, KRegister kmask, XMMRegister dst, Address src, bool merge, int vector_len) {
   switch(type) {
     case T_BYTE:
     case T_BOOLEAN:
-      evmovdqub(dst, kmask, src, false, vector_len);
+      evmovdqub(dst, kmask, src, merge, vector_len);
       break;
     case T_CHAR:
     case T_SHORT:
-      evmovdquw(dst, kmask, src, false, vector_len);
+      evmovdquw(dst, kmask, src, merge, vector_len);
       break;
     case T_INT:
     case T_FLOAT:
-      evmovdqul(dst, kmask, src, false, vector_len);
+      evmovdqul(dst, kmask, src, merge, vector_len);
       break;
     case T_LONG:
     case T_DOUBLE:
-      evmovdquq(dst, kmask, src, false, vector_len);
+      evmovdquq(dst, kmask, src, merge, vector_len);
       break;
     default:
       fatal("Unexpected type argument %s", type2name(type));
       break;
   }
 }
 
-void MacroAssembler::evmovdqu(BasicType type, KRegister kmask, Address dst, XMMRegister src, int vector_len) {
+void MacroAssembler::evmovdqu(BasicType type, KRegister kmask, Address dst, XMMRegister src, bool merge, int vector_len) {
   switch(type) {
     case T_BYTE:
     case T_BOOLEAN:
-      evmovdqub(dst, kmask, src, true, vector_len);
+      evmovdqub(dst, kmask, src, merge, vector_len);
       break;
     case T_CHAR:
     case T_SHORT:
-      evmovdquw(dst, kmask, src, true, vector_len);
+      evmovdquw(dst, kmask, src, merge, vector_len);
       break;
     case T_INT:
     case T_FLOAT:
-      evmovdqul(dst, kmask, src, true, vector_len);
+      evmovdqul(dst, kmask, src, merge, vector_len);
       break;
     case T_LONG:
     case T_DOUBLE:
-      evmovdquq(dst, kmask, src, true, vector_len);
+      evmovdquq(dst, kmask, src, merge, vector_len);
       break;
     default:
       fatal("Unexpected type argument %s", type2name(type));
@@ -8845,7 +8837,7 @@ void MacroAssembler::fill_masked(BasicType bt, Address dst, XMMRegister xmm, KRe
   movptr(temp, -1);
   bzhiq(temp, temp, length);
   kmov(mask, temp);
-  evmovdqu(bt, mask, dst, xmm, vec_enc);
+  evmovdqu(bt, mask, dst, xmm, true, vec_enc);
 }
 
 // Set memory operation for length "less than" 64 bytes.
@@ -8970,7 +8962,7 @@ void MacroAssembler::generate_fill_avx3(BasicType type, Register to, Register va
       mov64(r8, -1L);
       bzhiq(r8, r8, rtmp);
       kmovql(k2, r8);
-      evmovdqu(T_BYTE, k2, Address(to, 0), xtmp, Assembler::AVX_256bit);
+      evmovdqu(T_BYTE, k2, Address(to, 0), xtmp, true, Assembler::AVX_256bit);
       addq(to, rtmp);
       shrq(rtmp, shift);
       subq(count, rtmp);
@@ -9040,7 +9032,7 @@ void MacroAssembler::generate_fill_avx3(BasicType type, Register to, Register va
       mov64(r8, -1L);
       bzhiq(r8, r8, rtmp);
       kmovql(k2, r8);
-      evmovdqu(T_BYTE, k2, Address(to, 0), xtmp, Assembler::AVX_512bit);
+      evmovdqu(T_BYTE, k2, Address(to, 0), xtmp, true, Assembler::AVX_512bit);
       addq(to, rtmp);
       shrq(rtmp, shift);
       subq(count, rtmp);