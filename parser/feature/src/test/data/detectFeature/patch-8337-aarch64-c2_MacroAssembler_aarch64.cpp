@@ -958,32 +958,74 @@ void C2_MacroAssembler::bytemask_compress(Register dst) {
 
 // Pack the lowest-numbered bit of each mask element in src into a long value
 // in dst, at most the first 64 lane elements.
-// Clobbers: rscratch1
+// Clobbers: rscratch1 if hardware doesn't support FEAT_BITPERM.
 void C2_MacroAssembler::sve_vmask_tolong(Register dst, PRegister src, BasicType bt, int lane_cnt,
                                          FloatRegister vtmp1, FloatRegister vtmp2) {
   assert(lane_cnt <= 64 && is_power_of_2(lane_cnt), "Unsupported lane count");
   assert_different_registers(dst, rscratch1);
   assert_different_registers(vtmp1, vtmp2);
 
   Assembler::SIMD_RegVariant size = elemType_to_regVariant(bt);
+  // Example:   src = 0b01100101 10001101, bt = T_BYTE, lane_cnt = 16
+  // Expected:  dst = 0x658D
 
-  // Pack the mask into vector with sequential bytes.
+  // Convert the mask into vector with sequential bytes.
+  // vtmp1 = 0x00010100 0x00010001 0x01000000 0x01010001
   sve_cpy(vtmp1, size, src, 1, false);
   if (bt != T_BYTE) {
     sve_vector_narrow(vtmp1, B, vtmp1, size, vtmp2);
   }
 
-  // Compress the lowest 8 bytes.
-  fmovd(dst, vtmp1);
-  bytemask_compress(dst);
-  if (lane_cnt <= 8) return;
-
-  // Repeat on higher bytes and join the results.
-  // Compress 8 bytes in each iteration.
-  for (int idx = 1; idx < (lane_cnt / 8); idx++) {
-    sve_extract_integral(rscratch1, D, vtmp1, idx, /* is_signed */ false, vtmp2);
-    bytemask_compress(rscratch1);
-    orr(dst, dst, rscratch1, Assembler::LSL, idx << 3);
+  if (UseSVE > 0 && !VM_Version::supports_svebitperm()) {
+    // Compress the lowest 8 bytes.
+    fmovd(dst, vtmp1);
+    bytemask_compress(dst);
+    if (lane_cnt <= 8) return;
+
+    // Repeat on higher bytes and join the results.
+    // Compress 8 bytes in each iteration.
+    for (int idx = 1; idx < (lane_cnt / 8); idx++) {
+      sve_extract_integral(rscratch1, D, vtmp1, idx, /* is_signed */ false, vtmp2);
+      bytemask_compress(rscratch1);
+      orr(dst, dst, rscratch1, Assembler::LSL, idx << 3);
+    }
+  } else if (UseSVE == 2 && VM_Version::supports_svebitperm()) {
+    // Given by the vector with value 0x00 or 0x01 in each byte, the basic idea
+    // is to compress each significant bit of the byte in a cross-lane way. Due
+    // to the lack of cross-lane bit-compress instruction, here we use BEXT
+    // (bit-compress in each lane) with the biggest lane size (T = D) and
+    // concatenates the results then.
+
+    // The second source input of BEXT, initialized with 0x01 in each byte.
+    // vtmp2 = 0x01010101 0x01010101 0x01010101 0x01010101
+    sve_dup(vtmp2, B, 1);
+
+    // BEXT vtmp1.D, vtmp1.D, vtmp2.D
+    // vtmp1 = 0x0001010000010001 | 0x0100000001010001
+    // vtmp2 = 0x0101010101010101 | 0x0101010101010101
+    //         ---------------------------------------
+    // vtmp1 = 0x0000000000000065 | 0x000000000000008D
+    sve_bext(vtmp1, D, vtmp1, vtmp2);
+
+    // Concatenate the lowest significant 8 bits in each 8 bytes, and extract the
+    // result to dst.
+    // vtmp1 = 0x0000000000000000 | 0x000000000000658D
+    // dst   = 0x658D
+    if (lane_cnt <= 8) {
+      // No need to concatenate.
+      umov(dst, vtmp1, B, 0);
+    } else if (lane_cnt <= 16) {
+      ins(vtmp1, B, vtmp1, 1, 8);
+      umov(dst, vtmp1, H, 0);
+    } else {
+      // As the lane count is 64 at most, the final expected value must be in
+      // the lowest 64 bits after narrowing vtmp1 from D to B.
+      sve_vector_narrow(vtmp1, B, vtmp1, D, vtmp2);
+      umov(dst, vtmp1, D, 0);
+    }
+  } else {
+    assert(false, "unsupported");
+    ShouldNotReachHere();
   }
 }
 