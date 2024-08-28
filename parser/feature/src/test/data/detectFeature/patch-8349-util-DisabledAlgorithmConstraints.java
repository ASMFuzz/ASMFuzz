@@ -27,6 +27,7 @@
 
 import sun.security.validator.Validator;
 
+import java.lang.ref.SoftReference;
 import java.security.AlgorithmParameters;
 import java.security.CryptoPrimitive;
 import java.security.Key;
@@ -45,7 +46,6 @@
 import java.time.ZoneId;
 import java.util.ArrayList;
 import java.util.Arrays;
-import java.util.Date;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.List;
@@ -54,6 +54,7 @@
 import java.util.Set;
 import java.util.Collection;
 import java.util.StringTokenizer;
+import java.util.concurrent.ConcurrentHashMap;
 import java.util.regex.Pattern;
 import java.util.regex.Matcher;
 
@@ -101,6 +102,8 @@ private static class JarHolder {
 
     private final Set<String> disabledAlgorithms;
     private final Constraints algorithmConstraints;
+    private volatile SoftReference<Map<String, Boolean>> cacheRef =
+            new SoftReference<>(null);
 
     public static DisabledAlgorithmConstraints certPathConstraints() {
         return CertPathHolder.CONSTRAINTS;
@@ -158,7 +161,7 @@ public final boolean permits(Set<CryptoPrimitive> primitives,
                     " or empty.");
         }
 
-        if (!checkAlgorithm(disabledAlgorithms, algorithm, decomposer)) {
+        if (!cachedCheckAlgorithm(algorithm)) {
             return false;
         }
 
@@ -241,7 +244,7 @@ public final void permits(String algorithm, ConstraintsParameters cp,
             // Check if named curves in the key are disabled.
             for (Key key : cp.getKeys()) {
                 for (String curve : getNamedCurveFromKey(key)) {
-                    if (!checkAlgorithm(disabledAlgorithms, curve, decomposer)) {
+                    if (!cachedCheckAlgorithm(curve)) {
                         throw new CertPathValidatorException(
                             "Algorithm constraints check failed on disabled " +
                                     "algorithm: " + curve,
@@ -947,6 +950,25 @@ private boolean permitsImpl(Key key) {
         }
     }
 
+    private boolean cachedCheckAlgorithm(String algorithm) {
+        Map<String, Boolean> cache;
+        if ((cache = cacheRef.get()) == null) {
+            synchronized (this) {
+                if ((cache = cacheRef.get()) == null) {
+                    cache = new ConcurrentHashMap<>();
+                    cacheRef = new SoftReference<>(cache);
+                }
+            }
+        }
+        Boolean result = cache.get(algorithm);
+        if (result != null) {
+            return result;
+        }
+        result = checkAlgorithm(disabledAlgorithms, algorithm, decomposer);
+        cache.put(algorithm, result);
+        return result;
+    }
+
     /*
      * This constraint is used for the complete disabling of the algorithm.
      */