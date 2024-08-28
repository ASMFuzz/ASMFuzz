@@ -80,6 +80,7 @@ struct CodeBlobType {
 
 class CodeBlobLayout;
 class OptimizedEntryBlob; // for as_optimized_entry_blob()
+class RuntimeStub; // for as_runtime_stub()
 class JavaFrameAnchor; // for OptimizedEntryBlob::jfa_for_frame
 
 class CodeBlob {
@@ -164,12 +165,13 @@ class CodeBlob {
   CompilerType compiler_type() const { return _type; }
 
   // Casting
-  nmethod* as_nmethod_or_null()                { return is_nmethod() ? (nmethod*) this : NULL; }
-  nmethod* as_nmethod()                        { assert(is_nmethod(), "must be nmethod"); return (nmethod*) this; }
-  CompiledMethod* as_compiled_method_or_null() { return is_compiled() ? (CompiledMethod*) this : NULL; }
-  CompiledMethod* as_compiled_method()         { assert(is_compiled(), "must be compiled"); return (CompiledMethod*) this; }
-  CodeBlob* as_codeblob_or_null() const        { return (CodeBlob*) this; }
-  OptimizedEntryBlob* as_optimized_entry_blob() const             { assert(is_optimized_entry_blob(), "must be entry blob"); return (OptimizedEntryBlob*) this; }
+  nmethod* as_nmethod_or_null()                       { return is_nmethod() ? (nmethod*) this : NULL; }
+  nmethod* as_nmethod()                               { assert(is_nmethod(), "must be nmethod"); return (nmethod*) this; }
+  CompiledMethod* as_compiled_method_or_null()        { return is_compiled() ? (CompiledMethod*) this : NULL; }
+  CompiledMethod* as_compiled_method()                { assert(is_compiled(), "must be compiled"); return (CompiledMethod*) this; }
+  CodeBlob* as_codeblob_or_null() const               { return (CodeBlob*) this; }
+  OptimizedEntryBlob* as_optimized_entry_blob() const { assert(is_optimized_entry_blob(), "must be entry blob"); return (OptimizedEntryBlob*) this; }
+  RuntimeStub* as_runtime_stub() const                { assert(is_runtime_stub(), "must be runtime blob"); return (RuntimeStub*) this; }
 
   // Boundaries
   address header_begin() const        { return (address) this; }
@@ -521,6 +523,8 @@ class RuntimeStub: public RuntimeBlob {
     bool        caller_must_gc_arguments
   );
 
+  static void free(RuntimeStub* stub) { RuntimeBlob::free(stub); }
+
   // Typing
   bool is_runtime_stub() const                   { return true; }
 