@@ -1993,3 +1993,69 @@ void os::PageSizes::print_on(outputStream* st) const {
     st->print("empty");
   }
 }
+
+// Check minimum allowable stack sizes for thread creation and to initialize
+// the java system classes, including StackOverflowError - depends on page
+// size.
+// The space needed for frames during startup is platform dependent. It
+// depends on word size, platform calling conventions, C frame layout and
+// interpreter/C1/C2 design decisions. Therefore this is given in a
+// platform (os/cpu) dependent constant.
+// To this, space for guard mechanisms is added, which depends on the
+// page size which again depends on the concrete system the VM is running
+// on. Space for libc guard pages is not included in this size.
+jint os::set_minimum_stack_sizes() {
+
+  _java_thread_min_stack_allowed = _java_thread_min_stack_allowed +
+                                   StackOverflow::stack_guard_zone_size() +
+                                   StackOverflow::stack_shadow_zone_size();
+
+  _java_thread_min_stack_allowed = align_up(_java_thread_min_stack_allowed, vm_page_size());
+  _java_thread_min_stack_allowed = MAX2(_java_thread_min_stack_allowed, _os_min_stack_allowed);
+
+  size_t stack_size_in_bytes = ThreadStackSize * K;
+  if (stack_size_in_bytes != 0 &&
+      stack_size_in_bytes < _java_thread_min_stack_allowed) {
+    // The '-Xss' and '-XX:ThreadStackSize=N' options both set
+    // ThreadStackSize so we go with "Java thread stack size" instead
+    // of "ThreadStackSize" to be more friendly.
+    tty->print_cr("\nThe Java thread stack size specified is too small. "
+                  "Specify at least " SIZE_FORMAT "k",
+                  _java_thread_min_stack_allowed / K);
+    return JNI_ERR;
+  }
+
+  // Make the stack size a multiple of the page size so that
+  // the yellow/red zones can be guarded.
+  JavaThread::set_stack_size_at_create(align_up(stack_size_in_bytes, vm_page_size()));
+
+  // Reminder: a compiler thread is a Java thread.
+  _compiler_thread_min_stack_allowed = _compiler_thread_min_stack_allowed +
+                                       StackOverflow::stack_guard_zone_size() +
+                                       StackOverflow::stack_shadow_zone_size();
+
+  _compiler_thread_min_stack_allowed = align_up(_compiler_thread_min_stack_allowed, vm_page_size());
+  _compiler_thread_min_stack_allowed = MAX2(_compiler_thread_min_stack_allowed, _os_min_stack_allowed);
+
+  stack_size_in_bytes = CompilerThreadStackSize * K;
+  if (stack_size_in_bytes != 0 &&
+      stack_size_in_bytes < _compiler_thread_min_stack_allowed) {
+    tty->print_cr("\nThe CompilerThreadStackSize specified is too small. "
+                  "Specify at least " SIZE_FORMAT "k",
+                  _compiler_thread_min_stack_allowed / K);
+    return JNI_ERR;
+  }
+
+  _vm_internal_thread_min_stack_allowed = align_up(_vm_internal_thread_min_stack_allowed, vm_page_size());
+  _vm_internal_thread_min_stack_allowed = MAX2(_vm_internal_thread_min_stack_allowed, _os_min_stack_allowed);
+
+  stack_size_in_bytes = VMThreadStackSize * K;
+  if (stack_size_in_bytes != 0 &&
+      stack_size_in_bytes < _vm_internal_thread_min_stack_allowed) {
+    tty->print_cr("\nThe VMThreadStackSize specified is too small. "
+                  "Specify at least " SIZE_FORMAT "k",
+                  _vm_internal_thread_min_stack_allowed / K);
+    return JNI_ERR;
+  }
+  return JNI_OK;
+}