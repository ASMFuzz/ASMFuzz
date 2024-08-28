@@ -2292,7 +2292,7 @@ void C2_MacroAssembler::vpadd(BasicType elem_bt, XMMRegister dst, XMMRegister sr
     case T_FLOAT: vaddps(dst, src1, src2, vlen_enc); return;
     case T_LONG: vpaddq(dst, src1, src2, vlen_enc); return;
     case T_DOUBLE: vaddpd(dst, src1, src2, vlen_enc); return;
-    default: assert(false, "%s", type2name(elem_bt));
+    default: fatal("Unsupported type %s", type2name(elem_bt)); return;
   }
 }
 
@@ -2309,7 +2309,7 @@ void C2_MacroAssembler::vpbroadcast(BasicType elem_bt, XMMRegister dst, Register
       case T_SHORT: evpbroadcastw(dst, src, vlen_enc); return;
       case T_FLOAT: case T_INT: evpbroadcastd(dst, src, vlen_enc); return;
       case T_DOUBLE: case T_LONG: evpbroadcastq(dst, src, vlen_enc); return;
-      default: assert(false, "%s", type2name(elem_bt));
+      default: fatal("Unsupported type %s", type2name(elem_bt)); return;
     }
   } else {
     assert(vlen_enc != Assembler::AVX_512bit, "required");
@@ -2321,7 +2321,7 @@ void C2_MacroAssembler::vpbroadcast(BasicType elem_bt, XMMRegister dst, Register
       case T_FLOAT: movdl(dst, src); vbroadcastss(dst, dst, vlen_enc); return;
       case T_LONG: movdq(dst, src); vpbroadcastq(dst, dst, vlen_enc); return;
       case T_DOUBLE: movdq(dst, src); vbroadcastsd(dst, dst, vlen_enc); return;
-      default: assert(false, "%s", type2name(elem_bt));
+      default: fatal("Unsupported type %s", type2name(elem_bt)); return;
     }
   }
 }
@@ -2348,7 +2348,9 @@ void C2_MacroAssembler::vconvert_b2x(BasicType to_elem_bt, XMMRegister dst, XMMR
       vcvtdq2pd(dst, dst, vlen_enc);
       break;
     }
-    default: assert(false, "%s", type2name(to_elem_bt));
+    default:
+      fatal("Unsupported type %s", type2name(to_elem_bt));
+      break;
   }
 }
 
@@ -4496,6 +4498,71 @@ void C2_MacroAssembler::vector_mask_operation(int opc, Register dst, XMMRegister
 
   vector_mask_operation_helper(opc, dst, tmp, masklen);
 }
+
+void C2_MacroAssembler::vector_mask_compress(KRegister dst, KRegister src, Register rtmp1,
+                                             Register rtmp2, int mask_len) {
+  kmov(rtmp1, src);
+  andq(rtmp1, (0xFFFFFFFFFFFFFFFFUL >> (64 - mask_len)));
+  mov64(rtmp2, -1L);
+  pext(rtmp2, rtmp2, rtmp1);
+  kmov(dst, rtmp2);
+}
+
+void C2_MacroAssembler::vector_compress_expand(int opcode, XMMRegister dst, XMMRegister src, KRegister mask,
+                                               bool merge, BasicType bt, int vec_enc) {
+  if (opcode == Op_CompressV) {
+    switch(bt) {
+    case T_BYTE:
+      evpcompressb(dst, mask, src, merge, vec_enc);
+      break;
+    case T_CHAR:
+    case T_SHORT:
+      evpcompressw(dst, mask, src, merge, vec_enc);
+      break;
+    case T_INT:
+      evpcompressd(dst, mask, src, merge, vec_enc);
+      break;
+    case T_FLOAT:
+      evcompressps(dst, mask, src, merge, vec_enc);
+      break;
+    case T_LONG:
+      evpcompressq(dst, mask, src, merge, vec_enc);
+      break;
+    case T_DOUBLE:
+      evcompresspd(dst, mask, src, merge, vec_enc);
+      break;
+    default:
+      fatal("Unsupported type %s", type2name(bt));
+      break;
+    }
+  } else {
+    assert(opcode == Op_ExpandV, "");
+    switch(bt) {
+    case T_BYTE:
+      evpexpandb(dst, mask, src, merge, vec_enc);
+      break;
+    case T_CHAR:
+    case T_SHORT:
+      evpexpandw(dst, mask, src, merge, vec_enc);
+      break;
+    case T_INT:
+      evpexpandd(dst, mask, src, merge, vec_enc);
+      break;
+    case T_FLOAT:
+      evexpandps(dst, mask, src, merge, vec_enc);
+      break;
+    case T_LONG:
+      evpexpandq(dst, mask, src, merge, vec_enc);
+      break;
+    case T_DOUBLE:
+      evexpandpd(dst, mask, src, merge, vec_enc);
+      break;
+    default:
+      fatal("Unsupported type %s", type2name(bt));
+      break;
+    }
+  }
+}
 #endif
 
 void C2_MacroAssembler::vector_signum_evex(int opcode, XMMRegister dst, XMMRegister src, XMMRegister zero, XMMRegister one,
@@ -4559,6 +4626,34 @@ void C2_MacroAssembler::vector_maskall_operation(KRegister dst, Register src, in
   }
 }
 
+void C2_MacroAssembler::vbroadcast(BasicType bt, XMMRegister dst, int imm32, Register rtmp, int vec_enc) {
+  int lane_size = type2aelembytes(bt);
+  bool is_LP64 = LP64_ONLY(true) NOT_LP64(false);
+  if ((is_LP64 || lane_size < 8) &&
+      ((is_non_subword_integral_type(bt) && VM_Version::supports_avx512vl()) ||
+       (is_subword_type(bt) && VM_Version::supports_avx512vlbw()))) {
+    movptr(rtmp, imm32);
+    switch(lane_size) {
+      case 1 : evpbroadcastb(dst, rtmp, vec_enc); break;
+      case 2 : evpbroadcastw(dst, rtmp, vec_enc); break;
+      case 4 : evpbroadcastd(dst, rtmp, vec_enc); break;
+      case 8 : evpbroadcastq(dst, rtmp, vec_enc); break;
+      fatal("Unsupported lane size %d", lane_size);
+      break;
+    }
+  } else {
+    movptr(rtmp, imm32);
+    LP64_ONLY(movq(dst, rtmp)) NOT_LP64(movdl(dst, rtmp));
+    switch(lane_size) {
+      case 1 : vpbroadcastb(dst, dst, vec_enc); break;
+      case 2 : vpbroadcastw(dst, dst, vec_enc); break;
+      case 4 : vpbroadcastd(dst, dst, vec_enc); break;
+      case 8 : vpbroadcastq(dst, dst, vec_enc); break;
+      fatal("Unsupported lane size %d", lane_size);
+      break;
+    }
+  }
+}
 
 //
 // Following is lookup table based popcount computation algorithm:-
@@ -4589,62 +4684,98 @@ void C2_MacroAssembler::vector_maskall_operation(KRegister dst, Register src, in
 //  f. Perform step e. for upper 128bit vector lane.
 //  g. Pack the bitset count of quadwords back to double word.
 //  h. Unpacking and packing operations are not needed for 64bit vector lane.
+
+void C2_MacroAssembler::vector_popcount_byte(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                             XMMRegister xtmp2, Register rtmp, int vec_enc) {
+  assert((vec_enc == Assembler::AVX_512bit && VM_Version::supports_avx512bw()) || VM_Version::supports_avx2(), "");
+  vbroadcast(T_INT, xtmp1, 0x0F0F0F0F, rtmp, vec_enc);
+  vpsrlw(dst, src, 4, vec_enc);
+  vpand(dst, dst, xtmp1, vec_enc);
+  vpand(xtmp1, src, xtmp1, vec_enc);
+  vmovdqu(xtmp2, ExternalAddress(StubRoutines::x86::vector_popcount_lut()), rtmp, vec_enc);
+  vpshufb(xtmp1, xtmp2, xtmp1, vec_enc);
+  vpshufb(dst, xtmp2, dst, vec_enc);
+  vpaddb(dst, dst, xtmp1, vec_enc);
+}
+
 void C2_MacroAssembler::vector_popcount_int(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
-                                            XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp,
-                                            int vec_enc) {
-  if (VM_Version::supports_avx512_vpopcntdq()) {
-    vpopcntd(dst, src, vec_enc);
-  } else {
-    assert((vec_enc == Assembler::AVX_512bit && VM_Version::supports_avx512bw()) || VM_Version::supports_avx2(), "");
-    movl(rtmp, 0x0F0F0F0F);
-    movdl(xtmp1, rtmp);
-    vpbroadcastd(xtmp1, xtmp1, vec_enc);
-    if (Assembler::AVX_512bit == vec_enc) {
-      evmovdqul(xtmp2, k0, ExternalAddress(StubRoutines::x86::vector_popcount_lut()), false, vec_enc, rtmp);
-    } else {
-      vmovdqu(xtmp2, ExternalAddress(StubRoutines::x86::vector_popcount_lut()), rtmp);
-    }
-    vpand(xtmp3, src, xtmp1, vec_enc);
-    vpshufb(xtmp3, xtmp2, xtmp3, vec_enc);
-    vpsrlw(dst, src, 4, vec_enc);
-    vpand(dst, dst, xtmp1, vec_enc);
-    vpshufb(dst, xtmp2, dst, vec_enc);
-    vpaddb(xtmp3, dst, xtmp3, vec_enc);
-    vpxor(xtmp1, xtmp1, xtmp1, vec_enc);
-    vpunpckhdq(dst, xtmp3, xtmp1, vec_enc);
-    vpsadbw(dst, dst, xtmp1, vec_enc);
-    vpunpckldq(xtmp2, xtmp3, xtmp1, vec_enc);
-    vpsadbw(xtmp2, xtmp2, xtmp1, vec_enc);
-    vpackuswb(dst, xtmp2, dst, vec_enc);
-  }
+                                            XMMRegister xtmp2, Register rtmp, int vec_enc) {
+  vector_popcount_byte(xtmp1, src, dst, xtmp2, rtmp, vec_enc);
+  // Following code is as per steps e,f,g and h of above algorithm.
+  vpxor(xtmp2, xtmp2, xtmp2, vec_enc);
+  vpunpckhdq(dst, xtmp1, xtmp2, vec_enc);
+  vpsadbw(dst, dst, xtmp2, vec_enc);
+  vpunpckldq(xtmp1, xtmp1, xtmp2, vec_enc);
+  vpsadbw(xtmp1, xtmp1, xtmp2, vec_enc);
+  vpackuswb(dst, xtmp1, dst, vec_enc);
+}
+
+void C2_MacroAssembler::vector_popcount_short(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                              XMMRegister xtmp2, Register rtmp, int vec_enc) {
+  vector_popcount_byte(xtmp1, src, dst, xtmp2, rtmp, vec_enc);
+  // Add the popcount of upper and lower bytes of word.
+  vbroadcast(T_INT, xtmp2, 0x00FF00FF, rtmp, vec_enc);
+  vpsrlw(dst, xtmp1, 8, vec_enc);
+  vpand(xtmp1, xtmp1, xtmp2, vec_enc);
+  vpaddw(dst, dst, xtmp1, vec_enc);
 }
 
 void C2_MacroAssembler::vector_popcount_long(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
-                                             XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp,
-                                             int vec_enc) {
-  if (VM_Version::supports_avx512_vpopcntdq()) {
-    vpopcntq(dst, src, vec_enc);
-  } else if (vec_enc == Assembler::AVX_512bit) {
-    assert(VM_Version::supports_avx512bw(), "");
-    movl(rtmp, 0x0F0F0F0F);
-    movdl(xtmp1, rtmp);
-    vpbroadcastd(xtmp1, xtmp1, vec_enc);
-    evmovdqul(xtmp2, k0, ExternalAddress(StubRoutines::x86::vector_popcount_lut()), true, vec_enc, rtmp);
-    vpandq(xtmp3, src, xtmp1, vec_enc);
-    vpshufb(xtmp3, xtmp2, xtmp3, vec_enc);
-    vpsrlw(dst, src, 4, vec_enc);
-    vpandq(dst, dst, xtmp1, vec_enc);
-    vpshufb(dst, xtmp2, dst, vec_enc);
-    vpaddb(xtmp3, dst, xtmp3, vec_enc);
-    vpxorq(xtmp1, xtmp1, xtmp1, vec_enc);
-    vpsadbw(dst, xtmp3, xtmp1, vec_enc);
-  } else {
-    // We do not see any performance benefit of running
-    // above instruction sequence on 256 bit vector which
-    // can operate over maximum 4 long elements.
-    ShouldNotReachHere();
+                                             XMMRegister xtmp2, Register rtmp, int vec_enc) {
+  vector_popcount_byte(xtmp1, src, dst, xtmp2, rtmp, vec_enc);
+  vpxor(xtmp2, xtmp2, xtmp2, vec_enc);
+  vpsadbw(dst, xtmp1, xtmp2, vec_enc);
+}
+
+void C2_MacroAssembler::vector_popcount_integral(BasicType bt, XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                                 XMMRegister xtmp2, Register rtmp, int vec_enc) {
+  switch(bt) {
+    case T_LONG:
+      vector_popcount_long(dst, src, xtmp1, xtmp2, rtmp, vec_enc);
+      break;
+    case T_INT:
+      vector_popcount_int(dst, src, xtmp1, xtmp2, rtmp, vec_enc);
+      break;
+    case T_CHAR:
+    case T_SHORT:
+      vector_popcount_short(dst, src, xtmp1, xtmp2, rtmp, vec_enc);
+      break;
+    case T_BYTE:
+    case T_BOOLEAN:
+      vector_popcount_byte(dst, src, xtmp1, xtmp2, rtmp, vec_enc);
+      break;
+    default:
+      fatal("Unsupported type %s", type2name(bt));
+      break;
+  }
+}
+
+void C2_MacroAssembler::vector_popcount_integral_evex(BasicType bt, XMMRegister dst, XMMRegister src,
+                                                      KRegister mask, bool merge, int vec_enc) {
+  assert(VM_Version::supports_avx512vl() || vec_enc == Assembler::AVX_512bit, "");
+  switch(bt) {
+    case T_LONG:
+      assert(VM_Version::supports_avx512_vpopcntdq(), "");
+      evpopcntq(dst, mask, src, merge, vec_enc);
+      break;
+    case T_INT:
+      assert(VM_Version::supports_avx512_vpopcntdq(), "");
+      evpopcntd(dst, mask, src, merge, vec_enc);
+      break;
+    case T_CHAR:
+    case T_SHORT:
+      assert(VM_Version::supports_avx512_bitalg(), "");
+      evpopcntw(dst, mask, src, merge, vec_enc);
+      break;
+    case T_BYTE:
+    case T_BOOLEAN:
+      assert(VM_Version::supports_avx512_bitalg(), "");
+      evpopcntb(dst, mask, src, merge, vec_enc);
+      break;
+    default:
+      fatal("Unsupported type %s", type2name(bt));
+      break;
   }
-  evpmovqd(dst, dst, vec_enc);
 }
 
 #ifndef _LP64
@@ -4655,6 +4786,374 @@ void C2_MacroAssembler::vector_maskall_operation32(KRegister dst, Register src,
 }
 #endif
 
+// Bit reversal algorithm first reverses the bits of each byte followed by
+// a byte level reversal for multi-byte primitive types (short/int/long).
+// Algorithm performs a lookup table access to get reverse bit sequence
+// corresponding to a 4 bit value. Thus a reverse bit sequence for a byte
+// is obtained by swapping the reverse bit sequences of upper and lower
+// nibble of a byte.
+void C2_MacroAssembler::vector_reverse_bit(BasicType bt, XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                           XMMRegister xtmp2, Register rtmp, int vec_enc) {
+  if (VM_Version::supports_avx512vlbw()) {
+
+    // Get the reverse bit sequence of lower nibble of each byte.
+    vmovdqu(xtmp1, ExternalAddress(StubRoutines::x86::vector_reverse_bit_lut()), rtmp, vec_enc);
+    vbroadcast(T_INT, xtmp2, 0x0F0F0F0F, rtmp, vec_enc);
+    vpandq(dst, xtmp2, src, vec_enc);
+    vpshufb(dst, xtmp1, dst, vec_enc);
+    vpsllq(dst, dst, 4, vec_enc);
+
+    // Get the reverse bit sequence of upper nibble of each byte.
+    vpandn(xtmp2, xtmp2, src, vec_enc);
+    vpsrlq(xtmp2, xtmp2, 4, vec_enc);
+    vpshufb(xtmp2, xtmp1, xtmp2, vec_enc);
+
+    // Perform logical OR operation b/w left shifted reverse bit sequence of lower nibble and
+    // right shifted reverse bit sequence of upper nibble to obtain the reverse bit sequence of each byte.
+    vporq(xtmp2, dst, xtmp2, vec_enc);
+    vector_reverse_byte(bt, dst, xtmp2, rtmp, vec_enc);
+
+  } else if(vec_enc == Assembler::AVX_512bit) {
+    // Shift based bit reversal.
+    assert(bt == T_LONG || bt == T_INT, "");
+
+    // Swap lower and upper nibble of each byte.
+    vector_swap_nbits(4, 0x0F0F0F0F, xtmp1, src, xtmp2, rtmp, vec_enc);
+
+    // Swap two least and most significant bits of each nibble.
+    vector_swap_nbits(2, 0x33333333, dst, xtmp1, xtmp2, rtmp, vec_enc);
+
+    // Swap adjacent pair of bits.
+    evmovdqul(xtmp1, k0, dst, true, vec_enc);
+    vector_swap_nbits(1, 0x55555555, dst, xtmp1, xtmp2, rtmp, vec_enc);
+
+    evmovdqul(xtmp1, k0, dst, true, vec_enc);
+    vector_reverse_byte64(bt, dst, xtmp1, xtmp1, xtmp2, rtmp, vec_enc);
+  } else {
+    vmovdqu(xtmp1, ExternalAddress(StubRoutines::x86::vector_reverse_bit_lut()), rtmp, vec_enc);
+    vbroadcast(T_INT, xtmp2, 0x0F0F0F0F, rtmp, vec_enc);
+
+    // Get the reverse bit sequence of lower nibble of each byte.
+    vpand(dst, xtmp2, src, vec_enc);
+    vpshufb(dst, xtmp1, dst, vec_enc);
+    vpsllq(dst, dst, 4, vec_enc);
+
+    // Get the reverse bit sequence of upper nibble of each byte.
+    vpandn(xtmp2, xtmp2, src, vec_enc);
+    vpsrlq(xtmp2, xtmp2, 4, vec_enc);
+    vpshufb(xtmp2, xtmp1, xtmp2, vec_enc);
+
+    // Perform logical OR operation b/w left shifted reverse bit sequence of lower nibble and
+    // right shifted reverse bit sequence of upper nibble to obtain the reverse bit sequence of each byte.
+    vpor(xtmp2, dst, xtmp2, vec_enc);
+    vector_reverse_byte(bt, dst, xtmp2, rtmp, vec_enc);
+  }
+}
+
+void C2_MacroAssembler::vector_reverse_bit_gfni(BasicType bt, XMMRegister dst, XMMRegister src,
+                                                XMMRegister xtmp, AddressLiteral mask, Register rtmp, int vec_enc) {
+  // Galois field instruction based bit reversal based on following algorithm.
+  // http://0x80.pl/articles/avx512-galois-field-for-bit-shuffling.html
+  assert(VM_Version::supports_gfni(), "");
+  vpbroadcastq(xtmp, mask, vec_enc, rtmp);
+  vgf2p8affineqb(xtmp, src, xtmp, 0, vec_enc);
+  vector_reverse_byte(bt, dst, xtmp, rtmp, vec_enc);
+}
+
+void C2_MacroAssembler::vector_swap_nbits(int nbits, int bitmask, XMMRegister dst, XMMRegister src,
+                                          XMMRegister xtmp1, Register rtmp, int vec_enc) {
+  vbroadcast(T_INT, xtmp1, bitmask, rtmp, vec_enc);
+  vpandq(dst, xtmp1, src, vec_enc);
+  vpsllq(dst, dst, nbits, vec_enc);
+  vpandn(xtmp1, xtmp1, src, vec_enc);
+  vpsrlq(xtmp1, xtmp1, nbits, vec_enc);
+  vporq(dst, dst, xtmp1, vec_enc);
+}
+
+void C2_MacroAssembler::vector_reverse_byte64(BasicType bt, XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                              XMMRegister xtmp2, Register rtmp, int vec_enc) {
+  // Shift based bit reversal.
+  assert(VM_Version::supports_evex(), "");
+  switch(bt) {
+    case T_LONG:
+      // Swap upper and lower double word of each quad word.
+      evprorq(xtmp1, k0, src, 32, true, vec_enc);
+      evprord(xtmp1, k0, xtmp1, 16, true, vec_enc);
+      vector_swap_nbits(8, 0x00FF00FF, dst, xtmp1, xtmp2, rtmp, vec_enc);
+      break;
+    case T_INT:
+      // Swap upper and lower word of each double word.
+      evprord(xtmp1, k0, src, 16, true, vec_enc);
+      vector_swap_nbits(8, 0x00FF00FF, dst, xtmp1, xtmp2, rtmp, vec_enc);
+      break;
+    case T_SHORT:
+      // Swap upper and lower byte of each word.
+      vector_swap_nbits(8, 0x00FF00FF, dst, src, xtmp2, rtmp, vec_enc);
+      break;
+    case T_BYTE:
+      evmovdquq(dst, k0, src, true, vec_enc);
+      break;
+    default:
+      fatal("Unsupported type %s", type2name(bt));
+      break;
+  }
+}
+
+void C2_MacroAssembler::vector_reverse_byte(BasicType bt, XMMRegister dst, XMMRegister src, Register rtmp, int vec_enc) {
+  if (bt == T_BYTE) {
+    if (VM_Version::supports_avx512vl() || vec_enc == Assembler::AVX_512bit) {
+      evmovdquq(dst, k0, src, true, vec_enc);
+    } else {
+      vmovdqu(dst, src);
+    }
+    return;
+  }
+  // Perform byte reversal by shuffling the bytes of a multi-byte primitive type using
+  // pre-computed shuffle indices.
+  switch(bt) {
+    case T_LONG:
+      vmovdqu(dst, ExternalAddress(StubRoutines::x86::vector_reverse_byte_perm_mask_long()), rtmp, vec_enc);
+      break;
+    case T_INT:
+      vmovdqu(dst, ExternalAddress(StubRoutines::x86::vector_reverse_byte_perm_mask_int()), rtmp, vec_enc);
+      break;
+    case T_SHORT:
+      vmovdqu(dst, ExternalAddress(StubRoutines::x86::vector_reverse_byte_perm_mask_short()), rtmp, vec_enc);
+      break;
+    default:
+      fatal("Unsupported type %s", type2name(bt));
+      break;
+  }
+  vpshufb(dst, src, dst, vec_enc);
+}
+
+void C2_MacroAssembler::vector_count_leading_zeros_evex(BasicType bt, XMMRegister dst, XMMRegister src,
+                                                        XMMRegister xtmp1, XMMRegister xtmp2, XMMRegister xtmp3,
+                                                        KRegister ktmp, Register rtmp, bool merge, int vec_enc) {
+  assert(is_integral_type(bt), "");
+  assert(VM_Version::supports_avx512vl() || vec_enc == Assembler::AVX_512bit, "");
+  assert(VM_Version::supports_avx512cd(), "");
+  switch(bt) {
+    case T_LONG:
+      evplzcntq(dst, ktmp, src, merge, vec_enc);
+      break;
+    case T_INT:
+      evplzcntd(dst, ktmp, src, merge, vec_enc);
+      break;
+    case T_SHORT:
+      vpternlogd(xtmp1, 0xff, xtmp1, xtmp1, vec_enc);
+      vpunpcklwd(xtmp2, xtmp1, src, vec_enc);
+      evplzcntd(xtmp2, ktmp, xtmp2, merge, vec_enc);
+      vpunpckhwd(dst, xtmp1, src, vec_enc);
+      evplzcntd(dst, ktmp, dst, merge, vec_enc);
+      vpackusdw(dst, xtmp2, dst, vec_enc);
+      break;
+    case T_BYTE:
+      // T1 = Compute leading zero counts of 4 LSB bits of each byte by
+      // accessing the lookup table.
+      // T2 = Compute leading zero counts of 4 MSB bits of each byte by
+      // accessing the lookup table.
+      // Add T1 to T2 if 4 MSB bits of byte are all zeros.
+      assert(VM_Version::supports_avx512bw(), "");
+      evmovdquq(xtmp1, ExternalAddress(StubRoutines::x86::vector_count_leading_zeros_lut()), vec_enc, rtmp);
+      vbroadcast(T_INT, dst, 0x0F0F0F0F, rtmp, vec_enc);
+      vpand(xtmp2, dst, src, vec_enc);
+      vpshufb(xtmp2, xtmp1, xtmp2, vec_enc);
+      vpsrlw(xtmp3, src, 4, vec_enc);
+      vpand(xtmp3, dst, xtmp3, vec_enc);
+      vpshufb(dst, xtmp1, xtmp3, vec_enc);
+      vpxor(xtmp1, xtmp1, xtmp1, vec_enc);
+      evpcmpeqb(ktmp, xtmp1, xtmp3, vec_enc);
+      evpaddb(dst, ktmp, dst, xtmp2, true, vec_enc);
+      break;
+    default:
+      fatal("Unsupported type %s", type2name(bt));
+      break;
+  }
+}
+
+void C2_MacroAssembler::vector_count_leading_zeros_byte_avx(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                                            XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp, int vec_enc) {
+  vmovdqu(xtmp1, ExternalAddress(StubRoutines::x86::vector_count_leading_zeros_lut()), rtmp);
+  vbroadcast(T_INT, xtmp2, 0x0F0F0F0F, rtmp, vec_enc);
+  // T1 = Compute leading zero counts of 4 LSB bits of each byte by
+  // accessing the lookup table.
+  vpand(dst, xtmp2, src, vec_enc);
+  vpshufb(dst, xtmp1, dst, vec_enc);
+  // T2 = Compute leading zero counts of 4 MSB bits of each byte by
+  // accessing the lookup table.
+  vpsrlw(xtmp3, src, 4, vec_enc);
+  vpand(xtmp3, xtmp2, xtmp3, vec_enc);
+  vpshufb(xtmp2, xtmp1, xtmp3, vec_enc);
+  // Add T1 to T2 if 4 MSB bits of byte are all zeros.
+  vpxor(xtmp1, xtmp1, xtmp1, vec_enc);
+  vpcmpeqb(xtmp3, xtmp1, xtmp3, vec_enc);
+  vpaddb(dst, dst, xtmp2, vec_enc);
+  vpblendvb(dst, xtmp2, dst, xtmp3, vec_enc);
+}
+
+void C2_MacroAssembler::vector_count_leading_zeros_short_avx(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                                             XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp, int vec_enc) {
+  vector_count_leading_zeros_byte_avx(dst, src, xtmp1, xtmp2, xtmp3, rtmp, vec_enc);
+  // Add zero counts of lower byte and upper byte of a word if
+  // upper byte holds a zero value.
+  vpsrlw(xtmp3, src, 8, vec_enc);
+  // xtmp1 is set to all zeros by vector_count_leading_zeros_byte_avx.
+  vpcmpeqw(xtmp3, xtmp1, xtmp3, vec_enc);
+  vpsllw(xtmp2, dst, 8, vec_enc);
+  vpaddw(xtmp2, xtmp2, dst, vec_enc);
+  vpblendvb(dst, dst, xtmp2, xtmp3, vec_enc);
+  vpsrlw(dst, dst, 8, vec_enc);
+}
+
+void C2_MacroAssembler::vector_count_leading_zeros_int_avx(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                                           XMMRegister xtmp2, XMMRegister xtmp3, int vec_enc) {
+  // Since IEEE 754 floating point format represents mantissa in 1.0 format
+  // hence biased exponent can be used to compute leading zero count as per
+  // following formula:-
+  // LZCNT = 32 - (biased_exp - 127)
+  // Special handling has been introduced for Zero, Max_Int and -ve source values.
+
+  // Broadcast 0xFF
+  vpcmpeqd(xtmp1, xtmp1, xtmp1, vec_enc);
+  vpsrld(xtmp1, xtmp1, 24, vec_enc);
+
+  // Extract biased exponent.
+  vcvtdq2ps(dst, src, vec_enc);
+  vpsrld(dst, dst, 23, vec_enc);
+  vpand(dst, dst, xtmp1, vec_enc);
+
+  // Broadcast 127.
+  vpsrld(xtmp1, xtmp1, 1, vec_enc);
+  // Exponent = biased_exp - 127
+  vpsubd(dst, dst, xtmp1, vec_enc);
+
+  // Exponent = Exponent  + 1
+  vpsrld(xtmp3, xtmp1, 6, vec_enc);
+  vpaddd(dst, dst, xtmp3, vec_enc);
+
+  // Replace -ve exponent with zero, exponent is -ve when src
+  // lane contains a zero value.
+  vpxor(xtmp2, xtmp2, xtmp2, vec_enc);
+  vblendvps(dst, dst, xtmp2, dst, vec_enc);
+
+  // Rematerialize broadcast 32.
+  vpslld(xtmp1, xtmp3, 5, vec_enc);
+  // Exponent is 32 if corresponding source lane contains max_int value.
+  vpcmpeqd(xtmp2, dst, xtmp1, vec_enc);
+  // LZCNT = 32 - exponent
+  vpsubd(dst, xtmp1, dst, vec_enc);
+
+  // Replace LZCNT with a value 1 if corresponding source lane
+  // contains max_int value.
+  vpblendvb(dst, dst, xtmp3, xtmp2, vec_enc);
+
+  // Replace biased_exp with 0 if source lane value is less than zero.
+  vpxor(xtmp2, xtmp2, xtmp2, vec_enc);
+  vblendvps(dst, dst, xtmp2, src, vec_enc);
+}
+
+void C2_MacroAssembler::vector_count_leading_zeros_long_avx(XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                                            XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp, int vec_enc) {
+  vector_count_leading_zeros_short_avx(dst, src, xtmp1, xtmp2, xtmp3, rtmp, vec_enc);
+  // Add zero counts of lower word and upper word of a double word if
+  // upper word holds a zero value.
+  vpsrld(xtmp3, src, 16, vec_enc);
+  // xtmp1 is set to all zeros by vector_count_leading_zeros_byte_avx.
+  vpcmpeqd(xtmp3, xtmp1, xtmp3, vec_enc);
+  vpslld(xtmp2, dst, 16, vec_enc);
+  vpaddd(xtmp2, xtmp2, dst, vec_enc);
+  vpblendvb(dst, dst, xtmp2, xtmp3, vec_enc);
+  vpsrld(dst, dst, 16, vec_enc);
+  // Add zero counts of lower doubleword and upper doubleword of a
+  // quadword if upper doubleword holds a zero value.
+  vpsrlq(xtmp3, src, 32, vec_enc);
+  vpcmpeqq(xtmp3, xtmp1, xtmp3, vec_enc);
+  vpsllq(xtmp2, dst, 32, vec_enc);
+  vpaddq(xtmp2, xtmp2, dst, vec_enc);
+  vpblendvb(dst, dst, xtmp2, xtmp3, vec_enc);
+  vpsrlq(dst, dst, 32, vec_enc);
+}
+
+void C2_MacroAssembler::vector_count_leading_zeros_avx(BasicType bt, XMMRegister dst, XMMRegister src,
+                                                       XMMRegister xtmp1, XMMRegister xtmp2, XMMRegister xtmp3,
+                                                       Register rtmp, int vec_enc) {
+  assert(is_integral_type(bt), "unexpected type");
+  assert(vec_enc < Assembler::AVX_512bit, "");
+  switch(bt) {
+    case T_LONG:
+      vector_count_leading_zeros_long_avx(dst, src, xtmp1, xtmp2, xtmp3, rtmp, vec_enc);
+      break;
+    case T_INT:
+      vector_count_leading_zeros_int_avx(dst, src, xtmp1, xtmp2, xtmp3, vec_enc);
+      break;
+    case T_SHORT:
+      vector_count_leading_zeros_short_avx(dst, src, xtmp1, xtmp2, xtmp3, rtmp, vec_enc);
+      break;
+    case T_BYTE:
+      vector_count_leading_zeros_byte_avx(dst, src, xtmp1, xtmp2, xtmp3, rtmp, vec_enc);
+      break;
+    default:
+      fatal("Unsupported type %s", type2name(bt));
+      break;
+  }
+}
+
+void C2_MacroAssembler::vpsub(BasicType bt, XMMRegister dst, XMMRegister src1, XMMRegister src2, int vec_enc) {
+  switch(bt) {
+    case T_BYTE:
+      vpsubb(dst, src1, src2, vec_enc);
+      break;
+    case T_SHORT:
+      vpsubw(dst, src1, src2, vec_enc);
+      break;
+    case T_INT:
+      vpsubd(dst, src1, src2, vec_enc);
+      break;
+    case T_LONG:
+      vpsubq(dst, src1, src2, vec_enc);
+      break;
+    default:
+      fatal("Unsupported type %s", type2name(bt));
+      break;
+  }
+}
+
+// Trailing zero count computation is based on leading zero count operation as per
+// following equation. All AVX3 targets support AVX512CD feature which offers
+// direct vector instruction to compute leading zero count.
+//      CTZ = PRIM_TYPE_WIDHT - CLZ((x - 1) & ~x)
+void C2_MacroAssembler::vector_count_trailing_zeros_evex(BasicType bt, XMMRegister dst, XMMRegister src,
+                                                         XMMRegister xtmp1, XMMRegister xtmp2, XMMRegister xtmp3,
+                                                         XMMRegister xtmp4, KRegister ktmp, Register rtmp, int vec_enc) {
+  assert(is_integral_type(bt), "");
+  // xtmp = -1
+  vpternlogd(xtmp4, 0xff, xtmp4, xtmp4, vec_enc);
+  // xtmp = xtmp + src
+  vpadd(bt, xtmp4, xtmp4, src, vec_enc);
+  // xtmp = xtmp & ~src
+  vpternlogd(xtmp4, 0x40, xtmp4, src, vec_enc);
+  vector_count_leading_zeros_evex(bt, dst, xtmp4, xtmp1, xtmp2, xtmp3, ktmp, rtmp, true, vec_enc);
+  vbroadcast(bt, xtmp4, 8 * type2aelembytes(bt), rtmp, vec_enc);
+  vpsub(bt, dst, xtmp4, dst, vec_enc);
+}
+
+// Trailing zero count computation for AVX2 targets is based on popcount operation as per following equation
+//      CTZ = PRIM_TYPE_WIDHT - POPC(x | -x)
+void C2_MacroAssembler::vector_count_trailing_zeros_avx(BasicType bt, XMMRegister dst, XMMRegister src, XMMRegister xtmp1,
+                                                        XMMRegister xtmp2, XMMRegister xtmp3, Register rtmp, int vec_enc) {
+  assert(is_integral_type(bt), "");
+  // xtmp = 0
+  vpxor(xtmp3 , xtmp3, xtmp3, vec_enc);
+  // xtmp = 0 - src
+  vpsub(bt, xtmp3, xtmp3, src, vec_enc);
+  // xtmp = xtmp | src
+  vpor(xtmp3, xtmp3, src, vec_enc);
+  vector_popcount_integral(bt, dst, xtmp3, xtmp1, xtmp2, rtmp, vec_enc);
+  vbroadcast(bt, xtmp1, 8 * type2aelembytes(bt), rtmp, vec_enc);
+  vpsub(bt, dst, xtmp1, dst, vec_enc);
+}
+
 void C2_MacroAssembler::udivI(Register rax, Register divisor, Register rdx) {
   Label done;
   Label neg_divisor_fastpath;
@@ -4817,4 +5316,3 @@ void C2_MacroAssembler::udivmodL(Register rax, Register divisor, Register rdx, R
   bind(done);
 }
 #endif
-