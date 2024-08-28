@@ -1601,7 +1601,7 @@ private String version() {
         return System.getProperty("java.version");
     }
 
-    private static String getMessage(String key, Object... args) {
+    static String getMessage(String key, Object... args) {
         try {
             return MessageFormat.format(ResourceBundleHelper.bundle.getString(key), args);
         } catch (MissingResourceException e) {