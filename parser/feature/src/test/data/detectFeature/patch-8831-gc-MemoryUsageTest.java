@@ -27,16 +27,13 @@
  * Test observers the progress on used/committed memory.
  * MemoryPoolMXBean is used for that purpose.
  *
- * Depending on command line option the test checks either Metaspace or
- * Compressed Class Space area.
- *
  * This test checks two things:
  * 1) Loading/Unloading classes doesn't cause memory increase
  * 2) Loading classes causes permanent increase of memory.
  */
 public class MemoryUsageTest extends MetaspaceBaseGC {
 
-    private String pool_name;
+    private final String pool_name = "Metaspace";
 
     public static void main(String[] args) {
         new MemoryUsageTest().run(args);
@@ -127,32 +124,8 @@ public void checkForGrowing() {
         }
     }
 
-    /**
-     * Looks up for memory pool name.
-     * @param args command line options
-     */
     @Override
     protected void parseArgs(String[] args) {
-        if (args.length != 1) {
-            printUsage();
-            throw new Fault("MemoryPool is not specified");
-        }
-
-        String a = args[0];
-        if (a.equalsIgnoreCase("-pool:compressed")) {
-             pool_name = "Compressed Class Space";
-        } else if (a.equalsIgnoreCase("-pool:metaspace")) {
-             pool_name = "Metaspace";
-        } else {
-            printUsage();
-            throw new Fault("Unrecongnized argument: " + a);
-        }
-    }
-
-    private void printUsage() {
-        System.err.println("Usage: ");
-        System.err.println("java [-Xms..] [-XX:MetaspaceSize=..]  [-XX:MaxMetaspaceSize=..] \\");
-        System.err.println("    " + MemoryUsageTest.class.getCanonicalName() + " -pool:<metaspace|compressed>");
     }
 
     /**