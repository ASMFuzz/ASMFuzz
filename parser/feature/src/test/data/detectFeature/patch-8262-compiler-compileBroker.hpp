@@ -108,7 +108,7 @@ class CompileQueue : public CHeapObj<mtCompiler> {
   CompileTask* first()                           { return _first; }
   CompileTask* last()                            { return _last;  }
 
-  CompileTask* get();
+  CompileTask* get(CompilerThread* thread);
 
   bool         is_empty() const                  { return _first == NULL; }
   int          size()     const                  { return _size;          }