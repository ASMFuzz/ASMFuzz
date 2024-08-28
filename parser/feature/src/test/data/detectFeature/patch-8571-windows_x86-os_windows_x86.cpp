@@ -50,6 +50,7 @@
 #include "unwind_windows_x86.hpp"
 #include "utilities/events.hpp"
 #include "utilities/vmError.hpp"
+#include "utilities/vmErrorStepper.hpp"
 #include "windbghelp.hpp"
 
 
@@ -401,6 +402,71 @@ void os::print_context(outputStream *st, const void *context) {
 
   const CONTEXT* uc = (const CONTEXT*)context;
 
+# define STEP(instruction1, instruction2) \
+  if (VMErrorStepper::step()) {           \
+    instruction1 ; instruction2 ;         \
+  }
+
+  STEP(st->print_cr("Register to memory mapping:"), st->cr());
+
+  // this is only for the "general purpose" registers
+
+#ifdef AMD64
+  STEP(st->print("RIP="), print_location(st, uc->Rip));
+  STEP(st->print("RAX="), print_location(st, uc->Rax));
+  STEP(st->print("RBX="), print_location(st, uc->Rbx));
+  STEP(st->print("RCX="), print_location(st, uc->Rcx));
+  STEP(st->print("RDX="), print_location(st, uc->Rdx));
+  STEP(st->print("RSP="), print_location(st, uc->Rsp));
+  STEP(st->print("RBP="), print_location(st, uc->Rbp));
+  STEP(st->print("RSI="), print_location(st, uc->Rsi));
+  STEP(st->print("RDI="), print_location(st, uc->Rdi));
+  STEP(st->print("R8 ="), print_location(st, uc->R8));
+  STEP(st->print("R9 ="), print_location(st, uc->R9));
+  STEP(st->print("R10="), print_location(st, uc->R10));
+  STEP(st->print("R11="), print_location(st, uc->R11));
+  STEP(st->print("R12="), print_location(st, uc->R12));
+  STEP(st->print("R13="), print_location(st, uc->R13));
+  STEP(st->print("R14="), print_location(st, uc->R14));
+  STEP(st->print("R15="), print_location(st, uc->R15));
+#else
+  STEP(st->print("EIP="), print_location(st, uc->Eip));
+  STEP(st->print("EAX="), print_location(st, uc->Eax));
+  STEP(st->print("EBX="), print_location(st, uc->Ebx));
+  STEP(st->print("ECX="), print_location(st, uc->Ecx));
+  STEP(st->print("EDX="), print_location(st, uc->Edx));
+  STEP(st->print("ESP="), print_location(st, uc->Esp));
+  STEP(st->print("EBP="), print_location(st, uc->Ebp));
+  STEP(st->print("ESI="), print_location(st, uc->Esi));
+  STEP(st->print("EDI="), print_location(st, uc->Edi));
+#endif
+
+# undef STEP
+
+  if (VMErrorStepper::step()) {
+    st->cr();
+    intptr_t *sp = (intptr_t *)uc->REG_SP;
+    st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", sp);
+    print_hex_dump(st, (address)sp, (address)(sp + 32), sizeof(intptr_t));
+  }
+
+  // Note: it may be unsafe to inspect memory near pc. For example, pc may
+  // point to garbage if entry point in an nmethod is corrupted. Leave
+  // this at the end, and hope for the best.
+  if (VMErrorStepper::step()) {
+    st->cr();
+    address pc = (address)uc->REG_PC;
+    print_instructions(st, pc, sizeof(char));
+  }
+
+  st->cr();
+}
+
+void os::print_register_info(outputStream *st, const void *context) {
+  if (context == NULL) return;
+
+  const CONTEXT* uc = (const CONTEXT*)context;
+
   st->print_cr("Registers:");
 #ifdef AMD64
   st->print(  "RAX=" INTPTR_FORMAT, uc->Rax);
@@ -439,62 +505,6 @@ void os::print_context(outputStream *st, const void *context) {
   st->print(  "EIP=" INTPTR_FORMAT, uc->Eip);
   st->print(", EFLAGS=" INTPTR_FORMAT, uc->EFlags);
 #endif // AMD64
-  st->cr();
-  st->cr();
-
-  intptr_t *sp = (intptr_t *)uc->REG_SP;
-  st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", sp);
-  print_hex_dump(st, (address)sp, (address)(sp + 32), sizeof(intptr_t));
-  st->cr();
-
-  // Note: it may be unsafe to inspect memory near pc. For example, pc may
-  // point to garbage if entry point in an nmethod is corrupted. Leave
-  // this at the end, and hope for the best.
-  address pc = (address)uc->REG_PC;
-  print_instructions(st, pc, sizeof(char));
-  st->cr();
-}
-
-
-void os::print_register_info(outputStream *st, const void *context) {
-  if (context == NULL) return;
-
-  const CONTEXT* uc = (const CONTEXT*)context;
-
-  st->print_cr("Register to memory mapping:");
-  st->cr();
-
-  // this is only for the "general purpose" registers
-
-#ifdef AMD64
-  st->print("RIP="); print_location(st, uc->Rip);
-  st->print("RAX="); print_location(st, uc->Rax);
-  st->print("RBX="); print_location(st, uc->Rbx);
-  st->print("RCX="); print_location(st, uc->Rcx);
-  st->print("RDX="); print_location(st, uc->Rdx);
-  st->print("RSP="); print_location(st, uc->Rsp);
-  st->print("RBP="); print_location(st, uc->Rbp);
-  st->print("RSI="); print_location(st, uc->Rsi);
-  st->print("RDI="); print_location(st, uc->Rdi);
-  st->print("R8 ="); print_location(st, uc->R8);
-  st->print("R9 ="); print_location(st, uc->R9);
-  st->print("R10="); print_location(st, uc->R10);
-  st->print("R11="); print_location(st, uc->R11);
-  st->print("R12="); print_location(st, uc->R12);
-  st->print("R13="); print_location(st, uc->R13);
-  st->print("R14="); print_location(st, uc->R14);
-  st->print("R15="); print_location(st, uc->R15);
-#else
-  st->print("EIP="); print_location(st, uc->Eip);
-  st->print("EAX="); print_location(st, uc->Eax);
-  st->print("EBX="); print_location(st, uc->Ebx);
-  st->print("ECX="); print_location(st, uc->Ecx);
-  st->print("EDX="); print_location(st, uc->Edx);
-  st->print("ESP="); print_location(st, uc->Esp);
-  st->print("EBP="); print_location(st, uc->Ebp);
-  st->print("ESI="); print_location(st, uc->Esi);
-  st->print("EDI="); print_location(st, uc->Edi);
-#endif
 
   st->cr();
 }