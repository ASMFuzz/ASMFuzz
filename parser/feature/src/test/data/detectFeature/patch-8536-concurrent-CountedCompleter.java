@@ -35,8 +35,7 @@
 
 package java.util.concurrent;
 
-import java.lang.invoke.MethodHandles;
-import java.lang.invoke.VarHandle;
+import jdk.internal.misc.Unsafe;
 
 /**
  * A {@link ForkJoinTask} with a completion action performed when
@@ -540,7 +539,7 @@ public final void setPendingCount(int count) {
      * @param delta the value to add
      */
     public final void addToPendingCount(int delta) {
-        PENDING.getAndAdd(this, delta);
+        U.getAndAddInt(this, PENDING, delta);
     }
 
     /**
@@ -552,12 +551,12 @@ public final void addToPendingCount(int delta) {
      * @return {@code true} if successful
      */
     public final boolean compareAndSetPendingCount(int expected, int count) {
-        return PENDING.compareAndSet(this, expected, count);
+        return U.compareAndSetInt(this, PENDING, expected, count);
     }
 
     // internal-only weak version
     final boolean weakCompareAndSetPendingCount(int expected, int count) {
-        return PENDING.weakCompareAndSet(this, expected, count);
+        return U.weakCompareAndSetInt(this, PENDING, expected, count);
     }
 
     /**
@@ -733,7 +732,6 @@ public final void helpComplete(int maxTasks) {
         if (q != null && maxTasks > 0)
             q.helpComplete(this, owned, maxTasks);
     }
-
     // ForkJoinTask overrides
 
     /**
@@ -779,15 +777,16 @@ protected final boolean exec() {
     @Override
     protected void setRawResult(T t) { }
 
-    // VarHandle mechanics
-    private static final VarHandle PENDING;
+    /*
+     * This class uses jdk-internal Unsafe for atomics and special
+     * memory modes, rather than VarHandles, to avoid initialization
+     * dependencies in other jdk components that require early
+     * parallelism.
+     */
+    private static final Unsafe U;
+    private static final long PENDING;
     static {
-        try {
-            MethodHandles.Lookup l = MethodHandles.lookup();
-            PENDING = l.findVarHandle(CountedCompleter.class, "pending", int.class);
-
-        } catch (ReflectiveOperationException e) {
-            throw new ExceptionInInitializerError(e);
-        }
+        U = Unsafe.getUnsafe();
+        PENDING = U.objectFieldOffset(CountedCompleter.class, "pending");
     }
 }