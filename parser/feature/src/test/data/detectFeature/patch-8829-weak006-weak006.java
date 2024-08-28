@@ -32,7 +32,7 @@
  *          /test/lib
  * @build jdk.test.whitebox.WhiteBox
  * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
- * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI gc.gctests.WeakReference.weak006.weak006 -t 1
+ * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI -XX:+IgnoreUnrecognizedVMOptions -XX:-ScavengeBeforeFullGC gc.gctests.WeakReference.weak006.weak006 -t 1
  */
 
 package gc.gctests.WeakReference.weak006;
@@ -54,6 +54,20 @@
  * to the next, then provokes GC with WB.fullGC().
  * The test succedes if last reference has been cleared.
  */
+
+class MySoftReference<T> extends SoftReference<T> {
+    public MySoftReference(T obj) {
+        super(obj);
+    }
+}
+
+
+class MyWeakReference<T> extends WeakReference<T> {
+    public MyWeakReference(T obj) {
+        super(obj);
+    }
+}
+
 public class weak006 extends ThreadedGCTest {
 
     class Worker implements Runnable {
@@ -63,40 +77,14 @@ class Worker implements Runnable {
         private Object[] references;
         private Reference lastReference;
 
-        private Object makeReference(int n, Object o) {
+        private Reference<Object> makeReference(int n, Object o) {
             switch (n) {
                 case 0:
-                    return new WeakReference(o);
+                    return new MyWeakReference(o);
                 case 1:
-                    return new SoftReference(o);
-                case 2:
-                    return new PhantomReference(o, null);
-                case 4: {
-                    // Array of strong references
-                    int len = Memory.getArrayLength(objectSize, Memory.getReferenceSize());
-                    Object[] arr = new Object[len];
-                    for (int i = 0; i < len; ++i) {
-                        arr[i] = o;
-                    }
-                    return arr;
-                }
-                case 5: {
-                    // reference to array of strong references and strong reference to reference
-                    int len = Memory.getArrayLength(objectSize, Memory.getReferenceSize());
-                    Object[] arr = new Object[len];
-                    for (int i = 1; i < len; ++i) {
-                        arr[i] = o;
-                    }
-                    Reference ref = (Reference) makeReference(LocalRandom.nextInt(3), arr);
-                    if (len > 0) {
-                        arr[0] = ref;
-                    }
-                    return ref;
-                }
-                case 3:
+                    return new MySoftReference(o);
                 default:
-                    // Strong reference
-                    return o;
+                    throw new RuntimeException("Incorrect reference type");
             }
         }
 
@@ -108,12 +96,12 @@ private void clear() {
         private void makeReferences(int n) {
             clear();
             MemoryObject obj = new MemoryObject(objectSize);
-            references[0] = new WeakReference(obj);
+            references[0] = new MyWeakReference(obj);
             for (int i = 1; i < length; ++i) {
                 if (i != length - 1) {
                     references[i] = makeReference(LocalRandom.nextInt(2), references[i - 1]);
                 } else {
-                    lastReference = (Reference) makeReference(n, references[i - 1]);
+                    lastReference = makeReference(n, references[i - 1]);
                     references[i] = lastReference;
                 }
             }