@@ -2274,6 +2274,84 @@ void C2_MacroAssembler::vectortest(int bt, int vlen, XMMRegister src1, XMMRegist
   }
 }
 
+void C2_MacroAssembler::vpadd(BasicType elem_bt, XMMRegister dst, XMMRegister src1, XMMRegister src2, int vlen_enc) {
+  assert(UseAVX >= 2, "required");
+#ifdef ASSERT
+  bool is_bw = ((elem_bt == T_BYTE) || (elem_bt == T_SHORT));
+  bool is_bw_supported = VM_Version::supports_avx512bw();
+  if (is_bw && !is_bw_supported) {
+    assert(vlen_enc != Assembler::AVX_512bit, "required");
+    assert((dst->encoding() < 16) && (src1->encoding() < 16) && (src2->encoding() < 16),
+           "XMM register should be 0-15");
+  }
+#endif // ASSERT
+  switch (elem_bt) {
+    case T_BYTE: vpaddb(dst, src1, src2, vlen_enc); return;
+    case T_SHORT: vpaddw(dst, src1, src2, vlen_enc); return;
+    case T_INT: vpaddd(dst, src1, src2, vlen_enc); return;
+    case T_FLOAT: vaddps(dst, src1, src2, vlen_enc); return;
+    case T_LONG: vpaddq(dst, src1, src2, vlen_enc); return;
+    case T_DOUBLE: vaddpd(dst, src1, src2, vlen_enc); return;
+    default: assert(false, "%s", type2name(elem_bt));
+  }
+}
+
+#ifdef _LP64
+void C2_MacroAssembler::vpbroadcast(BasicType elem_bt, XMMRegister dst, Register src, int vlen_enc) {
+  assert(UseAVX >= 2, "required");
+  bool is_bw = ((elem_bt == T_BYTE) || (elem_bt == T_SHORT));
+  bool is_vl = vlen_enc != Assembler::AVX_512bit;
+  if ((UseAVX > 2) &&
+      (!is_bw || VM_Version::supports_avx512bw()) &&
+      (!is_vl || VM_Version::supports_avx512vl())) {
+    switch (elem_bt) {
+      case T_BYTE: evpbroadcastb(dst, src, vlen_enc); return;
+      case T_SHORT: evpbroadcastw(dst, src, vlen_enc); return;
+      case T_FLOAT: case T_INT: evpbroadcastd(dst, src, vlen_enc); return;
+      case T_DOUBLE: case T_LONG: evpbroadcastq(dst, src, vlen_enc); return;
+      default: assert(false, "%s", type2name(elem_bt));
+    }
+  } else {
+    assert(vlen_enc != Assembler::AVX_512bit, "required");
+    assert((dst->encoding() < 16),"XMM register should be 0-15");
+    switch (elem_bt) {
+      case T_BYTE: movdl(dst, src); vpbroadcastb(dst, dst, vlen_enc); return;
+      case T_SHORT: movdl(dst, src); vpbroadcastw(dst, dst, vlen_enc); return;
+      case T_INT: movdl(dst, src); vpbroadcastd(dst, dst, vlen_enc); return;
+      case T_FLOAT: movdl(dst, src); vbroadcastss(dst, dst, vlen_enc); return;
+      case T_LONG: movdq(dst, src); vpbroadcastq(dst, dst, vlen_enc); return;
+      case T_DOUBLE: movdq(dst, src); vbroadcastsd(dst, dst, vlen_enc); return;
+      default: assert(false, "%s", type2name(elem_bt));
+    }
+  }
+}
+#endif
+
+void C2_MacroAssembler::vconvert_b2x(BasicType to_elem_bt, XMMRegister dst, XMMRegister src, int vlen_enc) {
+  switch (to_elem_bt) {
+    case T_SHORT:
+      vpmovsxbw(dst, src, vlen_enc);
+      break;
+    case T_INT:
+      vpmovsxbd(dst, src, vlen_enc);
+      break;
+    case T_FLOAT:
+      vpmovsxbd(dst, src, vlen_enc);
+      vcvtdq2ps(dst, dst, vlen_enc);
+      break;
+    case T_LONG:
+      vpmovsxbq(dst, src, vlen_enc);
+      break;
+    case T_DOUBLE: {
+      int mid_vlen_enc = (vlen_enc == Assembler::AVX_512bit) ? Assembler::AVX_256bit : Assembler::AVX_128bit;
+      vpmovsxbd(dst, src, mid_vlen_enc);
+      vcvtdq2pd(dst, dst, vlen_enc);
+      break;
+    }
+    default: assert(false, "%s", type2name(to_elem_bt));
+  }
+}
+
 //-------------------------------------------------------------------------------------------
 
 // IndexOf for constant substrings with size >= 8 chars