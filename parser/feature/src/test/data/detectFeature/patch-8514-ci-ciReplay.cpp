@@ -398,7 +398,12 @@ class CompileReplay : public StackObj {
 
       ik->link_class(CHECK_NULL);
 
-      Bytecode_invoke bytecode(caller, bci);
+      Bytecode_invoke bytecode = Bytecode_invoke_check(caller, bci);
+      if (!Bytecodes::is_defined(bytecode.code()) || !bytecode.is_valid()) {
+        report_error("no invoke found at bci");
+        return NULL;
+      }
+      bytecode.verify();
       int index = bytecode.index();
 
       ConstantPoolCacheEntry* cp_cache_entry = NULL;