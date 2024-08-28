@@ -23,6 +23,7 @@
 
 /**
  * @test
+ * @bug 8284161 8287103
  * @summary Test ThredMXBean.findMonitorDeadlockedThreads with cycles of
  *   platform and virtual threads in deadlock
  * @compile --enable-preview -source ${jdk.version} VirtualThreadDeadlocks.java
@@ -40,6 +41,8 @@ public class VirtualThreadDeadlocks {
     private static final Object LOCK1 = new Object();
     private static final Object LOCK2 = new Object();
 
+    private static volatile boolean lock2Held;
+
     /**
      * PP = test deadlock with two platform threads
      * PV = test deadlock with one platform thread and one virtual thread
@@ -53,7 +56,9 @@ public static void main(String[] args) throws Exception {
                 : Thread.ofVirtual();
         Thread thread1 = builder1.start(() -> {
             synchronized (LOCK1) {
-                try { Thread.sleep(1000); } catch (Exception e) { }
+                while (!lock2Held) {
+                    try { Thread.sleep(10); } catch (Exception e) { }
+                }
                 synchronized (LOCK2) { }
             }
         });
@@ -65,7 +70,7 @@ public static void main(String[] args) throws Exception {
                 : Thread.ofVirtual();
         Thread thread2 = builder2.start(() -> {
             synchronized (LOCK2) {
-                try { Thread.sleep(1000); } catch (Exception e) { }
+                lock2Held = true;
                 synchronized (LOCK1) { }
             }
         });