@@ -178,6 +178,10 @@ public static boolean isOSX() {
         return (OS.contains("mac"));
     }
 
+    public static boolean isArmMac() {
+        return (isOSX() && "aarch64".equals(System.getProperty("os.arch")));
+    }
+
     public static boolean isLinux() {
         return ((OS.contains("nix") || OS.contains("nux")));
     }