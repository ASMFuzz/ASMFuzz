@@ -36,6 +36,8 @@ public class VThreadTest {
     static final int MSG_COUNT = 10*1000;
     static final SynchronousQueue<String> QUEUE = new SynchronousQueue<>();
 
+    static native boolean check();
+
     static void producer(String msg) throws InterruptedException {
         int ii = 1;
         long ll = 2*(long)ii;
@@ -66,6 +68,9 @@ public static void test1() throws Exception {
         Thread consumer = Thread.ofVirtual().name("VThread-Consumer").start(CONSUMER);
         producer.join();
         consumer.join();
+        if (!check()) {
+            throw new RuntimeException("VThreadTest failed!");
+        }
     }
 
     void runTest() throws Exception {