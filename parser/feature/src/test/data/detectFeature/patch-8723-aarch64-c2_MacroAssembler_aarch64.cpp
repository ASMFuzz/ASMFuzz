@@ -676,7 +676,8 @@ void C2_MacroAssembler::stringL_indexof_char(Register str1, Register cnt1,
 // Compare strings.
 void C2_MacroAssembler::string_compare(Register str1, Register str2,
     Register cnt1, Register cnt2, Register result, Register tmp1, Register tmp2,
-    FloatRegister vtmp1, FloatRegister vtmp2, FloatRegister vtmp3, int ae) {
+    FloatRegister vtmp1, FloatRegister vtmp2, FloatRegister vtmp3,
+    PRegister pgtmp1, PRegister pgtmp2, int ae) {
   Label DONE, SHORT_LOOP, SHORT_STRING, SHORT_LAST, TAIL, STUB,
       DIFF, NEXT_WORD, SHORT_LOOP_TAIL, SHORT_LAST2, SHORT_LAST_INIT,
       SHORT_LOOP_START, TAIL_CHECK;