@@ -52,6 +52,7 @@
 #include "utilities/debug.hpp"
 #include "utilities/events.hpp"
 #include "utilities/vmError.hpp"
+#include "utilities/vmErrorStepper.hpp"
 
 // put OS-includes here
 # include <sys/types.h>
@@ -525,7 +526,77 @@ void os::print_context(outputStream *st, const void *context) {
   if (context == NULL) return;
 
   const ucontext_t *uc = (const ucontext_t*)context;
+
+# define STEP(instruction1, instruction2)   \
+  if (VMErrorStepper::step()) {             \
+    instruction1 ; instruction2 ;           \
+  }
+
+  STEP(st->print_cr("Register to memory mapping:"), st->cr());
+
+#ifdef AMD64
+  STEP(st->print("RAX="), print_location(st, uc->uc_mcontext.gregs[REG_RAX]));
+  STEP(st->print("RBX="), print_location(st, uc->uc_mcontext.gregs[REG_RBX]));
+  STEP(st->print("RCX="), print_location(st, uc->uc_mcontext.gregs[REG_RCX]));
+  STEP(st->print("RDX="), print_location(st, uc->uc_mcontext.gregs[REG_RDX]));
+  STEP(st->print("RSP="), print_location(st, uc->uc_mcontext.gregs[REG_RSP]));
+  STEP(st->print("RBP="), print_location(st, uc->uc_mcontext.gregs[REG_RBP]));
+  STEP(st->print("RSI="), print_location(st, uc->uc_mcontext.gregs[REG_RSI]));
+  STEP(st->print("RDI="), print_location(st, uc->uc_mcontext.gregs[REG_RDI]));
+  STEP(st->print("R8 ="), print_location(st, uc->uc_mcontext.gregs[REG_R8]));
+  STEP(st->print("R9 ="), print_location(st, uc->uc_mcontext.gregs[REG_R9]));
+  STEP(st->print("R10="), print_location(st, uc->uc_mcontext.gregs[REG_R10]));
+  STEP(st->print("R11="), print_location(st, uc->uc_mcontext.gregs[REG_R11]));
+  STEP(st->print("R12="), print_location(st, uc->uc_mcontext.gregs[REG_R12]));
+  STEP(st->print("R13="), print_location(st, uc->uc_mcontext.gregs[REG_R13]));
+  STEP(st->print("R14="), print_location(st, uc->uc_mcontext.gregs[REG_R14]));
+  STEP(st->print("R15="), print_location(st, uc->uc_mcontext.gregs[REG_R15]));
+#else
+  STEP(st->print("EAX="), print_location(st, uc->uc_mcontext.gregs[REG_EAX]));
+  STEP(st->print("EBX="), print_location(st, uc->uc_mcontext.gregs[REG_EBX]));
+  STEP(st->print("ECX="), print_location(st, uc->uc_mcontext.gregs[REG_ECX]));
+  STEP(st->print("EDX="), print_location(st, uc->uc_mcontext.gregs[REG_EDX]));
+  STEP(st->print("ESP="), print_location(st, uc->uc_mcontext.gregs[REG_ESP]));
+  STEP(st->print("EBP="), print_location(st, uc->uc_mcontext.gregs[REG_EBP]));
+  STEP(st->print("ESI="), print_location(st, uc->uc_mcontext.gregs[REG_ESI]));
+  STEP(st->print("EDI="), print_location(st, uc->uc_mcontext.gregs[REG_EDI]));
+#endif // AMD64
+
+# undef STEP
+
+  if (VMErrorStepper::step()) {
+    st->cr();
+    intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
+    st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(sp));
+    print_hex_dump(st, (address)sp, (address)(sp + 8), sizeof(intptr_t));
+  }
+
+  // Note: it may be unsafe to inspect memory near pc. For example, pc may
+  // point to garbage if entry point in an nmethod is corrupted. Leave
+  // this at the end, and hope for the best.
+  if (VMErrorStepper::step()) {
+    st->cr();
+    address pc = os::Posix::ucontext_get_pc(uc);
+    print_instructions(st, pc, sizeof(char));
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
+  // this is horrendously verbose but the layout of the registers in the
+  // context does not match how we defined our abstract Register set, so
+  // we can't just iterate through the gregs area
+
+  // this is only for the "general purpose" registers
+
   st->print_cr("Registers:");
+  st->cr();
+
 #ifdef AMD64
   st->print(  "RAX=" INTPTR_FORMAT, (intptr_t)uc->uc_mcontext.gregs[REG_RAX]);
   st->print(", RBX=" INTPTR_FORMAT, (intptr_t)uc->uc_mcontext.gregs[REG_RBX]);
@@ -569,64 +640,6 @@ void os::print_context(outputStream *st, const void *context) {
   st->print(", CR2=" PTR64_FORMAT, (uint64_t)uc->uc_mcontext.cr2);
 #endif // AMD64
   st->cr();
-  st->cr();
-
-  intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
-  st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(sp));
-  print_hex_dump(st, (address)sp, (address)(sp + 8), sizeof(intptr_t));
-  st->cr();
-
-  // Note: it may be unsafe to inspect memory near pc. For example, pc may
-  // point to garbage if entry point in an nmethod is corrupted. Leave
-  // this at the end, and hope for the best.
-  address pc = os::Posix::ucontext_get_pc(uc);
-  print_instructions(st, pc, sizeof(char));
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
-  // this is horrendously verbose but the layout of the registers in the
-  // context does not match how we defined our abstract Register set, so
-  // we can't just iterate through the gregs area
-
-  // this is only for the "general purpose" registers
-
-#ifdef AMD64
-  st->print("RAX="); print_location(st, uc->uc_mcontext.gregs[REG_RAX]);
-  st->print("RBX="); print_location(st, uc->uc_mcontext.gregs[REG_RBX]);
-  st->print("RCX="); print_location(st, uc->uc_mcontext.gregs[REG_RCX]);
-  st->print("RDX="); print_location(st, uc->uc_mcontext.gregs[REG_RDX]);
-  st->print("RSP="); print_location(st, uc->uc_mcontext.gregs[REG_RSP]);
-  st->print("RBP="); print_location(st, uc->uc_mcontext.gregs[REG_RBP]);
-  st->print("RSI="); print_location(st, uc->uc_mcontext.gregs[REG_RSI]);
-  st->print("RDI="); print_location(st, uc->uc_mcontext.gregs[REG_RDI]);
-  st->print("R8 ="); print_location(st, uc->uc_mcontext.gregs[REG_R8]);
-  st->print("R9 ="); print_location(st, uc->uc_mcontext.gregs[REG_R9]);
-  st->print("R10="); print_location(st, uc->uc_mcontext.gregs[REG_R10]);
-  st->print("R11="); print_location(st, uc->uc_mcontext.gregs[REG_R11]);
-  st->print("R12="); print_location(st, uc->uc_mcontext.gregs[REG_R12]);
-  st->print("R13="); print_location(st, uc->uc_mcontext.gregs[REG_R13]);
-  st->print("R14="); print_location(st, uc->uc_mcontext.gregs[REG_R14]);
-  st->print("R15="); print_location(st, uc->uc_mcontext.gregs[REG_R15]);
-#else
-  st->print("EAX="); print_location(st, uc->uc_mcontext.gregs[REG_EAX]);
-  st->print("EBX="); print_location(st, uc->uc_mcontext.gregs[REG_EBX]);
-  st->print("ECX="); print_location(st, uc->uc_mcontext.gregs[REG_ECX]);
-  st->print("EDX="); print_location(st, uc->uc_mcontext.gregs[REG_EDX]);
-  st->print("ESP="); print_location(st, uc->uc_mcontext.gregs[REG_ESP]);
-  st->print("EBP="); print_location(st, uc->uc_mcontext.gregs[REG_EBP]);
-  st->print("ESI="); print_location(st, uc->uc_mcontext.gregs[REG_ESI]);
-  st->print("EDI="); print_location(st, uc->uc_mcontext.gregs[REG_EDI]);
-#endif // AMD64
-
-  st->cr();
 }
 
 void os::setup_fpu() {