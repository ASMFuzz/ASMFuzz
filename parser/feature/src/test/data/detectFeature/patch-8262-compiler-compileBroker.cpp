@@ -422,7 +422,7 @@ void CompileQueue::free_all() {
 /**
  * Get the next CompileTask from a CompileQueue
  */
-CompileTask* CompileQueue::get() {
+CompileTask* CompileQueue::get(CompilerThread* thread) {
   // save methods from RedefineClasses across safepoint
   // across MethodCompileQueue_lock below.
   methodHandle save_method;
@@ -440,6 +440,10 @@ CompileTask* CompileQueue::get() {
       return NULL;
     }
 
+    AbstractCompiler* compiler = thread->compiler();
+    guarantee(compiler != nullptr, "Compiler object must exist");
+    compiler->on_empty_queue(this, thread);
+
     // If there are no compilation tasks and we can compile new jobs
     // (i.e., there is enough free space in the code cache) there is
     // no need to invoke the sweeper. As a result, the hotness of methods
@@ -1932,7 +1936,7 @@ void CompileBroker::compiler_thread_loop() {
     // We need this HandleMark to avoid leaking VM handles.
     HandleMark hm(thread);
 
-    CompileTask* task = queue->get();
+    CompileTask* task = queue->get(thread);
     if (task == NULL) {
       if (UseDynamicNumberOfCompilerThreads) {
         // Access compiler_count under lock to enforce consistency.
@@ -1942,6 +1946,10 @@ void CompileBroker::compiler_thread_loop() {
             tty->print_cr("Removing compiler thread %s after " JLONG_FORMAT " ms idle time",
                           thread->name(), thread->idle_time_millis());
           }
+
+          // Notify compiler that the compiler thread is about to stop
+          thread->compiler()->stopping_compiler_thread(thread);
+
           // Free buffer blob, if allocated
           if (thread->get_buffer_blob() != NULL) {
             MutexLocker mu(CodeCache_lock, Mutex::_no_safepoint_check_flag);
@@ -2250,6 +2258,9 @@ void CompileBroker::invoke_compiler_on_method(CompileTask* task) {
       post_compilation_event(event, task);
     }
 
+    if (runtime != nullptr) {
+      runtime->post_compile(thread);
+    }
   } else
 #endif // INCLUDE_JVMCI
   {