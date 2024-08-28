@@ -1,5 +1,5 @@
 /*
-* Copyright (c) 2020, 2021, Intel Corporation. All rights reserved.
+* Copyright (c) 2020, 2022, Intel Corporation. All rights reserved.
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
@@ -199,8 +199,8 @@ void MacroAssembler::copy64_masked_avx(Register dst, Register src, XMMRegister x
     mov64(temp, -1L);
     bzhiq(temp, temp, length);
     kmovql(mask, temp);
-    evmovdqu(type[shift], mask, xmm, Address(src, index, scale, offset), Assembler::AVX_512bit);
-    evmovdqu(type[shift], mask, Address(dst, index, scale, offset), xmm, Assembler::AVX_512bit);
+    evmovdqu(type[shift], mask, xmm, Address(src, index, scale, offset), false, Assembler::AVX_512bit);
+    evmovdqu(type[shift], mask, Address(dst, index, scale, offset), xmm, true, Assembler::AVX_512bit);
   }
 }
 
@@ -214,8 +214,8 @@ void MacroAssembler::copy32_masked_avx(Register dst, Register src, XMMRegister x
   mov64(temp, -1L);
   bzhiq(temp, temp, length);
   kmovql(mask, temp);
-  evmovdqu(type[shift], mask, xmm, Address(src, index, scale, offset), Assembler::AVX_256bit);
-  evmovdqu(type[shift], mask, Address(dst, index, scale, offset), xmm, Assembler::AVX_256bit);
+  evmovdqu(type[shift], mask, xmm, Address(src, index, scale, offset), false, Assembler::AVX_256bit);
+  evmovdqu(type[shift], mask, Address(dst, index, scale, offset), xmm, true, Assembler::AVX_256bit);
 }
 
 