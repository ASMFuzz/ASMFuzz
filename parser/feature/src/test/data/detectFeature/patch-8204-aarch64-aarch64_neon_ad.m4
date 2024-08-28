@@ -349,6 +349,25 @@ VECTOR_CAST_F2F(F, D, X, D, fcvtl, 2S, 2D)
 VECTOR_CAST_F2F(D, F, D, X, fcvtn, 2D, 2S)
 dnl
 
+define(`VECTOR_JAVA_FROUND', `
+instruct vround$7$2to$5$3($7 dst, $7 src, $7 tmp1, $7 tmp2, $7 tmp3)
+%{
+  predicate(UseSVE == 0 &&
+            n->as_Vector()->length() == $5 && n->bottom_type()->is_vect()->element_basic_type() == T_$6);
+  match(Set dst (RoundV$1 src));
+  effect(TEMP_DEF dst, TEMP tmp1, TEMP tmp2, TEMP tmp3);
+  format %{ "vround  $dst, $4, $src\t# round $7 $2 to $5$3 vector" %}
+  ins_encode %{
+    __ vector_round_neon(as_FloatRegister($dst$$reg), as_FloatRegister($src$$reg),
+                         as_FloatRegister($tmp1$$reg), as_FloatRegister($tmp2$$reg),
+                         as_FloatRegister($tmp3$$reg), __ $4);
+  %}
+  ins_pipe(pipe_class_default);
+%}')dnl           $1  $2  $3   $4 $5    $6    $7
+VECTOR_JAVA_FROUND(F, 2F,  I, T2S, 2,  INT, vecD)
+VECTOR_JAVA_FROUND(F, 4F,  I, T4S, 4,  INT, vecX)
+VECTOR_JAVA_FROUND(D, 2D,  L, T2D, 2, LONG, vecX)
+
 // ------------------------------ Reduction -------------------------------
 dnl
 define(`REDUCE_ADD_BORS', `