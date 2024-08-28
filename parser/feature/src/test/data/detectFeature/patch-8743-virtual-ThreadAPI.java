@@ -23,11 +23,12 @@
 
 /**
  * @test
+ * @bug 8284161 8286788
  * @summary Test Thread API with virtual threads
+ * @enablePreview
  * @modules java.base/java.lang:+open
  * @library /test/lib
- * @compile --enable-preview -source ${jdk.version} ThreadAPI.java
- * @run testng/othervm/timeout=300 --enable-preview ThreadAPI
+ * @run testng/othervm/timeout=300 ThreadAPI
  */
 
 import java.time.Duration;
@@ -1897,19 +1898,19 @@ public void testGetStackTrace3() throws Exception {
         var thread = Thread.ofVirtual().start(() -> {
             try { sel.select(); } catch (Exception e) { }
         });
-        Thread.sleep(200);  // give time for thread to block
         try {
-            assertTrue(thread.getState() == Thread.State.RUNNABLE);
-            StackTraceElement[] stack = thread.getStackTrace();
-            assertTrue(contains(stack, "select"));
+            while (!contains(thread.getStackTrace(), "select")) {
+                assertTrue(thread.isAlive());
+                Thread.sleep(20);
+            }
         } finally {
             sel.close();
             thread.join();
         }
     }
 
     /**
-     * Test Thread::getStackTrace on running thread waiting in Object.wait.
+     * Test Thread::getStackTrace on thread waiting in Object.wait.
      */
     @Test
     public void testGetStackTrace4() throws Exception {