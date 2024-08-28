@@ -41,7 +41,7 @@
  * (transparent representations of the underlying key material), and vice
  * versa.
  *
- * <P> Key factories are bi-directional. That is, they allow you to build an
+ * <P> Key factories are bidirectional. That is, they allow you to build an
  * opaque key object from a given key specification (key material), or to
  * retrieve the underlying key material of a key object in a suitable format.
  *
@@ -158,7 +158,7 @@ private KeyFactory(String algorithm) throws NoSuchAlgorithmException {
      * {@code jdk.security.provider.preferred}
      * {@link Security#getProperty(String) Security} property to determine
      * the preferred provider order for the specified algorithm. This
-     * may be different than the order of providers returned by
+     * may be different from the order of providers returned by
      * {@link Security#getProviders() Security.getProviders()}.
      *
      * @param algorithm the name of the requested key algorithm.