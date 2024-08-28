@@ -2979,6 +2979,8 @@ instruct populateindex(vReg dst, iRegIorL2I src1, immI src2) %{
   ins_pipe(pipe_slow);
 %}
 
+// ----------------------------- String Intrinsics -------------------------------
+
 // Intrisics for String.indexOf(char)
 
 dnl
@@ -3004,6 +3006,42 @@ dnl                 $1 $2      $3
 STRING_INDEXOF_CHAR(L, Latin1, true)
 STRING_INDEXOF_CHAR(U, UTF16,  false)
 
+// Intrisics for String.compareTo()
+
+// Note that Z registers alias the corresponding NEON registers, we declare the vector operands of
+// these string_compare variants as NEON register type for convenience so that the prototype of
+// string_compare can be shared with all variants.
+
+dnl
+define(`STRING_COMPARETO', `
+instruct string_compare$1_sve(iRegP_R1 str1, iRegI_R2 cnt1, iRegP_R3 str2, iRegI_R4 cnt2,
+                              iRegI_R0 result, iRegP_R10 tmp1, iRegL_R11 tmp2,
+                              vRegD_V0 vtmp1, vRegD_V1 vtmp2, pRegGov_P0 pgtmp1,
+                              pRegGov_P1 pgtmp2, rFlagsReg cr)
+%{
+  predicate((UseSVE > 0) && (((StrCompNode*)n)->encoding() == StrIntrinsicNode::$1));
+  match(Set result (StrComp (Binary str1 cnt1) (Binary str2 cnt2)));
+  effect(TEMP tmp1, TEMP tmp2, TEMP vtmp1, TEMP vtmp2, TEMP pgtmp1, TEMP pgtmp2,
+         USE_KILL str1, USE_KILL str2, USE_KILL cnt1, USE_KILL cnt2, KILL cr);
+
+  format %{ "String Compare $str1,$cnt1,$str2,$cnt2 -> $result   # USE sve" %}
+  ins_encode %{
+    // Count is in 8-bit bytes; non-Compact chars are 16 bits.
+    __ string_compare($str1$$Register, $str2$$Register,
+                      $cnt1$$Register, $cnt2$$Register, $result$$Register,
+                      $tmp1$$Register, $tmp2$$Register,
+                      $vtmp1$$FloatRegister, $vtmp2$$FloatRegister, fnoreg,
+                      as_PRegister($pgtmp1$$reg), as_PRegister($pgtmp2$$reg),
+                      StrIntrinsicNode::$1);
+  %}
+  ins_pipe(pipe_class_memory);
+%}')dnl
+dnl              $1
+STRING_COMPARETO(LL)
+STRING_COMPARETO(LU)
+STRING_COMPARETO(UL)
+STRING_COMPARETO(UU)
+
 // ---------------------------- Vector mask reductions ---------------------------
 instruct vmask_truecount(iRegINoSp dst, pReg src) %{
   predicate(UseSVE > 0);