@@ -148,6 +148,8 @@ source %{
         if (UseSVE < 2 || is_subword_type(bt)) return false;
       case Op_VectorMaskToLong:
         if (vlen > 64) return false;
+      case Op_VectorLongToMask:
+        if (UseSVE < 2 || vlen > 64 || !VM_Version::supports_svebitperm()) return false;
       default:
         break;
     }
@@ -3168,6 +3170,20 @@ instruct vmask_tolong(iRegLNoSp dst, pReg src, vReg vtmp1, vReg vtmp2) %{
   ins_pipe(pipe_slow);
 %}
 
+instruct vmask_fromlong(pRegGov dst, iRegL src, vReg vtmp1, vReg vtmp2) %{
+  match(Set dst (VectorLongToMask src));
+  effect(TEMP vtmp1, TEMP vtmp2);
+  ins_cost(10 * SVE_COST);
+  format %{ "vmask_fromlong $dst, $src\t# vector mask fromlong (sve2)" %}
+  ins_encode %{
+    __ sve_vmask_fromlong(as_PRegister($dst$$reg), as_Register($src$$reg),
+                          Matcher::vector_element_basic_type(this),
+                          Matcher::vector_length(this),
+                          as_FloatRegister($vtmp1$$reg), as_FloatRegister($vtmp2$$reg));
+  %}
+  ins_pipe(pipe_slow);
+%}
+
 // ---------------------------- Vector mask generation ---------------------------
 // The rules below set predicate registers. They can guarantee the high bits of dst
 // are cleared with zero when the vector length is less than the full size of