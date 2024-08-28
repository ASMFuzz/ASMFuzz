@@ -5324,7 +5324,120 @@ class StubGenerator: public StubCodeGenerator {
     return entry;
   }
 
+  enum string_compare_mode {
+    LL,
+    LU,
+    UL,
+    UU,
+  };
+
+  // The following registers are declared in aarch64.ad
+  // r0  = result
+  // r1  = str1
+  // r2  = cnt1
+  // r3  = str2
+  // r4  = cnt2
+  // r10 = tmp1
+  // r11 = tmp2
+  // z0  = ztmp1
+  // z1  = ztmp2
+  // p0  = pgtmp1
+  // p1  = pgtmp2
+  address generate_compare_long_string_sve(string_compare_mode mode) {
+    __ align(CodeEntryAlignment);
+    address entry = __ pc();
+    Register result = r0, str1 = r1, cnt1 = r2, str2 = r3, cnt2 = r4,
+             tmp1 = r10, tmp2 = r11;
+
+    Label LOOP, DONE, MISMATCH;
+    Register vec_len = tmp1;
+    Register idx = tmp2;
+    // The minimum of the string lengths has been stored in cnt2.
+    Register cnt = cnt2;
+    FloatRegister ztmp1 = z0, ztmp2 = z1;
+    PRegister pgtmp1 = p0, pgtmp2 = p1;
+
+#define LOAD_PAIR(ztmp1, ztmp2, pgtmp1, src1, src2, idx)                       \
+    switch (mode) {                                                            \
+      case LL:                                                                 \
+        __ sve_ld1b(ztmp1, __ B, pgtmp1, Address(str1, idx));                  \
+        __ sve_ld1b(ztmp2, __ B, pgtmp1, Address(str2, idx));                  \
+        break;                                                                 \
+      case LU:                                                                 \
+        __ sve_ld1b(ztmp1, __ H, pgtmp1, Address(str1, idx));                  \
+        __ sve_ld1h(ztmp2, __ H, pgtmp1, Address(str2, idx, Address::lsl(1))); \
+        break;                                                                 \
+      case UL:                                                                 \
+        __ sve_ld1h(ztmp1, __ H, pgtmp1, Address(str1, idx, Address::lsl(1))); \
+        __ sve_ld1b(ztmp2, __ H, pgtmp1, Address(str2, idx));                  \
+        break;                                                                 \
+      case UU:                                                                 \
+        __ sve_ld1h(ztmp1, __ H, pgtmp1, Address(str1, idx, Address::lsl(1))); \
+        __ sve_ld1h(ztmp2, __ H, pgtmp1, Address(str2, idx, Address::lsl(1))); \
+        break;                                                                 \
+      default:                                                                 \
+        ShouldNotReachHere();                                                  \
+    }
+
+    const char* stubname;
+    switch (mode) {
+      case LL: stubname = "compare_long_string_same_encoding LL";      break;
+      case LU: stubname = "compare_long_string_different_encoding LU"; break;
+      case UL: stubname = "compare_long_string_different_encoding UL"; break;
+      case UU: stubname = "compare_long_string_same_encoding UU";      break;
+      default: ShouldNotReachHere();
+    }
+
+    StubCodeMark mark(this, "StubRoutines", stubname);
+
+    __ mov(idx, 0);
+    __ sve_whilelt(pgtmp1, mode == LL ? __ B : __ H, idx, cnt);
+
+    if (mode == LL) {
+      __ sve_cntb(vec_len);
+    } else {
+      __ sve_cnth(vec_len);
+    }
+
+    __ sub(rscratch1, cnt, vec_len);
+
+    __ bind(LOOP);
+
+      // main loop
+      LOAD_PAIR(ztmp1, ztmp2, pgtmp1, src1, src2, idx);
+      __ add(idx, idx, vec_len);
+      // Compare strings.
+      __ sve_cmp(Assembler::NE, pgtmp2, mode == LL ? __ B : __ H, pgtmp1, ztmp1, ztmp2);
+      __ br(__ NE, MISMATCH);
+      __ cmp(idx, rscratch1);
+      __ br(__ LT, LOOP);
+
+    // post loop, last iteration
+    __ sve_whilelt(pgtmp1, mode == LL ? __ B : __ H, idx, cnt);
+
+    LOAD_PAIR(ztmp1, ztmp2, pgtmp1, src1, src2, idx);
+    __ sve_cmp(Assembler::NE, pgtmp2, mode == LL ? __ B : __ H, pgtmp1, ztmp1, ztmp2);
+    __ br(__ EQ, DONE);
+
+    __ bind(MISMATCH);
+
+    // Crop the vector to find its location.
+    __ sve_brkb(pgtmp2, pgtmp1, pgtmp2, false /* isMerge */);
+    // Extract the first different characters of each string.
+    __ sve_lasta(rscratch1, mode == LL ? __ B : __ H, pgtmp2, ztmp1);
+    __ sve_lasta(rscratch2, mode == LL ? __ B : __ H, pgtmp2, ztmp2);
+
+    // Compute the difference of the first different characters.
+    __ sub(result, rscratch1, rscratch2);
+
+    __ bind(DONE);
+    __ ret(lr);
+#undef LOAD_PAIR
+    return entry;
+  }
+
   void generate_compare_long_strings() {
+    if (UseSVE == 0) {
       StubRoutines::aarch64::_compare_long_string_LL
           = generate_compare_long_string_same_encoding(true);
       StubRoutines::aarch64::_compare_long_string_UU
@@ -5333,6 +5446,16 @@ class StubGenerator: public StubCodeGenerator {
           = generate_compare_long_string_different_encoding(true);
       StubRoutines::aarch64::_compare_long_string_UL
           = generate_compare_long_string_different_encoding(false);
+    } else {
+      StubRoutines::aarch64::_compare_long_string_LL
+          = generate_compare_long_string_sve(LL);
+      StubRoutines::aarch64::_compare_long_string_UU
+          = generate_compare_long_string_sve(UU);
+      StubRoutines::aarch64::_compare_long_string_LU
+          = generate_compare_long_string_sve(LU);
+      StubRoutines::aarch64::_compare_long_string_UL
+          = generate_compare_long_string_sve(UL);
+    }
   }
 
   // R0 = result