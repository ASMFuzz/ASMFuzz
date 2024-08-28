@@ -207,7 +207,7 @@ private static KeyPairGenerator getInstance(Instance instance,
      * {@code jdk.security.provider.preferred}
      * {@link Security#getProperty(String) Security} property to determine
      * the preferred provider order for the specified algorithm. This
-     * may be different than the order of providers returned by
+     * may be different from the order of providers returned by
      * {@link Security#getProviders() Security.getProviders()}.
      *
      * @param algorithm the standard string name of the algorithm.
@@ -232,7 +232,7 @@ public static KeyPairGenerator getInstance(String algorithm)
         List<Service> list =
                 GetInstance.getServices("KeyPairGenerator", algorithm);
         Iterator<Service> t = list.iterator();
-        if (t.hasNext() == false) {
+        if (!t.hasNext()) {
             throw new NoSuchAlgorithmException
                 (algorithm + " KeyPairGenerator not available");
         }