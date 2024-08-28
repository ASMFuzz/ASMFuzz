@@ -26,17 +26,19 @@
  * @bug 8284490
  * @summary Remove finalizer method in java.security.jgss
  * @key intermittent
+ * @library /test/lib/
+ * @build jdk.test.lib.util.ForceGC
  * @run main/othervm GssNameCleanup
  */
 
-import java.util.WeakHashMap;
+import java.lang.ref.WeakReference;
 import org.ietf.jgss.GSSManager;
 import org.ietf.jgss.GSSName;
 import org.ietf.jgss.GSSException;
 
-public final class GssNameCleanup {
-    private final static WeakHashMap<GSSName, ?> whm = new WeakHashMap<>();
+import jdk.test.lib.util.ForceGC;
 
+public final class GssNameCleanup {
     public static void main(String[] args) throws Exception {
         // Enable debug log so that the failure analysis could be easier.
         System.setProperty("sun.security.nativegss.debug", "true");
@@ -49,25 +51,20 @@ public static void main(String[] args) throws Exception {
         try {
             GSSName name =
                 manager.createName("u1", GSSName.NT_USER_NAME);
-            whm.put(name, null);
+            WeakReference<GSSName> weakRef = new WeakReference<>(name);
             name = null;
+
+            // Check if the object has been collected.
+            ForceGC gc = new ForceGC();
+            if (!gc.await(() -> weakRef.get() == null)) {
+                throw new RuntimeException("GSSName object is not released");
+            }
         } catch (GSSException gsse) {
             // createName() could fail if the local default realm
             // cannot be located.  Just ignore the test case for
             // such circumstances.
             System.out.println("Ignore this test case: " + gsse);
         }
-
-        // Wait to trigger the cleanup.
-        for (int i = 0; i < 10 && whm.size() > 0; i++) {
-            System.gc();
-            Thread.sleep(100);
-        }
-
-        // Check if the object has been collected.
-        if (whm.size() > 0) {
-            throw new RuntimeException("GSSName object is not released");
-        }
     }
 }
 