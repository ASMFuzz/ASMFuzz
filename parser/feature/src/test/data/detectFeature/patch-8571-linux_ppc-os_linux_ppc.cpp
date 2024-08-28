@@ -54,6 +54,7 @@
 #include "utilities/debug.hpp"
 #include "utilities/events.hpp"
 #include "utilities/vmError.hpp"
+#include "utilities/vmErrorStepper.hpp"
 
 // put OS-includes here
 # include <sys/types.h>
@@ -449,28 +450,41 @@ void os::print_context(outputStream *st, const void *context) {
 
   const ucontext_t* uc = (const ucontext_t*)context;
 
-  st->print_cr("Registers:");
-  st->print("pc =" INTPTR_FORMAT "  ", uc->uc_mcontext.regs->nip);
-  st->print("lr =" INTPTR_FORMAT "  ", uc->uc_mcontext.regs->link);
-  st->print("ctr=" INTPTR_FORMAT "  ", uc->uc_mcontext.regs->ctr);
-  st->cr();
-  for (int i = 0; i < 32; i++) {
-    st->print("r%-2d=" INTPTR_FORMAT "  ", i, uc->uc_mcontext.regs->gpr[i]);
-    if (i % 3 == 2) st->cr();
+# define STEP(instruction1, instruction2) \
+  if (VMErrorStepper::step()) {           \
+    instruction1 ; instruction2 ;         \
   }
-  st->cr();
-  st->cr();
 
-  intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
-  st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(sp));
-  print_hex_dump(st, (address)sp, (address)(sp + 128), sizeof(intptr_t));
+  STEP(st->print_cr("Register to memory mapping:"), st->cr());
+
+  STEP(st->print("pc ="), print_location(st, (intptr_t)uc->uc_mcontext.regs->nip));
+  STEP(st->print("lr ="), print_location(st, (intptr_t)uc->uc_mcontext.regs->link));
+  STEP(st->print("ctr ="), print_location(st, (intptr_t)uc->uc_mcontext.regs->ctr));
+
+  for (int r = 0; r < 32; r++) {
+    STEP(st->print("r%-2d=", r),
+         print_location(st, uc->uc_mcontext.regs->gpr[r]));
+  }
   st->cr();
 
+# undef STEP
+
+  if (VMErrorStepper::step()) {
+    st->cr();
+    intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
+    st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(sp));
+    print_hex_dump(st, (address)sp, (address)(sp + 128), sizeof(intptr_t));
+  }
+
   // Note: it may be unsafe to inspect memory near pc. For example, pc may
   // point to garbage if entry point in an nmethod is corrupted. Leave
   // this at the end, and hope for the best.
-  address pc = os::Posix::ucontext_get_pc(uc);
-  print_instructions(st, pc, /*instrsize=*/4);
+  if (VMErrorStepper::step()) {
+    st->cr();
+    address pc = os::Posix::ucontext_get_pc(uc);
+    print_instructions(st, pc, /*instrsize=*/4);
+  }
+
   st->cr();
 }
 
@@ -479,15 +493,16 @@ void os::print_register_info(outputStream *st, const void *context) {
 
   const ucontext_t *uc = (const ucontext_t*)context;
 
-  st->print_cr("Register to memory mapping:");
+  st->print_cr("Registers:");
   st->cr();
 
-  st->print("pc ="); print_location(st, (intptr_t)uc->uc_mcontext.regs->nip);
-  st->print("lr ="); print_location(st, (intptr_t)uc->uc_mcontext.regs->link);
-  st->print("ctr ="); print_location(st, (intptr_t)uc->uc_mcontext.regs->ctr);
+  st->print("pc =" INTPTR_FORMAT "  ", uc->uc_mcontext.regs->nip);
+  st->print("lr =" INTPTR_FORMAT "  ", uc->uc_mcontext.regs->link);
+  st->print("ctr=" INTPTR_FORMAT "  ", uc->uc_mcontext.regs->ctr);
+  st->cr();
   for (int i = 0; i < 32; i++) {
-    st->print("r%-2d=", i);
-    print_location(st, uc->uc_mcontext.regs->gpr[i]);
+    st->print("r%-2d=" INTPTR_FORMAT "  ", i, uc->uc_mcontext.regs->gpr[i]);
+    if (i % 3 == 2) st->cr();
   }
   st->cr();
 }