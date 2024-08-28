@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -51,6 +51,7 @@
 #include "utilities/align.hpp"
 #include "utilities/events.hpp"
 #include "utilities/vmError.hpp"
+#include "utilities/vmErrorStepper.hpp"
 
 // put OS-includes here
 # include <sys/types.h>
@@ -801,7 +802,77 @@ void os::print_context(outputStream *st, const void *context) {
   if (context == NULL) return;
 
   const ucontext_t *uc = (const ucontext_t*)context;
+
+# define STEP(instruction1, instruction2) \
+  if (VMErrorStepper::step()) {           \
+    instruction1 ; instruction2 ;         \
+  }
+
+  STEP(st->print_cr("Register to memory mapping:"), st->cr());
+
+  // this is horrendously verbose but the layout of the registers in the
+  // context does not match how we defined our abstract Register set, so
+  // we can't just iterate through the gregs area
+
+  // this is only for the "general purpose" registers
+
+#ifdef AMD64
+  STEP(st->print("RAX="), print_location(st, uc->context_rax));
+  STEP(st->print("RBX="), print_location(st, uc->context_rbx));
+  STEP(st->print("RCX="), print_location(st, uc->context_rcx));
+  STEP(st->print("RDX="), print_location(st, uc->context_rdx));
+  STEP(st->print("RSP="), print_location(st, uc->context_rsp));
+  STEP(st->print("RBP="), print_location(st, uc->context_rbp));
+  STEP(st->print("RSI="), print_location(st, uc->context_rsi));
+  STEP(st->print("RDI="), print_location(st, uc->context_rdi));
+  STEP(st->print("R8 ="), print_location(st, uc->context_r8));
+  STEP(st->print("R9 ="), print_location(st, uc->context_r9));
+  STEP(st->print("R10="), print_location(st, uc->context_r10));
+  STEP(st->print("R11="), print_location(st, uc->context_r11));
+  STEP(st->print("R12="), print_location(st, uc->context_r12));
+  STEP(st->print("R13="), print_location(st, uc->context_r13));
+  STEP(st->print("R14="), print_location(st, uc->context_r14));
+  STEP(st->print("R15="), print_location(st, uc->context_r15));
+#else
+  STEP(st->print("EAX="), print_location(st, uc->context_eax));
+  STEP(st->print("EBX="), print_location(st, uc->context_ebx));
+  STEP(st->print("ECX="), print_location(st, uc->context_ecx));
+  STEP(st->print("EDX="), print_location(st, uc->context_edx));
+  STEP(st->print("ESP="), print_location(st, uc->context_esp));
+  STEP(st->print("EBP="), print_location(st, uc->context_ebp));
+  STEP(st->print("ESI="), print_location(st, uc->context_esi));
+  STEP(st->print("EDI="), print_location(st, uc->context_edi));
+#endif // AMD64
+
+# undef STEP
+
+  if (VMErrorStepper::step()) {
+    st->cr();
+    intptr_t *sp = (intptr_t *)os::Bsd::ucontext_get_sp(uc);
+    st->print_cr("Top of Stack: (sp=" INTPTR_FORMAT ")", (intptr_t)sp);
+    print_hex_dump(st, (address)sp, (address)(sp + 8*sizeof(intptr_t)), sizeof(intptr_t));
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
   st->print_cr("Registers:");
+  st->cr();
+
 #ifdef AMD64
   st->print(  "RAX=" INTPTR_FORMAT, (intptr_t)uc->context_rax);
   st->print(", RBX=" INTPTR_FORMAT, (intptr_t)uc->context_rbx);
@@ -842,63 +913,6 @@ void os::print_context(outputStream *st, const void *context) {
   st->print(  "EIP=" INTPTR_FORMAT, (intptr_t)uc->context_eip);
   st->print(", EFLAGS=" INTPTR_FORMAT, (intptr_t)uc->context_eflags);
 #endif // AMD64
-  st->cr();
-  st->cr();
-
-  intptr_t *sp = (intptr_t *)os::Bsd::ucontext_get_sp(uc);
-  st->print_cr("Top of Stack: (sp=" INTPTR_FORMAT ")", (intptr_t)sp);
-  print_hex_dump(st, (address)sp, (address)(sp + 8*sizeof(intptr_t)), sizeof(intptr_t));
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
-  st->print("RAX="); print_location(st, uc->context_rax);
-  st->print("RBX="); print_location(st, uc->context_rbx);
-  st->print("RCX="); print_location(st, uc->context_rcx);
-  st->print("RDX="); print_location(st, uc->context_rdx);
-  st->print("RSP="); print_location(st, uc->context_rsp);
-  st->print("RBP="); print_location(st, uc->context_rbp);
-  st->print("RSI="); print_location(st, uc->context_rsi);
-  st->print("RDI="); print_location(st, uc->context_rdi);
-  st->print("R8 ="); print_location(st, uc->context_r8);
-  st->print("R9 ="); print_location(st, uc->context_r9);
-  st->print("R10="); print_location(st, uc->context_r10);
-  st->print("R11="); print_location(st, uc->context_r11);
-  st->print("R12="); print_location(st, uc->context_r12);
-  st->print("R13="); print_location(st, uc->context_r13);
-  st->print("R14="); print_location(st, uc->context_r14);
-  st->print("R15="); print_location(st, uc->context_r15);
-#else
-  st->print("EAX="); print_location(st, uc->context_eax);
-  st->print("EBX="); print_location(st, uc->context_ebx);
-  st->print("ECX="); print_location(st, uc->context_ecx);
-  st->print("EDX="); print_location(st, uc->context_edx);
-  st->print("ESP="); print_location(st, uc->context_esp);
-  st->print("EBP="); print_location(st, uc->context_ebp);
-  st->print("ESI="); print_location(st, uc->context_esi);
-  st->print("EDI="); print_location(st, uc->context_edi);
-#endif // AMD64
 
   st->cr();
 }