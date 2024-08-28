@@ -479,7 +479,29 @@ public MethodType type() {
         this.type = Objects.requireNonNull(type);
         this.form = Objects.requireNonNull(form).uncustomize();
 
-        this.form.prepare();  // TO DO:  Try to delay this step until just before invocation.
+        if (DEFERRED_PREPARE.get() == 0) {
+            this.form.prepare();  // TO DO:  Try to delay this step until just before invocation.
+        }
+    }
+
+    /* package-private */ static void deferPreparation() {
+        DEFERRED_PREPARE.set(DEFERRED_PREPARE.get() + 1);
+    }
+    /* package-private */ static void reEnablePreparation() {
+        assert (DEFERRED_PREPARE.get() > 0);
+        DEFERRED_PREPARE.set(DEFERRED_PREPARE.get() - 1);
+    }
+
+    private static final ThreadLocal<Integer> DEFERRED_PREPARE = new ThreadLocal<>() {
+        @Override
+        protected Integer initialValue() {
+            return 0;
+        }
+    };
+
+    /*non-public*/
+    void prepare() {
+        this.form.prepare();
     }
 
     /**