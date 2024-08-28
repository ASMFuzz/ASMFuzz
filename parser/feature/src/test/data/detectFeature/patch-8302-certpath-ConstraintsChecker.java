@@ -92,7 +92,7 @@ public boolean isForwardCheckingSupported() {
     @Override
     public Set<String> getSupportedExtensions() {
         if (supportedExts == null) {
-            supportedExts = new HashSet<String>(2);
+            supportedExts = HashSet.newHashSet(2);
             supportedExts.add(BasicConstraints_Id.toString());
             supportedExts.add(NameConstraints_Id.toString());
             supportedExts = Collections.unmodifiableSet(supportedExts);