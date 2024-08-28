@@ -39,16 +39,11 @@
  * @modules java.base/jdk.internal.misc
  *          java.management
  *          jdk.internal.jvmstat/sun.jvmstat.monitor
- * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions -Xlog:class+load,class+unload=trace -XX:-UseCompressedOops -XX:-UseCompressedClassPointers -XX:+UseSerialGC -XX:+UsePerfData -Xint gc.metaspace.TestPerfCountersAndMemoryPools
- * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions -Xlog:class+load,class+unload=trace -XX:+UseCompressedOops -XX:+UseCompressedClassPointers -XX:+UseSerialGC -XX:+UsePerfData -Xint gc.metaspace.TestPerfCountersAndMemoryPools
+ * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions -Xlog:class+load,class+unload=trace -XX:+UseSerialGC -XX:+UsePerfData -Xint gc.metaspace.TestPerfCountersAndMemoryPools
  */
 public class TestPerfCountersAndMemoryPools {
     public static void main(String[] args) throws Exception {
         checkMemoryUsage("Metaspace", "sun.gc.metaspace");
-
-        if (InputArguments.contains("-XX:+UseCompressedClassPointers") && Platform.is64bit()) {
-            checkMemoryUsage("Compressed Class Space", "sun.gc.compressedclassspace");
-        }
     }
 
     private static MemoryPoolMXBean getMemoryPool(String memoryPoolName) {