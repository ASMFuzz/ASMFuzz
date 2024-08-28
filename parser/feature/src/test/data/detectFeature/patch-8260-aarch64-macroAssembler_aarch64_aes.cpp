@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2014, 2021, Red Hat Inc. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -359,7 +359,7 @@ class GHASHMultiplyGenerator: public KernelGenerator {
                          FloatRegister b,
                          /* non-offsetted (shared) registers */
                          FloatRegister a, FloatRegister a1_xor_a0, FloatRegister p, FloatRegister vzr,
-                         /* offseted (temp) registers */
+                         /* offsetted (temp) registers */
                          FloatRegister tmp1, FloatRegister tmp2, FloatRegister tmp3)
     : KernelGenerator(as, unrolls),
       _result_lo(result_lo), _result_hi(result_hi), _b(b),
@@ -436,7 +436,7 @@ class GHASHReduceGenerator: public KernelGenerator {
                        FloatRegister result, FloatRegister lo, FloatRegister hi,
                        /* non-offsetted (shared) registers */
                        FloatRegister p, FloatRegister vzr, FloatRegister data,
-                       /* offseted (temp) registers */
+                       /* offsetted (temp) registers */
                        FloatRegister t1)
     : KernelGenerator(as, unrolls),
       _result(result), _lo(lo), _hi(hi),
@@ -521,7 +521,7 @@ void MacroAssembler::ghash_processBlocks_wide(address field_polynomial, Register
   // everything big-endian or reverse the bits in each byte and do
   // it little-endian.  On AArch64 it's more idiomatic to reverse
   // the bits in each byte (we have an instruction, RBIT, to do
-  // that) and keep the data in little-endian bit order throught the
+  // that) and keep the data in little-endian bit order through the
   // calculation, bit-reversing the inputs and outputs.
 
   assert(unrolls * register_stride < 32, "out of registers");