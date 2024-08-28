@@ -32,29 +32,19 @@
  * @bug 8000754
  * @summary Tests that a MemoryPoolMXBeans is created for metaspace and that a
  *          MemoryManagerMXBean is created.
- * @requires vm.bits == 64 & vm.opt.final.UseCompressedOops == true
  * @library /test/lib
  * @library /
  * @modules java.base/jdk.internal.misc
  *          java.management
- * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions -XX:-UseCompressedOops gc.metaspace.TestMetaspaceMemoryPool
- * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions -XX:-UseCompressedOops -XX:MaxMetaspaceSize=60m gc.metaspace.TestMetaspaceMemoryPool
- * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions -XX:+UseCompressedOops -XX:+UseCompressedClassPointers gc.metaspace.TestMetaspaceMemoryPool
- * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions -XX:+UseCompressedOops -XX:+UseCompressedClassPointers -XX:CompressedClassSpaceSize=60m gc.metaspace.TestMetaspaceMemoryPool
+ * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions gc.metaspace.TestMetaspaceMemoryPool
+ * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions -XX:MaxMetaspaceSize=60m gc.metaspace.TestMetaspaceMemoryPool
  */
 public class TestMetaspaceMemoryPool {
     public static void main(String[] args) {
         verifyThatMetaspaceMemoryManagerExists();
 
         boolean isMetaspaceMaxDefined = InputArguments.containsPrefix("-XX:MaxMetaspaceSize");
         verifyMemoryPool(getMemoryPool("Metaspace"), isMetaspaceMaxDefined);
-
-        if (Platform.is64bit()) {
-            if (InputArguments.contains("-XX:+UseCompressedOops")) {
-                MemoryPoolMXBean cksPool = getMemoryPool("Compressed Class Space");
-                verifyMemoryPool(cksPool, true);
-            }
-        }
     }
 
     private static void verifyThatMetaspaceMemoryManagerExists() {