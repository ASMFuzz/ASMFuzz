@@ -85,7 +85,7 @@ public boolean isForwardCheckingSupported() {
     @Override
     public Set<String> getSupportedExtensions() {
         if (supportedExts == null) {
-            supportedExts = new HashSet<String>(3);
+            supportedExts = HashSet.newHashSet(3);
             supportedExts.add(KeyUsage_Id.toString());
             supportedExts.add(ExtendedKeyUsage_Id.toString());
             supportedExts.add(SubjectAlternativeName_Id.toString());