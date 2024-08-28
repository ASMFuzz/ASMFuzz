@@ -94,6 +94,10 @@ class JVMCICompiler : public AbstractCompiler {
   // Compilation entry point for methods
   virtual void compile_method(ciEnv* env, ciMethod* target, int entry_bci, bool install_code, DirectiveSet* directive);
 
+  virtual void stopping_compiler_thread(CompilerThread* current);
+
+  virtual void on_empty_queue(CompileQueue* queue, CompilerThread* thread);
+
   // Print compilation timers and statistics
   virtual void print_timers();
 