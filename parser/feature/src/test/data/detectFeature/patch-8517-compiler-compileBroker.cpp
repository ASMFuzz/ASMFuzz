@@ -443,6 +443,11 @@ CompileTask* CompileQueue::get(CompilerThread* thread) {
     AbstractCompiler* compiler = thread->compiler();
     guarantee(compiler != nullptr, "Compiler object must exist");
     compiler->on_empty_queue(this, thread);
+    if (_first != nullptr) {
+      // The call to on_empty_queue may have temporarily unlocked the MCQ lock
+      // so check again whether any tasks were added to the queue.
+      break;
+    }
 
     // If there are no compilation tasks and we can compile new jobs
     // (i.e., there is enough free space in the code cache) there is