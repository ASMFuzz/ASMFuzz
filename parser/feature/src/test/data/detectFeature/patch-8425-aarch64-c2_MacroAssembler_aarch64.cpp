@@ -1113,10 +1113,12 @@ void C2_MacroAssembler::sve_vector_narrow(FloatRegister dst, SIMD_RegVariant dst
       sve_uzp1(dst, S, src, tmp);
       break;
     case H:
+      assert_different_registers(dst, tmp);
       sve_uzp1(dst, S, src, tmp);
       sve_uzp1(dst, H, dst, tmp);
       break;
     case B:
+      assert_different_registers(dst, tmp);
       sve_uzp1(dst, S, src, tmp);
       sve_uzp1(dst, H, dst, tmp);
       sve_uzp1(dst, B, dst, tmp);
@@ -1128,6 +1130,7 @@ void C2_MacroAssembler::sve_vector_narrow(FloatRegister dst, SIMD_RegVariant dst
     if (dst_size == H) {
       sve_uzp1(dst, H, src, tmp);
     } else { // B
+      assert_different_registers(dst, tmp);
       sve_uzp1(dst, H, src, tmp);
       sve_uzp1(dst, B, dst, tmp);
     }
@@ -1311,6 +1314,154 @@ void C2_MacroAssembler::sve_ptrue_lanecnt(PRegister dst, SIMD_RegVariant size, i
   }
 }
 
+// Pack active elements of src, under the control of mask, into the lowest-numbered elements of dst.
+// Any remaining elements of dst will be filled with zero.
+// Clobbers: rscratch1
+// Preserves: src, mask
+void C2_MacroAssembler::sve_compress_short(FloatRegister dst, FloatRegister src, PRegister mask,
+                                           FloatRegister vtmp1, FloatRegister vtmp2,
+                                           PRegister pgtmp) {
+  assert(pgtmp->is_governing(), "This register has to be a governing predicate register");
+  assert_different_registers(dst, src, vtmp1, vtmp2);
+  assert_different_registers(mask, pgtmp);
+
+  // Example input:   src   = 8888 7777 6666 5555 4444 3333 2222 1111
+  //                  mask  = 0001 0000 0000 0001 0001 0000 0001 0001
+  // Expected result: dst   = 0000 0000 0000 8888 5555 4444 2222 1111
+  sve_dup(vtmp2, H, 0);
+
+  // Extend lowest half to type INT.
+  // dst = 00004444 00003333 00002222 00001111
+  sve_uunpklo(dst, S, src);
+  // pgtmp = 00000001 00000000 00000001 00000001
+  sve_punpklo(pgtmp, mask);
+  // Pack the active elements in size of type INT to the right,
+  // and fill the remainings with zero.
+  // dst = 00000000 00004444 00002222 00001111
+  sve_compact(dst, S, dst, pgtmp);
+  // Narrow the result back to type SHORT.
+  // dst = 0000 0000 0000 0000 0000 4444 2222 1111
+  sve_uzp1(dst, H, dst, vtmp2);
+  // Count the active elements of lowest half.
+  // rscratch1 = 3
+  sve_cntp(rscratch1, S, ptrue, pgtmp);
+
+  // Repeat to the highest half.
+  // pgtmp = 00000001 00000000 00000000 00000001
+  sve_punpkhi(pgtmp, mask);
+  // vtmp1 = 00008888 00007777 00006666 00005555
+  sve_uunpkhi(vtmp1, S, src);
+  // vtmp1 = 00000000 00000000 00008888 00005555
+  sve_compact(vtmp1, S, vtmp1, pgtmp);
+  // vtmp1 = 0000 0000 0000 0000 0000 0000 8888 5555
+  sve_uzp1(vtmp1, H, vtmp1, vtmp2);
+
+  // Compressed low:   dst   = 0000 0000 0000 0000 0000 4444 2222 1111
+  // Compressed high:  vtmp1 = 0000 0000 0000 0000 0000 0000 8888  5555
+  // Left shift(cross lane) compressed high with TRUE_CNT lanes,
+  // TRUE_CNT is the number of active elements in the compressed low.
+  neg(rscratch1, rscratch1);
+  // vtmp2 = {4 3 2 1 0 -1 -2 -3}
+  sve_index(vtmp2, H, rscratch1, 1);
+  // vtmp1 = 0000 0000 0000 8888 5555 0000 0000 0000
+  sve_tbl(vtmp1, H, vtmp1, vtmp2);
+
+  // Combine the compressed high(after shifted) with the compressed low.
+  // dst = 0000 0000 0000 8888 5555 4444 2222 1111
+  sve_orr(dst, dst, vtmp1);
+}
+
+// Clobbers: rscratch1, rscratch2
+// Preserves: src, mask
+void C2_MacroAssembler::sve_compress_byte(FloatRegister dst, FloatRegister src, PRegister mask,
+                                          FloatRegister vtmp1, FloatRegister vtmp2,
+                                          FloatRegister vtmp3, FloatRegister vtmp4,
+                                          PRegister ptmp, PRegister pgtmp) {
+  assert(pgtmp->is_governing(), "This register has to be a governing predicate register");
+  assert_different_registers(dst, src, vtmp1, vtmp2, vtmp3, vtmp4);
+  assert_different_registers(mask, ptmp, pgtmp);
+  // Example input:   src   = 88 77 66 55 44 33 22 11
+  //                  mask  = 01 00 00 01 01 00 01 01
+  // Expected result: dst   = 00 00 00 88 55 44 22 11
+
+  sve_dup(vtmp4, B, 0);
+  // Extend lowest half to type SHORT.
+  // vtmp1 = 0044 0033 0022 0011
+  sve_uunpklo(vtmp1, H, src);
+  // ptmp = 0001 0000 0001 0001
+  sve_punpklo(ptmp, mask);
+  // Count the active elements of lowest half.
+  // rscratch2 = 3
+  sve_cntp(rscratch2, H, ptrue, ptmp);
+  // Pack the active elements in size of type SHORT to the right,
+  // and fill the remainings with zero.
+  // dst = 0000 0044 0022 0011
+  sve_compress_short(dst, vtmp1, ptmp, vtmp2, vtmp3, pgtmp);
+  // Narrow the result back to type BYTE.
+  // dst = 00 00 00 00 00 44 22 11
+  sve_uzp1(dst, B, dst, vtmp4);
+
+  // Repeat to the highest half.
+  // ptmp = 0001 0000 0000 0001
+  sve_punpkhi(ptmp, mask);
+  // vtmp1 = 0088 0077 0066 0055
+  sve_uunpkhi(vtmp2, H, src);
+  // vtmp1 = 0000 0000 0088 0055
+  sve_compress_short(vtmp1, vtmp2, ptmp, vtmp3, vtmp4, pgtmp);
+
+  sve_dup(vtmp4, B, 0);
+  // vtmp1 = 00 00 00 00 00 00 88 55
+  sve_uzp1(vtmp1, B, vtmp1, vtmp4);
+
+  // Compressed low:   dst   = 00 00 00 00 00 44 22 11
+  // Compressed high:  vtmp1 = 00 00 00 00 00 00 88 55
+  // Left shift(cross lane) compressed high with TRUE_CNT lanes,
+  // TRUE_CNT is the number of active elements in the compressed low.
+  neg(rscratch2, rscratch2);
+  // vtmp2 = {4 3 2 1 0 -1 -2 -3}
+  sve_index(vtmp2, B, rscratch2, 1);
+  // vtmp1 = 00 00 00 88 55 00 00 00
+  sve_tbl(vtmp1, B, vtmp1, vtmp2);
+  // Combine the compressed high(after shifted) with the compressed low.
+  // dst = 00 00 00 88 55 44 22 11
+  sve_orr(dst, dst, vtmp1);
+}
+
+void C2_MacroAssembler::neon_reverse_bits(FloatRegister dst, FloatRegister src, BasicType bt, bool isQ) {
+  assert(bt == T_BYTE || bt == T_SHORT || bt == T_INT || bt == T_LONG, "unsupported basic type");
+  SIMD_Arrangement size = isQ ? T16B : T8B;
+  if (bt == T_BYTE) {
+    rbit(dst, size, src);
+  } else {
+    neon_reverse_bytes(dst, src, bt, isQ);
+    rbit(dst, size, dst);
+  }
+}
+
+void C2_MacroAssembler::neon_reverse_bytes(FloatRegister dst, FloatRegister src, BasicType bt, bool isQ) {
+  assert(bt == T_BYTE || bt == T_SHORT || bt == T_INT || bt == T_LONG, "unsupported basic type");
+  SIMD_Arrangement size = isQ ? T16B : T8B;
+  switch (bt) {
+    case T_BYTE:
+      if (dst != src) {
+        orr(dst, size, src, src);
+      }
+      break;
+    case T_SHORT:
+      rev16(dst, size, src);
+      break;
+    case T_INT:
+      rev32(dst, size, src);
+      break;
+    case T_LONG:
+      rev64(dst, size, src);
+      break;
+    default:
+      assert(false, "unsupported");
+      ShouldNotReachHere();
+  }
+}
+
 // Extract a scalar element from an sve vector at position 'idx'.
 // The input elements in src are expected to be of integral type.
 void C2_MacroAssembler::sve_extract_integral(Register dst, SIMD_RegVariant size, FloatRegister src, int idx,