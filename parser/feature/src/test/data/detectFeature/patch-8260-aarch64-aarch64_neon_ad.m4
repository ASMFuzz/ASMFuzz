@@ -2548,7 +2548,7 @@ instruct vmask_lasttrue8B(iRegINoSp dst, vecD src) %{
     // bytes with 0x00/0x01 as element values.
     //
     // Computed by counting the leading zero bytes and
-    // substracting it by 7 (VLENGTH - 1).
+    // subtracting it by 7 (VLENGTH - 1).
     __ fmovd($dst$$Register, as_FloatRegister($src$$reg));
     __ clz($dst$$Register, $dst$$Register);
     __ movw(rscratch1, 7);
@@ -2580,7 +2580,7 @@ instruct vmask_lasttrue16B(iRegINoSp dst, vecX src) %{
     __ fmovd($dst$$Register, as_FloatRegister($src$$reg));
     __ movw(rscratch1, 8 - 1);
 
-    // Count the leading zero bytes and substract it by 15 (VLENGTH - 1).
+    // Count the leading zero bytes and subtract it by 15 (VLENGTH - 1).
     __ bind(LAST_TRUE_INDEX);
     __ clz($dst$$Register, $dst$$Register);
     __ subw($dst$$Register, rscratch1, $dst$$Register, Assembler::LSR, 3);