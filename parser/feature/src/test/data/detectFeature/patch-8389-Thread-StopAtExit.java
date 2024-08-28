@@ -23,14 +23,12 @@
 
 /**
  * @test
- * @bug 8167108 8266130 8282704 8283467 8284632
+ * @bug 8167108 8266130 8283467 8284632
  * @summary Stress test JVM/TI StopThread() at thread exit.
  * @requires vm.jvmti
- * @modules java.base/java.lang:open
  * @run main/othervm/native -agentlib:StopAtExit StopAtExit
  */
 
-import java.lang.reflect.Method;
 import java.util.concurrent.CountDownLatch;
 import java.util.concurrent.TimeUnit;
 
@@ -44,10 +42,6 @@ public class StopAtExit extends Thread {
 
     native static int stopThread(StopAtExit thr, Throwable exception);
 
-    public StopAtExit(ThreadGroup group, Runnable target) {
-        super(group, target);
-    }
-
     @Override
     public void run() {
         try {
@@ -82,19 +76,12 @@ public static void main(String[] args) {
         System.out.println("About to execute for " + timeMax + " seconds.");
 
         long count = 0;
-        long manualDestroyCnt = 0;
-        long manualTerminateCnt = 0;
         long start_time = System.currentTimeMillis();
         while (System.currentTimeMillis() < start_time + (timeMax * 1000)) {
             count++;
 
-            // Use my own ThreadGroup so the thread count is known and make
-            // it a daemon ThreadGroup so it is automatically destroyed when
-            // the thread is terminated.
-            ThreadGroup myTG = new ThreadGroup("myTG-" + count);
-            myTG.setDaemon(true);
             int retCode;
-            StopAtExit thread = new StopAtExit(myTG, null);
+            StopAtExit thread = new StopAtExit();
             thread.start();
             try {
                 // Wait for the worker thread to get going.
@@ -162,48 +149,8 @@ public static void main(String[] args) {
                                            JVMTI_ERROR_THREAD_NOT_ALIVE + ").");
             }
 
-            if (myTG.activeCount() != 0) {
-                // If the ThreadGroup still has a count, then the thread
-                // received the async exception while in exit() so we need
-                // to do a manual terminate.
-                manualTerminateCnt++;
-                try {
-                    threadTerminated(myTG, thread);
-                } catch (Exception e) {
-                    throw new Error("threadTerminated() threw unexpected: " + e);
-                }
-                int activeCount = myTG.activeCount();
-                if (activeCount != 0) {
-                    throw new Error("threadTerminated() did not clean up " +
-                                    "worker thread: count=" + activeCount);
-                }
-                if (!myTG.isDestroyed()) {
-                    throw new Error("threadTerminated() did not destroy " +
-                                    myTG.getName());
-                }
-            } else if (!myTG.isDestroyed()) {
-                // If the ThreadGroup does not have a count, but is not
-                // yet destroyed, then the thread received the async
-                // exception while the thread was in the later stages of
-                // its threadTerminated() call so we need to do a manual
-                // destroy.
-                manualDestroyCnt++;
-                try {
-                    myTG.destroy();
-                } catch (Exception e) {
-                    throw new Error("myTG.destroy() threw unexpected: " + e);
-                }
-            }
         }
 
-        if (manualDestroyCnt != 0) {
-            System.out.println("Manually destroyed ThreadGroup " +
-                               manualDestroyCnt + " times.");
-        }
-        if (manualTerminateCnt != 0) {
-            System.out.println("Manually terminated Thread " +
-                               manualTerminateCnt + " times.");
-        }
         System.out.println("Executed " + count + " loops in " + timeMax +
                            " seconds.");
 
@@ -214,13 +161,6 @@ public static void main(String[] args) {
         }
     }
 
-    static void threadTerminated(ThreadGroup group, Thread thread) throws Exception {
-        // ThreadGroup.threadTerminated() is package private:
-        Method method = ThreadGroup.class.getDeclaredMethod("threadTerminated", Thread.class);
-        method.setAccessible(true);
-        method.invoke(group, thread);
-    }
-
     public static void usage() {
         System.err.println("Usage: " + PROG_NAME + " [time_max]");
         System.err.println("where:");