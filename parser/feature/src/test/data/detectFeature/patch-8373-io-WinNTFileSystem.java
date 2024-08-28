@@ -48,16 +48,15 @@ class WinNTFileSystem extends FileSystem {
 
     // Whether to enable alternative data streams (ADS) by suppressing
     // checking the path for invalid characters, in particular ":".
-    // ADS support will be enabled if and only if the property is set and
-    // is the empty string or is equal, ignoring case, to the string "true".
-    // By default ADS support is disabled.
+    // By default, ADS support is enabled and will be disabled if and
+    // only if the property is set, ignoring case, to the string "false".
     private static final boolean ENABLE_ADS;
     static {
         String enableADS = GetPropertyAction.privilegedGetProperty("jdk.io.File.enableADS");
         if (enableADS != null) {
-            ENABLE_ADS = "".equals(enableADS) || Boolean.parseBoolean(enableADS);
+            ENABLE_ADS = !enableADS.equalsIgnoreCase(Boolean.FALSE.toString());
         } else {
-            ENABLE_ADS = false;
+            ENABLE_ADS = true;
         }
     }
 