@@ -131,11 +131,15 @@ intx CompilerConfig::scaled_compile_threshold(intx threshold, double scale) {
   } else {
     double v = threshold * scale;
     assert(v >= 0, "must be");
-    if (v > max_intx) {
+    if (g_isnan(v) || !g_isfinite(v)) {
+      return max_intx;
+    }
+    int exp;
+    (void) frexp(v, &exp);
+    if (exp > 63) {
       return max_intx;
-    } else {
-      return (intx)(v);
     }
+    return (intx)(v);
   }
 }
 