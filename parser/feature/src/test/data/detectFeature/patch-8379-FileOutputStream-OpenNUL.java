@@ -26,7 +26,9 @@
  * @bug 8285445
  * @requires (os.family == "windows")
  * @summary Verify behavior of opening "NUL:" with ADS enabled and disabled.
+ * @run main/othervm OpenNUL
  * @run main/othervm -Djdk.io.File.enableADS OpenNUL
+ * @run main/othervm -Djdk.io.File.enableADS=FalsE OpenNUL
  * @run main/othervm -Djdk.io.File.enableADS=true OpenNUL
  */
 
@@ -36,7 +38,7 @@
 
 public class OpenNUL {
     public static void main(String args[]) throws IOException {
-        String enableADS = System.getProperty("jdk.io.File.enableADS");
+        String enableADS = System.getProperty("jdk.io.File.enableADS", "true");
         boolean fails = enableADS.equalsIgnoreCase(Boolean.FALSE.toString());
 
         FileOutputStream fos;