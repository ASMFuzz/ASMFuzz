@@ -1,4 +1,4 @@
-/* Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
+/* Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2018, Cavium. All rights reserved. (By BELLSOFT)
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -431,7 +431,7 @@ void MacroAssembler::generate__ieee754_rem_pio2(address npio2_hw,
 // *                      z    = (z-x[i])*2**24
 // *
 // *
-// *      y[]     ouput result in an array of double precision numbers.
+// *      y[]     output result in an array of double precision numbers.
 // *              The dimension of y[] is:
 // *                      24-bit  precision       1
 // *                      53-bit  precision       2
@@ -450,7 +450,7 @@ void MacroAssembler::generate__ieee754_rem_pio2(address npio2_hw,
 // *
 // *      nx      dimension of x[]
 // *
-// *      prec    an interger indicating the precision:
+// *      prec    an integer indicating the precision:
 // *                      0       24  bits (single)
 // *                      1       53  bits (double)
 // *                      2       64  bits (extended)
@@ -667,7 +667,7 @@ void MacroAssembler::generate__ieee754_rem_pio2(address npio2_hw,
 // Changes between fdlibm and intrinsic:
 //     1. One loop is unrolled and vectorized (see comments in code)
 //     2. One loop is split into 2 loops (see comments in code)
-//     3. Non-double code is removed(last switch). Sevaral variables became
+//     3. Non-double code is removed(last switch). Several variables became
 //         constants because of that (see comments in code)
 //     4. Use of jx, which is nx-1 instead of nx
 // Assumptions:
@@ -999,7 +999,7 @@ void MacroAssembler::generate__kernel_rem_pio2(address two_over_pi, address pio2
       block_comment("else block of if(z==0.0) {"); {
         bind(RECOMP_CHECK_DONE_NOT_ZERO);
           fmuld(v18, v18, v22);
-          fcmpd(v18, v24);                                   // v24 is stil two24A
+          fcmpd(v18, v24);                                   // v24 is still two24A
           br(LT, Z_IS_LESS_THAN_TWO24B);
           fmuld(v1, v18, v17);                               // twon24*z
           frintzd(v1, v1);                                   // v1 = (double)(int)(v1)
@@ -1180,7 +1180,7 @@ void MacroAssembler::generate__kernel_rem_pio2(address two_over_pi, address pio2
 //     3. C code parameter "int iy" was modified to "bool iyIsOne", because
 //         iy is always 0 or 1. Also, iyIsOne branch was moved into
 //         generation phase instead of taking it during code execution
-// Input ans output:
+// Input and output:
 //     1. Input for generated function: X argument = x
 //     2. Input for generator: x = register to read argument from, iyIsOne
 //         = flag to use low argument low part or not, dsin_coef = coefficients
@@ -1405,7 +1405,7 @@ void MacroAssembler::generate_kernel_cos(FloatRegister x, address dcos_coef) {
 // Changes between fdlibm and intrinsic:
 //     1. Moved ix < 2**27 from kernel_sin/kernel_cos into dsin/dcos
 //     2. Final switch use equivalent bit checks(tbz/tbnz)
-// Input ans output:
+// Input and output:
 //     1. Input for generated function: X = r0
 //     2. Input for generator: isCos = generate sin or cos, npio2_hw = address
 //         of npio2_hw table, two_over_pi = address of two_over_pi table,