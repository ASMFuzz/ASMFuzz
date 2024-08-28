@@ -4507,12 +4507,6 @@ class StubGenerator: public StubCodeGenerator {
     return nullptr;
   }
 
-  address generate_cont_thaw(bool return_barrier, bool exception) {
-    if (!Continuations::enabled()) return nullptr;
-    Unimplemented();
-    return nullptr;
-  }
-
   address generate_cont_thaw() {
     if (!Continuations::enabled()) return nullptr;
     Unimplemented();