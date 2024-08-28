@@ -55,6 +55,7 @@
 #include "utilities/events.hpp"
 #include "utilities/debug.hpp"
 #include "utilities/vmError.hpp"
+#include "utilities/vmErrorStepper.hpp"
 
 // put OS-includes here
 # include <sys/types.h>
@@ -395,6 +396,45 @@ void os::print_context(outputStream *st, const void *context) {
 
   const ucontext_t* uc = (const ucontext_t*)context;
 
+# define STEP(instruction1, instruction2) \
+  if (VMErrorStepper::step()) {           \
+    instruction1 ; instruction2 ;         \
+  }
+
+  STEP(st->print_cr("Register to memory mapping:"), st->cr());
+
+  STEP(st->print("pc ="), print_location(st, (intptr_t)uc->uc_mcontext.psw.addr));
+
+  for (int r = 0; r < 16; r++) {
+    STEP(st->print("r%-2d=", r), print_location(st, uc->uc_mcontext.gregs[r]));
+  }
+
+# undef STEP
+
+  if (VMErrorStepper::step()) {
+    st->cr();
+    intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
+    st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(sp));
+    print_hex_dump(st, (address)sp, (address)(sp + 128), sizeof(intptr_t));
+  }
+
+  // Note: it may be unsafe to inspect memory near pc. For example, pc may
+  // point to garbage if entry point in an nmethod is corrupted. Leave
+  // this at the end, and hope for the best.
+  if (VMErrorStepper::step()) {
+    st->cr();
+    address pc = os::Posix::ucontext_get_pc(uc);
+    print_instructions(st, pc, /*intrsize=*/4);
+  }
+
+  st->cr();
+}
+
+void os::print_register_info(outputStream *st, const void *context) {
+  if (context == NULL) return;
+
+  const ucontext_t *uc = (const ucontext_t*)context;
+
   st->print_cr("Processor state:");
   st->print_cr("----------------");
   st->print_cr("        ip = " INTPTR_FORMAT " ", uc->uc_mcontext.psw.addr);
@@ -432,35 +472,6 @@ void os::print_context(outputStream *st, const void *context) {
     st->cr();
   }
   st->cr();
-  st->cr();
-
-  intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
-  st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(sp));
-  print_hex_dump(st, (address)sp, (address)(sp + 128), sizeof(intptr_t));
-  st->cr();
-
-  // Note: it may be unsafe to inspect memory near pc. For example, pc may
-  // point to garbage if entry point in an nmethod is corrupted. Leave
-  // this at the end, and hope for the best.
-  address pc = os::Posix::ucontext_get_pc(uc);
-  print_instructions(st, pc, /*intrsize=*/4);
-  st->cr();
-}
-
-void os::print_register_info(outputStream *st, const void *context) {
-  if (context == NULL) return;
-
-  const ucontext_t *uc = (const ucontext_t*)context;
-
-  st->print_cr("Register to memory mapping:");
-  st->cr();
-
-  st->print("pc ="); print_location(st, (intptr_t)uc->uc_mcontext.psw.addr);
-  for (int i = 0; i < 16; i++) {
-    st->print("r%-2d=", i);
-    print_location(st, uc->uc_mcontext.gregs[i]);
-  }
-  st->cr();
 }
 
 #ifndef PRODUCT