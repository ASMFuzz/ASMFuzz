@@ -107,12 +107,4 @@ default JavaKind getJavaKind() {
 
     @Override
     ResolvedJavaMethod getClassInitializer();
-
-    /**
-     * Gets the fingerprint for this type.
-     *
-     * @return the value of the fingerprint ({@code 0} for arrays and synthetic classes or if the VM
-     *         does not support fingerprints)
-     */
-    long getFingerprint();
 }