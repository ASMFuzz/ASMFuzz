@@ -438,7 +438,7 @@ public static interface AsynchronousCompletionTask {
         ForkJoinPool.commonPool() : new ThreadPerTaskExecutor();
 
     /** Fallback if ForkJoinPool.commonPool() cannot support parallelism */
-    static final class ThreadPerTaskExecutor implements Executor {
+    private static final class ThreadPerTaskExecutor implements Executor {
         public void execute(Runnable r) {
             Objects.requireNonNull(r);
             new Thread(r).start();
@@ -2134,6 +2134,38 @@ public T getNow(T valueIfAbsent) {
         return ((r = result) == null) ? valueIfAbsent : (T) reportJoin(r);
     }
 
+    @Override
+    public T resultNow() {
+        Object r = result;
+        if (r != null) {
+            if (r instanceof AltResult alt) {
+                if (alt.ex == null) return null;
+            } else {
+                @SuppressWarnings("unchecked")
+                T t = (T) r;
+                return t;
+            }
+        }
+        throw new IllegalStateException();
+    }
+
+    @Override
+    public Throwable exceptionNow() {
+        Object r = result;
+        Throwable x;
+        if (r instanceof AltResult alt
+                && ((x = alt.ex) != null)
+                && !(x instanceof CancellationException)) {
+            if (x instanceof CompletionException) {
+                Throwable cause = x.getCause();
+                if (cause != null)
+                    x = cause;
+            }
+            return x;
+        }
+        throw new IllegalStateException();
+    }
+
     /**
      * If not already completed, sets the value returned by {@link
      * #get()} and related methods to the given value.
@@ -2509,6 +2541,20 @@ public boolean isCompletedExceptionally() {
         return ((r = result) instanceof AltResult) && r != NIL;
     }
 
+    @Override
+    public State state() {
+        Object r = result;
+        if (r == null)
+            return State.RUNNING;
+        if (r != NIL && r instanceof AltResult alt) {
+            if (alt.ex instanceof CancellationException)
+                return State.CANCELLED;
+            else
+                return State.FAILED;
+        }
+        return State.SUCCESS;
+    }
+
     /**
      * Forcibly sets or resets the value subsequently returned by
      * method {@link #get()} and related methods, whether or not
@@ -2912,6 +2958,10 @@ static final class MinimalStage<T> extends CompletableFuture<T> {
             throw new UnsupportedOperationException(); }
         @Override public T join() {
             throw new UnsupportedOperationException(); }
+        @Override public T resultNow() {
+            throw new UnsupportedOperationException(); }
+        @Override public Throwable exceptionNow() {
+            throw new UnsupportedOperationException(); }
         @Override public boolean complete(T value) {
             throw new UnsupportedOperationException(); }
         @Override public boolean completeExceptionally(Throwable ex) {
@@ -2928,6 +2978,8 @@ static final class MinimalStage<T> extends CompletableFuture<T> {
             throw new UnsupportedOperationException(); }
         @Override public boolean isCompletedExceptionally() {
             throw new UnsupportedOperationException(); }
+        @Override public State state() {
+            throw new UnsupportedOperationException(); }
         @Override public int getNumberOfDependents() {
             throw new UnsupportedOperationException(); }
         @Override public CompletableFuture<T> completeAsync