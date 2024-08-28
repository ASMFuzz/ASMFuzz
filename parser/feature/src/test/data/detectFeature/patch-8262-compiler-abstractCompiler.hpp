@@ -165,6 +165,18 @@ class AbstractCompiler : public CHeapObj<mtCompiler> {
     ShouldNotReachHere();
   }
 
+  // Notifies this compiler that the current thread (`current`) is about to stop.
+  // The current thread currently holds the CompileThread_lock.
+  virtual void stopping_compiler_thread(CompilerThread* current) {
+    // Do nothing
+  }
+
+  // Notifies this compiler that queue is empty just prior to waiting on
+  // MethodCompileQueue_lock which is held by the current thread (`thread`).
+  virtual void on_empty_queue(CompileQueue* queue, CompilerThread* thread) {
+    // Do nothing
+  }
+
   // Print compilation timers and statistics
   virtual void print_timers() {
     ShouldNotReachHere();