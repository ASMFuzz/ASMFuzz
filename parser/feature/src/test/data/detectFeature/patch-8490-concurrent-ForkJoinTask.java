@@ -36,13 +36,12 @@
 package java.util.concurrent;
 
 import java.io.Serializable;
-import java.lang.invoke.MethodHandles;
-import java.lang.invoke.VarHandle;
 import java.lang.reflect.Constructor;
 import java.util.Collection;
 import java.util.List;
 import java.util.RandomAccess;
 import java.util.concurrent.locks.LockSupport;
+import jdk.internal.misc.Unsafe;
 
 /**
  * Abstract base class for tasks that run within a {@link ForkJoinPool}.
@@ -218,9 +217,11 @@ public abstract class ForkJoinTask<V> implements Future<V>, Serializable {
      * This is sometimes hard to see because this file orders exported
      * methods in a way that flows well in javadocs.
      *
-     * Revision notes: The use of "Aux" field replaces previous
-     * reliance on a table to hold exceptions and synchronized blocks
-     * and monitors to wait for completion.
+     * Revision notes: This class uses jdk-internal Unsafe for atomics
+     * and special memory modes, rather than VarHandles, to avoid
+     * initialization dependencies in other jdk components that
+     * require early parallelism. It also simplifies handling of
+     * pool-submitted tasks, among other minor improvements.
      */
 
     /**
@@ -238,16 +239,13 @@ static final class Aux {
             this.ex = ex;
         }
         final boolean casNext(Aux c, Aux v) { // used only in cancellation
-            return NEXT.compareAndSet(this, c, v);
+            return U.compareAndSetReference(this, NEXT, c, v);
         }
-        private static final VarHandle NEXT;
+        private static final Unsafe U;
+        private static final long NEXT;
         static {
-            try {
-                NEXT = MethodHandles.lookup()
-                    .findVarHandle(Aux.class, "next", Aux.class);
-            } catch (ReflectiveOperationException e) {
-                throw new ExceptionInInitializerError(e);
-            }
+            U = Unsafe.getUnsafe();
+            NEXT = U.objectFieldOffset(Aux.class, "next");
         }
     }
 
@@ -261,27 +259,41 @@ final boolean casNext(Aux c, Aux v) { // used only in cancellation
      * control bits occupy only (some of) the upper half (16 bits) of
      * status field. The lower bits are used for user-defined tags.
      */
-    private static final int DONE         = 1 << 31; // must be negative
-    private static final int ABNORMAL     = 1 << 16;
-    private static final int THROWN       = 1 << 17;
-    private static final int SMASK        = 0xffff;  // short bits for tags
-    private static final int UNCOMPENSATE = 1 << 16; // helpJoin return sentinel
+    static final int DONE         = 1 << 31; // must be negative
+    static final int ABNORMAL     = 1 << 16;
+    static final int THROWN       = 1 << 17;
+    static final int SMASK        = 0xffff;  // short bits for tags
+    static final int UNCOMPENSATE = 1 << 16; // helpJoin return sentinel
+    static final int POOLSUBMIT   = 1 << 18; // for pool.submit vs fork
+
+    // flags for awaitDone (in addition to above)
+    static final int RAN           = 1;
+    static final int INTERRUPTIBLE = 2;
+    static final int TIMED         = 4;
 
     // Fields
     volatile int status;                // accessed directly by pool and workers
     private transient volatile Aux aux; // either waiters or thrown Exception
 
     // Support for atomic operations
-    private static final VarHandle STATUS;
-    private static final VarHandle AUX;
+    private static final Unsafe U;
+    private static final long STATUS;
+    private static final long AUX;
     private int getAndBitwiseOrStatus(int v) {
-        return (int)STATUS.getAndBitwiseOr(this, v);
+        return U.getAndBitwiseOrInt(this, STATUS, v);
     }
     private boolean casStatus(int c, int v) {
-        return STATUS.compareAndSet(this, c, v);
+        return U.compareAndSetInt(this, STATUS, c, v);
     }
     private boolean casAux(Aux c, Aux v) {
-        return AUX.compareAndSet(this, c, v);
+        return U.compareAndSetReference(this, AUX, c, v);
+    }
+
+    /**
+     * Marks this task as an external pool submission.
+     */
+    final void markPoolSubmission() {
+        getAndBitwiseOrStatus(POOLSUBMIT);
     }
 
     /** Removes and unparks waiters */
@@ -387,105 +399,69 @@ final int doExec() {
      * Helps and/or waits for completion from join, get, or invoke;
      * called from either internal or external threads.
      *
-     * @param pool if nonnull, known submitted pool, else assumes current pool
-     * @param ran true if task known to have been exec'd
-     * @param interruptible true if park interruptibly when external
-     * @param timed true if use timed wait
-     * @param nanos if timed, timeout value
+     * @param how flags for POOLSUBMIT, RAN, INTERRUPTIBLE, TIMED
+     * @param deadline if timed, timeout deadline
      * @return ABNORMAL if interrupted, else status on exit
      */
-    private int awaitDone(ForkJoinPool pool, boolean ran,
-                          boolean interruptible, boolean timed,
-                          long nanos) {
-        ForkJoinPool p; boolean internal; int s; Thread t;
+    private int awaitDone(int how, long deadline) {
+        int s; Thread t; ForkJoinWorkerThread wt; ForkJoinPool p;
         ForkJoinPool.WorkQueue q = null;
+        boolean timed = (how & TIMED) != 0;
+        boolean owned = false, uncompensate = false;
         if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) {
-            ForkJoinWorkerThread wt = (ForkJoinWorkerThread)t;
+            owned = true;
+            q = (wt = (ForkJoinWorkerThread)t).workQueue;
             p = wt.pool;
-            if (pool == null)
-                pool = p;
-            if (internal = (pool == p))
-                q = wt.workQueue;
         }
-        else {
-            internal = false;
-            p = ForkJoinPool.common;
-            if (pool == null)
-                pool = p;
-            if (pool == p && p != null)
-                q = p.externalQueue();
-        }
-        if (interruptible && Thread.interrupted())
-            return ABNORMAL;
-        if ((s = status) < 0)
-            return s;
-        long deadline = 0L;
-        if (timed) {
-            if (nanos <= 0L)
-                return 0;
-            else if ((deadline = nanos + System.nanoTime()) == 0L)
-                deadline = 1L;
+        else if ((p = ForkJoinPool.common) != null && (how & POOLSUBMIT) == 0)
+            q = p.externalQueue();
+        if (q != null && p != null) { // try helping
+            if (this instanceof CountedCompleter)
+                s = p.helpComplete(this, q, owned, timed);
+            else if ((how & RAN) != 0 ||
+                     (s = q.tryRemoveAndExec(this, owned)) >= 0)
+                s = (owned) ? p.helpJoin(this, q, timed) : 0;
+            if (s < 0)
+                return s;
+            if (s == UNCOMPENSATE)
+                uncompensate = true;
         }
-        boolean uncompensate = false;
-        if (q != null && p != null) {  // try helping
-            // help even in timed mode if pool has no parallelism
-            boolean canHelp = !timed || (p.mode & SMASK) == 0;
-            if (canHelp) {
-                if ((this instanceof CountedCompleter) &&
-                    (s = p.helpComplete(this, q, internal)) < 0)
-                    return s;
-                if (!ran && ((!internal && q.externalTryUnpush(this)) ||
-                             q.tryRemove(this, internal)) && (s = doExec()) < 0)
-                    return s;
+        Aux node = null;
+        long ns = 0L;
+        boolean interrupted = false, queued = false;
+        for (;;) {                    // install node and await signal
+            Aux a;
+            if ((s = status) < 0)
+                break;
+            else if (node == null)
+                node = new Aux(Thread.currentThread(), null);
+            else if (!queued) {
+                if (((a = aux) == null || a.ex == null) &&
+                    (queued = casAux(node.next = a, node)))
+                    LockSupport.setCurrentBlocker(this);
             }
-            if (internal) {
-                if ((s = p.helpJoin(this, q, canHelp)) < 0)
-                    return s;
-                if (s == UNCOMPENSATE)
-                    uncompensate = true;
+            else if (timed && (ns = deadline - System.nanoTime()) <= 0) {
+                s = 0;
+                break;
             }
-        }
-        // block until done or cancelled wait
-        boolean interrupted = false, queued = false;
-        boolean parked = false, fail = false;
-        Aux node = null;
-        while ((s = status) >= 0) {
-            Aux a; long ns;
-            if (fail || (fail = (pool != null && pool.mode < 0)))
-                casStatus(s, s | (DONE | ABNORMAL)); // try to cancel
-            else if (parked && Thread.interrupted()) {
-                if (interruptible) {
+            else if (Thread.interrupted()) {
+                interrupted = true;
+                if ((how & POOLSUBMIT) != 0 && p != null && p.runState < 0)
+                    cancelIgnoringExceptions(this); // cancel on shutdown
+                else if ((how & INTERRUPTIBLE) != 0) {
                     s = ABNORMAL;
                     break;
                 }
-                interrupted = true;
-            }
-            else if (queued) {
-                if (deadline != 0L) {
-                    if ((ns = deadline - System.nanoTime()) <= 0L)
-                        break;
-                    LockSupport.parkNanos(ns);
-                }
-                else
-                    LockSupport.park();
-                parked = true;
-            }
-            else if (node != null) {
-                if ((a = aux) != null && a.ex != null)
-                    Thread.onSpinWait();     // exception in progress
-                else if (queued = casAux(node.next = a, node))
-                    LockSupport.setCurrentBlocker(this);
-            }
-            else {
-                try {
-                    node = new Aux(Thread.currentThread(), null);
-                } catch (Throwable ex) {     // cannot create
-                    fail = true;
-                }
             }
+            else if ((s = status) < 0) // recheck
+                break;
+            else if (timed)
+                LockSupport.parkNanos(ns);
+            else
+                LockSupport.park();
         }
-        if (pool != null && uncompensate)
-            pool.uncompensate();
+        if (uncompensate)
+            p.uncompensate();
 
         if (queued) {
             LockSupport.setCurrentBlocker(null);
@@ -578,8 +554,7 @@ else if (noArgCtor != null) {
      */
     private Throwable getException(int s) {
         Throwable ex = null;
-        if ((s & ABNORMAL) != 0 &&
-            ((s & THROWN) == 0 || (ex = getThrowableException()) == null))
+        if ((s & ABNORMAL) != 0 && (ex = getThrowableException()) == null)
             ex = new CancellationException();
         return ex;
     }
@@ -589,22 +564,21 @@ private Throwable getException(int s) {
      * CancellationException if none recorded.
      */
     private void reportException(int s) {
-        ForkJoinTask.<RuntimeException>uncheckedThrow(
-            (s & THROWN) != 0 ? getThrowableException() : null);
+        ForkJoinTask.<RuntimeException>uncheckedThrow(getThrowableException());
     }
 
     /**
      * Throws exception for (timed or untimed) get, wrapping if
      * necessary in an ExecutionException.
      */
     private void reportExecutionException(int s) {
-        Throwable ex = null;
+        Throwable ex = null, rx;
         if (s == ABNORMAL)
             ex = new InterruptedException();
         else if (s >= 0)
             ex = new TimeoutException();
-        else if ((s & THROWN) != 0 && (ex = getThrowableException()) != null)
-            ex = new ExecutionException(ex);
+        else if ((rx = getThrowableException()) != null)
+            ex = new ExecutionException(rx);
         ForkJoinTask.<RuntimeException>uncheckedThrow(ex);
     }
 
@@ -647,11 +621,16 @@ void uncheckedThrow(Throwable t) throws T {
      * @return {@code this}, to simplify usage
      */
     public final ForkJoinTask<V> fork() {
-        Thread t; ForkJoinWorkerThread w;
-        if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread)
-            (w = (ForkJoinWorkerThread)t).workQueue.push(this, w.pool);
+        Thread t; ForkJoinWorkerThread wt;
+        ForkJoinPool p; ForkJoinPool.WorkQueue q;
+        U.storeStoreFence();  // ensure safely publishable
+        if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) {
+            p = (wt = (ForkJoinWorkerThread)t).pool;
+            q = wt.workQueue;
+        }
         else
-            ForkJoinPool.common.externalPush(this);
+            q = (p = ForkJoinPool.common).submissionQueue(false);
+        q.push(this, p, true);
         return this;
     }
 
@@ -669,7 +648,7 @@ public final ForkJoinTask<V> fork() {
     public final V join() {
         int s;
         if ((s = status) >= 0)
-            s = awaitDone(null, false, false, false, 0L);
+            s = awaitDone(s & POOLSUBMIT, 0L);
         if ((s & ABNORMAL) != 0)
             reportException(s);
         return getRawResult();
@@ -686,7 +665,7 @@ public final V join() {
     public final V invoke() {
         int s;
         if ((s = doExec()) >= 0)
-            s = awaitDone(null, true, false, false, 0L);
+            s = awaitDone(RAN, 0L);
         if ((s & ABNORMAL) != 0)
             reportException(s);
         return getRawResult();
@@ -715,13 +694,17 @@ public static void invokeAll(ForkJoinTask<?> t1, ForkJoinTask<?> t2) {
             throw new NullPointerException();
         t2.fork();
         if ((s1 = t1.doExec()) >= 0)
-            s1 = t1.awaitDone(null, true, false, false, 0L);
+            s1 = t1.awaitDone(RAN, 0L);
         if ((s1 & ABNORMAL) != 0) {
             cancelIgnoringExceptions(t2);
             t1.reportException(s1);
         }
-        else if (((s2 = t2.awaitDone(null, false, false, false, 0L)) & ABNORMAL) != 0)
-            t2.reportException(s2);
+        else {
+            if ((s2 = t2.status) >= 0)
+                s2 = t2.awaitDone(0, 0L);
+            if ((s2 & ABNORMAL) != 0)
+                t2.reportException(s2);
+        }
     }
 
     /**
@@ -751,7 +734,7 @@ public static void invokeAll(ForkJoinTask<?>... tasks) {
             if (i == 0) {
                 int s;
                 if ((s = t.doExec()) >= 0)
-                    s = t.awaitDone(null, true, false, false, 0L);
+                    s = t.awaitDone(RAN, 0L);
                 if ((s & ABNORMAL) != 0)
                     ex = t.getException(s);
                 break;
@@ -764,7 +747,7 @@ public static void invokeAll(ForkJoinTask<?>... tasks) {
                 if ((t = tasks[i]) != null) {
                     int s;
                     if ((s = t.status) >= 0)
-                        s = t.awaitDone(null, false, false, false, 0L);
+                        s = t.awaitDone(0, 0L);
                     if ((s & ABNORMAL) != 0 && (ex = t.getException(s)) != null)
                         break;
                 }
@@ -814,7 +797,7 @@ public static <T extends ForkJoinTask<?>> Collection<T> invokeAll(Collection<T>
             if (i == 0) {
                 int s;
                 if ((s = t.doExec()) >= 0)
-                    s = t.awaitDone(null, true, false, false, 0L);
+                    s = t.awaitDone(RAN, 0L);
                 if ((s & ABNORMAL) != 0)
                     ex = t.getException(s);
                 break;
@@ -827,7 +810,7 @@ public static <T extends ForkJoinTask<?>> Collection<T> invokeAll(Collection<T>
                 if ((t = ts.get(i)) != null) {
                     int s;
                     if ((s = t.status) >= 0)
-                        s = t.awaitDone(null, false, false, false, 0L);
+                        s = t.awaitDone(0, 0L);
                     if ((s & ABNORMAL) != 0 && (ex = t.getException(s)) != null)
                         break;
                 }
@@ -900,6 +883,29 @@ public final boolean isCompletedNormally() {
         return (status & (DONE | ABNORMAL)) == DONE;
     }
 
+    @Override
+    public State state() {
+        int s = status;
+        return (s >= 0) ? State.RUNNING :
+            ((s & (DONE | ABNORMAL)) == DONE) ? State.SUCCESS:
+            ((s & (ABNORMAL | THROWN)) == (ABNORMAL | THROWN)) ? State.FAILED :
+            State.CANCELLED;
+    }
+
+    @Override
+    public V resultNow() {
+        if (!isCompletedNormally())
+            throw new IllegalStateException();
+        return getRawResult();
+    }
+
+    @Override
+    public Throwable exceptionNow() {
+        if ((status & (ABNORMAL | THROWN)) != (ABNORMAL | THROWN))
+            throw new IllegalStateException();
+        return getThrowableException();
+    }
+
     /**
      * Returns the exception thrown by the base computation, or a
      * {@code CancellationException} if cancelled, or {@code null} if
@@ -978,7 +984,11 @@ public final void quietlyComplete() {
      * member of a ForkJoinPool and was interrupted while waiting
      */
     public final V get() throws InterruptedException, ExecutionException {
-        int s = awaitDone(null, false, true, false, 0L);
+        int s;
+        if (Thread.interrupted())
+            s = ABNORMAL;
+        else if ((s = status) >= 0)
+            s = awaitDone((s & POOLSUBMIT) | INTERRUPTIBLE, 0L);
         if ((s & ABNORMAL) != 0)
             reportExecutionException(s);
         return getRawResult();
@@ -1001,7 +1011,12 @@ public final V get() throws InterruptedException, ExecutionException {
     public final V get(long timeout, TimeUnit unit)
         throws InterruptedException, ExecutionException, TimeoutException {
         long nanos = unit.toNanos(timeout);
-        int s = awaitDone(null, false, true, true, nanos);
+        int s;
+        if (Thread.interrupted())
+            s = ABNORMAL;
+        else if ((s = status) >= 0 && nanos > 0L)
+            s = awaitDone((s & POOLSUBMIT) | INTERRUPTIBLE | TIMED,
+                          nanos + System.nanoTime());
         if (s >= 0 || (s & ABNORMAL) != 0)
             reportExecutionException(s);
         return getRawResult();
@@ -1014,49 +1029,65 @@ public final V get(long timeout, TimeUnit unit)
      * known to have aborted.
      */
     public final void quietlyJoin() {
-        if (status >= 0)
-            awaitDone(null, false, false, false, 0L);
+        int s;
+        if ((s = status) >= 0)
+            awaitDone(s & POOLSUBMIT, 0L);
     }
 
-
     /**
      * Commences performing this task and awaits its completion if
      * necessary, without returning its result or throwing its
      * exception.
      */
     public final void quietlyInvoke() {
-        if (doExec() >= 0)
-            awaitDone(null, true, false, false, 0L);
+        int s;
+        if ((s = doExec()) >= 0)
+            awaitDone(RAN, 0L);
     }
 
-    // Versions of join/get for pool.invoke* methods that use external,
-    // possibly-non-commonPool submits
-
-    final void awaitPoolInvoke(ForkJoinPool pool) {
-        awaitDone(pool, false, false, false, 0L);
-    }
-    final void awaitPoolInvoke(ForkJoinPool pool, long nanos) {
-        awaitDone(pool, false, true, true, nanos);
-    }
-    final V joinForPoolInvoke(ForkJoinPool pool) {
-        int s = awaitDone(pool, false, false, false, 0L);
-        if ((s & ABNORMAL) != 0)
-            reportException(s);
-        return getRawResult();
-    }
-    final V getForPoolInvoke(ForkJoinPool pool)
-        throws InterruptedException, ExecutionException {
-        int s = awaitDone(pool, false, true, false, 0L);
-        if ((s & ABNORMAL) != 0)
-            reportExecutionException(s);
-        return getRawResult();
+    /**
+     * Tries to join this task, returning true if it completed
+     * (possibly exceptionally) before the given timeout and
+     * the current thread has not been interrupted.
+     *
+     * @param timeout the maximum time to wait
+     * @param unit the time unit of the timeout argument
+     * @return true if this task completed
+     * @throws InterruptedException if the current thread was
+     * interrupted while waiting
+     * @since 19
+     */
+    public final boolean quietlyJoin(long timeout, TimeUnit unit)
+        throws InterruptedException {
+        int s;
+        long nanos = unit.toNanos(timeout);
+        if (Thread.interrupted())
+            s = ABNORMAL;
+        else if ((s = status) >= 0 && nanos > 0L)
+            s = awaitDone((s & POOLSUBMIT) | INTERRUPTIBLE | TIMED,
+                          nanos + System.nanoTime());
+        if (s == ABNORMAL)
+            throw new InterruptedException();
+        else
+            return (s < 0);
     }
-    final V getForPoolInvoke(ForkJoinPool pool, long nanos)
-        throws InterruptedException, ExecutionException, TimeoutException {
-        int s = awaitDone(pool, false, true, true, nanos);
-        if (s >= 0 || (s & ABNORMAL) != 0)
-            reportExecutionException(s);
-        return getRawResult();
+
+    /**
+     * Tries to join this task, returning true if it completed
+     * (possibly exceptionally) before the given timeout.
+     *
+     * @param timeout the maximum time to wait
+     * @param unit the time unit of the timeout argument
+     * @return true if this task completed
+     * @since 19
+     */
+    public final boolean quietlyJoinUninterruptibly(long timeout,
+                                                    TimeUnit unit) {
+        int s;
+        long nanos = unit.toNanos(timeout);
+        if ((s = status) >= 0 && nanos > 0L)
+            s = awaitDone((s & POOLSUBMIT) | TIMED, nanos + System.nanoTime());
+        return (s < 0);
     }
 
     /**
@@ -1067,12 +1098,7 @@ final V getForPoolInvoke(ForkJoinPool pool, long nanos)
      * all are processed.
      */
     public static void helpQuiesce() {
-        Thread t; ForkJoinWorkerThread w; ForkJoinPool p;
-        if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread &&
-            (p = (w = (ForkJoinWorkerThread)t).pool) != null)
-            p.helpQuiescePool(w.workQueue, Long.MAX_VALUE, false);
-        else
-            ForkJoinPool.common.externalHelpQuiescePool(Long.MAX_VALUE, false);
+        ForkJoinPool.helpQuiescePool(null, Long.MAX_VALUE, false);
     }
 
     /**
@@ -1134,12 +1160,12 @@ public static boolean inForkJoinPool() {
      * @return {@code true} if unforked
      */
     public boolean tryUnfork() {
-        Thread t; ForkJoinPool.WorkQueue q;
-        return ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread)
-            ? (q = ((ForkJoinWorkerThread)t).workQueue) != null
-               && q.tryUnpush(this)
-            : (q = ForkJoinPool.commonQueue()) != null
-               && q.externalTryUnpush(this);
+        Thread t; ForkJoinPool.WorkQueue q; boolean owned;
+        if (owned = (t = Thread.currentThread()) instanceof ForkJoinWorkerThread)
+            q = ((ForkJoinWorkerThread)t).workQueue;
+        else
+            q = ForkJoinPool.commonQueue();
+        return (q != null && q.tryUnpush(this, owned));
     }
 
     /**
@@ -1541,11 +1567,10 @@ public static <T> ForkJoinTask<T> adapt(Callable<? extends T> callable) {
      * @param <T> the type of the callable's result
      * @return the task
      *
-     * @since 17
+     * @since 19
      */
-    // adaptInterruptible deferred to its own independent change
-    // https://bugs.openjdk.java.net/browse/JDK-8246587
-    /* TODO: public */ private static <T> ForkJoinTask<T> adaptInterruptible(Callable<? extends T> callable) {
+    public static <T> ForkJoinTask<T> adaptInterruptible(Callable<? extends T> callable) {
+        // https://bugs.openjdk.java.net/browse/JDK-8246587
         return new AdaptedInterruptibleCallable<T>(callable);
     }
 
@@ -1584,13 +1609,11 @@ private void readObject(java.io.ObjectInputStream s)
     }
 
     static {
-        try {
-            MethodHandles.Lookup l = MethodHandles.lookup();
-            STATUS = l.findVarHandle(ForkJoinTask.class, "status", int.class);
-            AUX = l.findVarHandle(ForkJoinTask.class, "aux", Aux.class);
-        } catch (ReflectiveOperationException e) {
-            throw new ExceptionInInitializerError(e);
-        }
+        U = Unsafe.getUnsafe();
+        STATUS = U.objectFieldOffset(ForkJoinTask.class, "status");
+        AUX = U.objectFieldOffset(ForkJoinTask.class, "aux");
+        Class<?> dep1 = LockSupport.class; // ensure loaded
+        Class<?> dep2 = Aux.class;
     }
 
 }