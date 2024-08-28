@@ -160,6 +160,9 @@ public final boolean permits(Set<CryptoPrimitive> primitives,
             throw new IllegalArgumentException("The primitives cannot be null" +
                     " or empty.");
         }
+        if (algorithm == null || algorithm.isEmpty()) {
+            throw new IllegalArgumentException("No algorithm name specified");
+        }
 
         if (!cachedCheckAlgorithm(algorithm)) {
             return false;