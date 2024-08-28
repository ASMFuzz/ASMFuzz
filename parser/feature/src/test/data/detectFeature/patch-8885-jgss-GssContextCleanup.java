@@ -26,18 +26,20 @@
  * @bug 8284490
  * @summary Remove finalizer method in java.security.jgss
  * @key intermittent
+ * @library /test/lib/
+ * @build jdk.test.lib.util.ForceGC
  * @run main/othervm GssContextCleanup
  */
 
 import org.ietf.jgss.GSSContext;
 import org.ietf.jgss.GSSCredential;
 import org.ietf.jgss.GSSManager;
 
-import java.util.WeakHashMap;
+import java.lang.ref.WeakReference;
 
-public final class GssContextCleanup {
-    private final static WeakHashMap<GSSContext, ?> whm = new WeakHashMap<>();
+import jdk.test.lib.util.ForceGC;
 
+public final class GssContextCleanup {
     public static void main(String[] args) throws Exception {
         // Enable debug log so that the failure analysis could be easier.
         System.setProperty("sun.security.nativegss.debug", "true");
@@ -48,17 +50,12 @@ public static void main(String[] args) throws Exception {
         // Create an object
         GSSManager manager = GSSManager.getInstance();
         GSSContext context = manager.createContext((GSSCredential)null);
-        whm.put(context, null);
+        WeakReference<GSSContext> weakRef = new WeakReference<>(context);
         context = null;
 
-        // Wait to trigger the cleanup.
-        for (int i = 0; i < 10 && whm.size() > 0; i++) {
-            System.gc();
-            Thread.sleep(100);
-        }
-
         // Check if the object has been collected.
-        if (whm.size() > 0) {
+        ForceGC gc = new ForceGC();
+        if (!gc.await(() -> weakRef.get() == null)) {
             throw new RuntimeException("GSSContext object is not released");
         }
     }