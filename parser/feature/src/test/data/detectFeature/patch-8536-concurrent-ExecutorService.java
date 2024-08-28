@@ -102,9 +102,20 @@
  *   }
  * }}</pre>
  *
- * The following method shuts down an {@code ExecutorService} in two phases,
- * first by calling {@code shutdown} to reject incoming tasks, and then
- * calling {@code shutdownNow}, if necessary, to cancel any lingering tasks:
+ * An {@code ExecutorService} may also be established and closed
+ * (shutdown, blocking until terminated) as follows; illustrating with
+ * a different {@code Executors} factory method:
+ *
+ * <pre> {@code
+ * try (ExecutorService e =  Executors.newWorkStealingPool()) {
+ *   // submit or execute many tasks with e ...
+ * }}</pre>
+ *
+ * Further customization is also possible. For example, the following
+ * method shuts down an {@code ExecutorService} in two phases, first
+ * by calling {@code shutdown} to reject incoming tasks, and then
+ * calling {@code shutdownNow}, if necessary, to cancel any lingering
+ * tasks:
  *
  * <pre> {@code
  * void shutdownAndAwaitTermination(ExecutorService pool) {
@@ -135,7 +146,7 @@
  * @since 1.5
  * @author Doug Lea
  */
-public interface ExecutorService extends Executor {
+public interface ExecutorService extends Executor, AutoCloseable {
 
     /**
      * Initiates an orderly shutdown in which previously submitted
@@ -368,4 +379,52 @@ <T> T invokeAny(Collection<? extends Callable<T>> tasks)
     <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                     long timeout, TimeUnit unit)
         throws InterruptedException, ExecutionException, TimeoutException;
+
+    /**
+     * Initiates an orderly shutdown in which previously submitted tasks are
+     * executed, but no new tasks will be accepted. This method waits until all
+     * tasks have completed execution and the executor has terminated.
+     *
+     * <p> If interrupted while waiting, this method stops all executing tasks as
+     * if by invoking {@link #shutdownNow()}. It then continues to wait until all
+     * actively executing tasks have completed. Tasks that were awaiting
+     * execution are not executed. The interrupt status will be re-asserted
+     * before this method returns.
+     *
+     * <p> If already terminated, invoking this method has no effect.
+     *
+     * @implSpec
+     * The default implementation invokes {@code shutdown()} and waits for tasks
+     * to complete execution with {@code awaitTermination}.
+     *
+     * @throws SecurityException if a security manager exists and
+     *         shutting down this ExecutorService may manipulate
+     *         threads that the caller is not permitted to modify
+     *         because it does not hold {@link
+     *         java.lang.RuntimePermission}{@code ("modifyThread")},
+     *         or the security manager's {@code checkAccess} method
+     *         denies access.
+     * @since 19
+     */
+    @Override
+    default void close() {
+        boolean terminated = isTerminated();
+        if (!terminated) {
+            shutdown();
+            boolean interrupted = false;
+            while (!terminated) {
+                try {
+                    terminated = awaitTermination(1L, TimeUnit.DAYS);
+                } catch (InterruptedException e) {
+                    if (!interrupted) {
+                        shutdownNow();
+                        interrupted = true;
+                    }
+                }
+            }
+            if (interrupted) {
+                Thread.currentThread().interrupt();
+            }
+        }
+    }
 }