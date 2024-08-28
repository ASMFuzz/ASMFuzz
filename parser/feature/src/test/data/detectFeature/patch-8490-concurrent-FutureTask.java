@@ -205,6 +205,59 @@ public V get(long timeout, TimeUnit unit)
         return report(s);
     }
 
+    @Override
+    public V resultNow() {
+        switch (state()) {    // Future.State
+            case SUCCESS:
+                @SuppressWarnings("unchecked")
+                V result = (V) outcome;
+                return result;
+            case FAILED:
+                throw new IllegalStateException("Task completed with exception");
+            case CANCELLED:
+                throw new IllegalStateException("Task was cancelled");
+            default:
+                throw new IllegalStateException("Task has not completed");
+        }
+    }
+
+    @Override
+    public Throwable exceptionNow() {
+        switch (state()) {    // Future.State
+            case SUCCESS:
+                throw new IllegalStateException("Task completed with a result");
+            case FAILED:
+                Object x = outcome;
+                return (Throwable) x;
+            case CANCELLED:
+                throw new IllegalStateException("Task was cancelled");
+            default:
+                throw new IllegalStateException("Task has not completed");
+        }
+    }
+
+    @Override
+    public State state() {
+        int s = state;
+        while (s == COMPLETING) {
+            // waiting for transition to NORMAL or EXCEPTIONAL
+            Thread.yield();
+            s = state;
+        }
+        switch (s) {
+            case NORMAL:
+                return State.SUCCESS;
+            case EXCEPTIONAL:
+                return State.FAILED;
+            case CANCELLED:
+            case INTERRUPTING:
+            case INTERRUPTED:
+                return State.CANCELLED;
+            default:
+                return State.RUNNING;
+        }
+    }
+
     /**
      * Protected method invoked when this task transitions to state
      * {@code isDone} (whether normally or via cancellation). The