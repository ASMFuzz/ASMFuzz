@@ -153,6 +153,36 @@ void JVMCICompiler::compile_method(ciEnv* env, ciMethod* target, int entry_bci,
   ShouldNotReachHere();
 }
 
+void JVMCICompiler::stopping_compiler_thread(CompilerThread* current) {
+  if (UseJVMCINativeLibrary) {
+    JVMCIRuntime* runtime = JVMCI::compiler_runtime(current, false);
+    if (runtime != nullptr) {
+      MutexUnlocker unlock(CompileThread_lock);
+      runtime->detach_thread(current, "stopping idle compiler thread");
+    }
+  }
+}
+
+void JVMCICompiler::on_empty_queue(CompileQueue* queue, CompilerThread* thread) {
+  if (UseJVMCINativeLibrary) {
+    int delay = JVMCICompilerIdleDelay;
+    JVMCIRuntime* runtime = JVMCI::compiler_runtime(thread, false);
+    // Don't detach JVMCI compiler threads from their JVMCI
+    // runtime during the VM startup grace period
+    if (runtime != nullptr && delay > 0 && tty->time_stamp().milliseconds() > DEFAULT_COMPILER_IDLE_DELAY) {
+      bool timeout = MethodCompileQueue_lock->wait(delay);
+      // Unlock as detaching or repacking can result in a JNI call to shutdown a JavaVM
+      // and locks cannot be held when making a VM to native transition.
+      MutexUnlocker unlock(MethodCompileQueue_lock);
+      if (timeout) {
+        runtime->detach_thread(thread, "releasing idle compiler thread");
+      } else {
+        runtime->repack(thread);
+      }
+    }
+  }
+}
+
 // Print CompileBroker compilation timers
 void JVMCICompiler::print_timers() {
   double code_install_time = _codeInstallTimer.seconds();