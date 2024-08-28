@@ -24,76 +24,33 @@
 /**
  * @test
  * @bug 8283044
+ * @requires vm.compiler1.enabled | vm.compiler2.enabled
  * @summary Stress delivery of asynchronous exceptions.
  * @library /test/lib /test/hotspot/jtreg
  * @build AsyncExceptionTest
- * @run driver jdk.test.lib.helpers.ClassFileInstaller sun.hotspot.WhiteBox
- * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI AsyncExceptionTest
+ * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -Xcomp
+                     -XX:CompileCommand=dontinline,AsyncExceptionTest::internalRun2
+                     -XX:CompileCommand=compileonly,AsyncExceptionTest::internalRun1
+                     -XX:CompileCommand=compileonly,AsyncExceptionTest::internalRun2
+                     AsyncExceptionTest
  */
 
-import compiler.testlibrary.CompilerUtils;
-import compiler.whitebox.CompilerWhiteBoxTest;
 import java.util.concurrent.CountDownLatch;
-import sun.hotspot.WhiteBox;
 
 public class AsyncExceptionTest extends Thread {
     private final static int DEF_TIME_MAX = 30;  // default max # secs to test
     private final static String PROG_NAME = "AsyncExceptionTest";
 
-    public static final WhiteBox WB = WhiteBox.getWhiteBox();
-
     public CountDownLatch exitSyncObj = new CountDownLatch(1);
     public CountDownLatch startSyncObj = new CountDownLatch(1);
 
-    private boolean realRun;
     private boolean firstEntry = true;
     private boolean receivedThreadDeathinInternal1 = false;
     private boolean receivedThreadDeathinInternal2 = false;
 
-    public void setDontInline(String method) {
-        java.lang.reflect.Method m;
-        try {
-            m = AsyncExceptionTest.class.getMethod(method);
-        } catch(NoSuchMethodException e) {
-            throw new RuntimeException("Unexpected: " + e);
-        }
-        WB.testSetDontInlineMethod(m, true);
-    }
-
-    public void checkCompLevel(String method) {
-        int highestLevel = CompilerUtils.getMaxCompilationLevel();
-        java.lang.reflect.Method m;
-        try {
-            m = AsyncExceptionTest.class.getMethod(method);
-        } catch(NoSuchMethodException e) {
-            throw new RuntimeException("Unexpected: " + e);
-        }
-        int compLevel = WB.getMethodCompilationLevel(m);
-        while (compLevel < (highestLevel - 1)) {
-            try {
-                Thread.sleep(200);
-            } catch (InterruptedException e) { /* ignored */ }
-            compLevel = WB.getMethodCompilationLevel(m);
-        }
-    }
-
     @Override
     public void run() {
         try {
-            setDontInline("internalRun1");
-            setDontInline("internalRun2");
-
-            int callCount = CompilerWhiteBoxTest.THRESHOLD;
-            while (callCount-- > 0) {
-                receivedThreadDeathinInternal2 = false;
-                realRun = false;
-                internalRun1();
-            }
-            checkCompLevel("internalRun1");
-            checkCompLevel("internalRun2");
-
-            receivedThreadDeathinInternal2 = false;
-            realRun = true;
             internalRun1();
         } catch (ThreadDeath td) {
             throw new RuntimeException("Catched ThreadDeath in run() instead of internalRun2() or internalRun1(). receivedThreadDeathinInternal1=" + receivedThreadDeathinInternal1 + "; receivedThreadDeathinInternal2=" + receivedThreadDeathinInternal2);
@@ -108,7 +65,6 @@ public void run() {
     }
 
     public void internalRun1() {
-        long start_time = System.currentTimeMillis();
         try {
             while (!receivedThreadDeathinInternal2) {
               internalRun2();
@@ -123,17 +79,13 @@ public void internalRun2() {
             Integer myLocalCount = 1;
             Integer myLocalCount2 = 1;
 
-            if (realRun && firstEntry) {
+            if (firstEntry) {
                 // Tell main thread we have started.
                 startSyncObj.countDown();
                 firstEntry = false;
             }
 
             while(myLocalCount > 0) {
-                if (!realRun) {
-                    receivedThreadDeathinInternal2 = true;
-                    break;
-                }
                 myLocalCount2 = (myLocalCount % 3) / 2;
                 myLocalCount -= 1;
             }