@@ -161,4 +161,143 @@ public interface Future<V> {
      */
     V get(long timeout, TimeUnit unit)
         throws InterruptedException, ExecutionException, TimeoutException;
+
+    /**
+     * Returns the computed result, without waiting.
+     *
+     * <p> This method is for cases where the caller knows that the task has
+     * already completed successfully, for example when filtering a stream
+     * of Future objects for the successful tasks and using a mapping
+     * operation to obtain a stream of results.
+     * {@snippet lang=java :
+     *     results = futures.stream()
+     *                .filter(f -> f.state() == Future.State.SUCCESS)
+     *                .map(Future::resultNow)
+     *                .toList();
+     * }
+     *
+     * @implSpec
+     * The default implementation invokes {@code isDone()} to test if the task
+     * has completed. If done, it invokes {@code get()} to obtain the result.
+     *
+     * @return the computed result
+     * @throws IllegalStateException if the task has not completed or the task
+     * did not complete with a result
+     * @since 19
+     */
+    default V resultNow() {
+        if (!isDone())
+            throw new IllegalStateException("Task has not completed");
+        boolean interrupted = false;
+        try {
+            while (true) {
+                try {
+                    return get();
+                } catch (InterruptedException e) {
+                    interrupted = true;
+                } catch (ExecutionException e) {
+                    throw new IllegalStateException("Task completed with exception");
+                } catch (CancellationException e) {
+                    throw new IllegalStateException("Task was cancelled");
+                }
+            }
+        } finally {
+            if (interrupted) Thread.currentThread().interrupt();
+        }
+    }
+
+    /**
+     * Returns the exception thrown by the task, without waiting.
+     *
+     * <p> This method is for cases where the caller knows that the task
+     * has already completed with an exception.
+     *
+     * @implSpec
+     * The default implementation invokes {@code isDone()} to test if the task
+     * has completed. If done and not cancelled, it invokes {@code get()} and
+     * catches the {@code ExecutionException} to obtain the exception.
+     *
+     * @return the exception thrown by the task
+     * @throws IllegalStateException if the task has not completed, the task
+     * completed normally, or the task was cancelled
+     * @since 19
+     */
+    default Throwable exceptionNow() {
+        if (!isDone())
+            throw new IllegalStateException("Task has not completed");
+        if (isCancelled())
+            throw new IllegalStateException("Task was cancelled");
+        boolean interrupted = false;
+        try {
+            while (true) {
+                try {
+                    get();
+                    throw new IllegalStateException("Task completed with a result");
+                } catch (InterruptedException e) {
+                    interrupted = true;
+                } catch (ExecutionException e) {
+                    return e.getCause();
+                }
+            }
+        } finally {
+            if (interrupted) Thread.currentThread().interrupt();
+        }
+    }
+
+    /**
+     * Represents the computation state.
+     * @since 19
+     */
+    enum State {
+        /**
+         * The task has not completed.
+         */
+        RUNNING,
+        /**
+         * The task completed with a result.
+         * @see Future#resultNow()
+         */
+        SUCCESS,
+        /**
+         * The task completed with an exception.
+         * @see Future#exceptionNow()
+         */
+        FAILED,
+        /**
+         * The task was cancelled.
+         * @see #cancel(boolean)
+         */
+        CANCELLED
+    }
+
+    /**
+     * {@return the computation state}
+     *
+     * @implSpec
+     * The default implementation uses {@code isDone()}, {@code isCancelled()},
+     * and {@code get()} to determine the state.
+     *
+     * @since 19
+     */
+    default State state() {
+        if (!isDone())
+            return State.RUNNING;
+        if (isCancelled())
+            return State.CANCELLED;
+        boolean interrupted = false;
+        try {
+            while (true) {
+                try {
+                    get();  // may throw InterruptedException when done
+                    return State.SUCCESS;
+                } catch (InterruptedException e) {
+                    interrupted = true;
+                } catch (ExecutionException e) {
+                    return State.FAILED;
+                }
+            }
+        } finally {
+            if (interrupted) Thread.currentThread().interrupt();
+        }
+    }
 }