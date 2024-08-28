@@ -36,7 +36,9 @@
 package java.util.concurrent;
 
 import java.security.AccessController;
+import java.security.AccessControlContext;
 import java.security.PrivilegedAction;
+import java.security.ProtectionDomain;
 
 /**
  * A thread managed by a {@link ForkJoinPool}, which executes
@@ -70,10 +72,13 @@ public class ForkJoinWorkerThread extends Thread {
      * Full nonpublic constructor.
      */
     ForkJoinWorkerThread(ThreadGroup group, ForkJoinPool pool,
-                         boolean useSystemClassLoader, boolean isInnocuous) {
-        super(group, null, pool.nextWorkerThreadName(), 0L);
+                         boolean useSystemClassLoader,
+                         boolean clearThreadLocals) {
+        super(group, null, pool.nextWorkerThreadName(), 0L, !clearThreadLocals);
         UncaughtExceptionHandler handler = (this.pool = pool).ueh;
-        this.workQueue = new ForkJoinPool.WorkQueue(this, isInnocuous);
+        this.workQueue = new ForkJoinPool.WorkQueue(this, 0);
+        if (clearThreadLocals)
+            workQueue.setClearThreadLocals();
         super.setDaemon(true);
         if (handler != null)
             super.setUncaughtExceptionHandler(handler);
@@ -83,14 +88,21 @@ public class ForkJoinWorkerThread extends Thread {
 
     /**
      * Creates a ForkJoinWorkerThread operating in the given thread group and
-     * pool.
+     * pool, and with the given policy for preserving ThreadLocals.
      *
-     * @param group if non-null, the thread group for this thread
+     * @param group if non-null, the thread group for this
+     * thread. Otherwise, the thread group is chosen by the security
+     * manager if present, else set to the current thread's thread
+     * group.
      * @param pool the pool this thread works in
+     * @param preserveThreadLocals if true, always preserve the values of
+     * ThreadLocal variables across tasks; otherwise they may be cleared.
      * @throws NullPointerException if pool is null
+     * @since 19
      */
-    /* TODO: protected */ ForkJoinWorkerThread(ThreadGroup group, ForkJoinPool pool) {
-        this(group, pool, false, false);
+    protected ForkJoinWorkerThread(ThreadGroup group, ForkJoinPool pool,
+                                   boolean preserveThreadLocals) {
+        this(group, pool, false, !preserveThreadLocals);
     }
 
     /**
@@ -181,26 +193,24 @@ public void run() {
     /**
      * A worker thread that has no permissions, is not a member of any
      * user-defined ThreadGroup, uses the system class loader as
-     * thread context class loader, and erases all ThreadLocals after
+     * thread context class loader, and clears all ThreadLocals after
      * running each top-level task.
      */
     static final class InnocuousForkJoinWorkerThread extends ForkJoinWorkerThread {
         /** The ThreadGroup for all InnocuousForkJoinWorkerThreads */
+        private static final ThreadGroup innocuousThreadGroup;
         @SuppressWarnings("removal")
-        private static final ThreadGroup innocuousThreadGroup =
-            AccessController.doPrivileged(new PrivilegedAction<>() {
-                public ThreadGroup run() {
-                    ThreadGroup group = Thread.currentThread().getThreadGroup();
-                    for (ThreadGroup p; (p = group.getParent()) != null; )
-                        group = p;
-                    return new ThreadGroup(
-                        group, "InnocuousForkJoinWorkerThreadGroup");
-                }});
-
+        private static final AccessControlContext innocuousACC;
         InnocuousForkJoinWorkerThread(ForkJoinPool pool) {
             super(innocuousThreadGroup, pool, true, true);
         }
 
+        @Override @SuppressWarnings("removal")
+        protected void onStart() {
+            Thread t = Thread.currentThread();
+            ThreadLocalRandom.setInheritedAccessControlContext(t, innocuousACC);
+        }
+
         @Override // to silently fail
         public void setUncaughtExceptionHandler(UncaughtExceptionHandler x) { }
 
@@ -209,5 +219,33 @@ public void setContextClassLoader(ClassLoader cl) {
             if (cl != null && ClassLoader.getSystemClassLoader() != cl)
                 throw new SecurityException("setContextClassLoader");
         }
+
+        @SuppressWarnings("removal")
+        static AccessControlContext createACC() {
+            return new AccessControlContext(
+                new ProtectionDomain[] { new ProtectionDomain(null, null) });
+        }
+        static ThreadGroup createGroup() {
+            ThreadGroup group = Thread.currentThread().getThreadGroup();
+            for (ThreadGroup p; (p = group.getParent()) != null; )
+                group = p;
+            return new ThreadGroup(group, "InnocuousForkJoinWorkerThreadGroup");
+        }
+        static {
+            @SuppressWarnings("removal")
+            SecurityManager sm = System.getSecurityManager();
+            @SuppressWarnings("removal")
+            ThreadGroup g = innocuousThreadGroup =
+                (sm == null) ? createGroup() :
+                AccessController.doPrivileged(new PrivilegedAction<>() {
+                        public ThreadGroup run() {
+                            return createGroup(); }});
+            @SuppressWarnings("removal")
+            AccessControlContext a = innocuousACC =
+                (sm == null) ? createACC() :
+                AccessController.doPrivileged(new PrivilegedAction<>() {
+                        public AccessControlContext run() {
+                            return createACC(); }});
+        }
     }
 }