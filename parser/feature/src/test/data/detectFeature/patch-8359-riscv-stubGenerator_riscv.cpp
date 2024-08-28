@@ -3731,7 +3731,9 @@ class StubGenerator: public StubCodeGenerator {
 
   void generate_all() {
     // support for verify_oop (must happen after universe_init)
-    StubRoutines::_verify_oop_subroutine_entry     = generate_verify_oop();
+    if (VerifyOops) {
+      StubRoutines::_verify_oop_subroutine_entry   = generate_verify_oop();
+    }
     StubRoutines::_throw_AbstractMethodError_entry =
       generate_throw_exception("AbstractMethodError throw_exception",
                                CAST_FROM_FN_PTR(address,