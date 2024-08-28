@@ -203,6 +203,10 @@ class methodHandle;
   /* Special flavor of dsqrt intrinsic to handle the "native" method in StrictMath. Otherwise the same as in Math. */   \
   do_intrinsic(_dsqrt_strict,             java_lang_StrictMath,   sqrt_name,          double_double_signature,   F_SN)  \
                                                                                                                         \
+  do_intrinsic(_floatIsInfinite,          java_lang_Float,        isInfinite_name,    float_bool_signature,      F_S)   \
+   do_name(     isInfinite_name,                                  "isInfinite")                                         \
+  do_intrinsic(_doubleIsInfinite,         java_lang_Double,       isInfinite_name,    double_bool_signature,     F_S)   \
+                                                                                                                        \
   do_intrinsic(_floatToRawIntBits,        java_lang_Float,        floatToRawIntBits_name,   float_int_signature, F_SN)  \
    do_name(     floatToRawIntBits_name,                          "floatToRawIntBits")                                   \
   do_intrinsic(_floatToIntBits,           java_lang_Float,        floatToIntBits_name,      float_int_signature, F_S)   \