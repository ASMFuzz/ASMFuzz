@@ -1139,6 +1139,15 @@ void VMError::report(outputStream* st, bool _verbose) {
        st->cr();
      }
 
+#ifndef _WIN32
+  STEP("printing locale settings")
+
+     if (_verbose) {
+       os::Posix::print_active_locale(st);
+       st->cr();
+     }
+#endif
+
   STEP("printing signal handlers")
 
      if (_verbose) {
@@ -1320,6 +1329,12 @@ void VMError::print_vm_info(outputStream* st) {
   os::print_environment_variables(st, env_list);
   st->cr();
 
+  // STEP("printing locale settings")
+#ifndef _WIN32
+  os::Posix::print_active_locale(st);
+  st->cr();
+#endif
+
   // STEP("printing signal handlers")
 
   os::print_signal_handlers(st, buf, sizeof(buf));