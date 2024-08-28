@@ -189,6 +189,19 @@ public static String getVMVersion() {
         return vmVersion;
     }
 
+    public static boolean isMusl() {
+        try {
+            ProcessBuilder pb = new ProcessBuilder("ldd", "--version");
+            pb.redirectErrorStream(true);
+            Process p = pb.start();
+            BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
+            String l = b.readLine();
+            if (l != null && l.contains("musl")) { return true; }
+        } catch(Exception e) {
+        }
+        return false;
+    }
+
     public static boolean isAArch64() {
         return isArch("aarch64");
     }