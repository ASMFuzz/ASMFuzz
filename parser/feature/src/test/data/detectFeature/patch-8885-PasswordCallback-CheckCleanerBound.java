@@ -25,35 +25,32 @@
  * @test
  * @bug 8284910
  * @summary Check that the cleaner is not bound to the PasswordCallback object
+ * @library /test/lib/
+ * @build jdk.test.lib.util.ForceGC
+ * @run main/othervm CheckCleanerBound
  */
 
 import javax.security.auth.callback.PasswordCallback;
-import java.util.WeakHashMap;
+import java.lang.ref.WeakReference;
+import jdk.test.lib.util.ForceGC;
 
 public final class CheckCleanerBound {
-    private final static WeakHashMap<PasswordCallback, ?> weakHashMap =
-            new WeakHashMap<>();
 
     public static void main(String[] args) throws Exception {
         // Create an object
         PasswordCallback passwordCallback =
                 new PasswordCallback("Password: ", false);
         passwordCallback.setPassword("ThisIsAPassword".toCharArray());
 
-        weakHashMap.put(passwordCallback, null);
+        WeakReference<PasswordCallback> weakRef =
+                new WeakReference<>(passwordCallback);
         passwordCallback = null;
 
-        // Check if the PasswordCallback object could be collected.
-        // Wait to trigger the cleanup.
-        for (int i = 0; i < 10 && weakHashMap.size() != 0; i++) {
-            System.gc();
-            Thread.sleep(100);
-        }
-
         // Check if the object has been collected.  The collection will not
         // happen if the cleaner implementation in PasswordCallback is bound
         // to the PasswordCallback object.
-        if (weakHashMap.size() > 0) {
+        ForceGC gc = new ForceGC();
+        if (!gc.await(() -> weakRef.get() == null)) {
             throw new RuntimeException(
                 "PasswordCallback object is not released");
         }