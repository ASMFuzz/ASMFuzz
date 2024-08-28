@@ -157,7 +157,6 @@ source %{
     }
     return op_sve_supported(opcode, vlen, bt);
   }
-
 %}
 
 definitions %{
@@ -2123,6 +2122,32 @@ instruct vroundD(vReg dst, vReg src, immI rmode) %{
   %}
   ins_pipe(pipe_slow);
 %}
+define(`VECTOR_JAVA_FROUND', `
+instruct vround$1to$3($7 dst, $7 src, $7 tmp1, $7 tmp2, $7 tmp3, pRegGov ptmp)
+%{
+  predicate(UseSVE > 0);
+  match(Set dst (RoundV$1 src));
+  effect(TEMP_DEF dst, TEMP tmp1, TEMP tmp2, TEMP tmp3, TEMP ptmp);
+  format %{ "sve_vround  $dst, $4, $src\t# round $1 to $3 vector" %}
+  ins_encode %{
+    BasicType bt = Matcher::vector_element_basic_type(this);
+    int vlen = Matcher::vector_length_in_bytes(this);
+    if (vlen > 16) {
+      __ vector_round_sve(as_FloatRegister($dst$$reg), as_FloatRegister($src$$reg),
+                          as_FloatRegister($tmp1$$reg), as_FloatRegister($tmp2$$reg),
+                          as_PRegister($ptmp$$reg), __ $4);
+    } else {
+      __ vector_round_neon(as_FloatRegister($dst$$reg), as_FloatRegister($src$$reg),
+                           as_FloatRegister($tmp1$$reg), as_FloatRegister($tmp2$$reg),
+                           as_FloatRegister($tmp3$$reg),
+                           __ esize2arrangement(type2aelembytes(bt),
+                              /*isQ*/ vlen == 16));
+    }
+  %}
+  ins_pipe(pipe_class_default);
+%}')dnl           $1  $2  $3 $4 $5    $6    $7
+VECTOR_JAVA_FROUND(F, 8F,  I, S, 8,  INT, vReg)
+VECTOR_JAVA_FROUND(D, 4D,  L, D, 4, LONG, vReg)
 dnl
 dnl REPLICATE($1,        $2,      $3,      $4,   $5         )
 dnl REPLICATE(insn_name, op_name, reg_src, size, min_vec_len)