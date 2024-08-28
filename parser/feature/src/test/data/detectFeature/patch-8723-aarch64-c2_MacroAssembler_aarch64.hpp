@@ -32,7 +32,8 @@
   void string_compare(Register str1, Register str2,
                       Register cnt1, Register cnt2, Register result,
                       Register tmp1, Register tmp2, FloatRegister vtmp1,
-                      FloatRegister vtmp2, FloatRegister vtmp3, int ae);
+                      FloatRegister vtmp2, FloatRegister vtmp3,
+                      PRegister pgtmp1, PRegister pgtmp2, int ae);
 
   void string_indexof(Register str1, Register str2,
                       Register cnt1, Register cnt2,