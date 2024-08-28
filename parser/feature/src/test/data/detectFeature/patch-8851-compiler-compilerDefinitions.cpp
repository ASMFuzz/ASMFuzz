@@ -136,10 +136,13 @@ intx CompilerConfig::scaled_compile_threshold(intx threshold, double scale) {
     }
     int exp;
     (void) frexp(v, &exp);
-    if (exp > 63) {
+    int max_exp = sizeof(intx) * BitsPerByte - 1;
+    if (exp > max_exp) {
       return max_intx;
     }
-    return (intx)(v);
+    intx r = (intx)(v);
+    assert(r >= 0, "must be");
+    return r;
   }
 }
 