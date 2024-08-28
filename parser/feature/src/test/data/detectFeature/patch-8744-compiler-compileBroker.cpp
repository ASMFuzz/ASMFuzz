@@ -2312,8 +2312,9 @@ void CompileBroker::invoke_compiler_on_method(CompileTask* task) {
       /* Repeat compilation without installing code for profiling purposes */
       int repeat_compilation_count = directive->RepeatCompilationOption;
       while (repeat_compilation_count > 0) {
+        ResourceMark rm(thread);
         task->print_ul("NO CODE INSTALLED");
-        comp->compile_method(&ci_env, target, osr_bci, false , directive);
+        comp->compile_method(&ci_env, target, osr_bci, false, directive);
         repeat_compilation_count--;
       }
     }