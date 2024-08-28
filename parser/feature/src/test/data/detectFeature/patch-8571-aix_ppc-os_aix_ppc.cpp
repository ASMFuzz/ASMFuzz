@@ -1,6 +1,7 @@
 /*
  * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2012, 2021 SAP SE. All rights reserved.
+ * Copyright (c) 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -53,6 +54,7 @@
 #include "signals_posix.hpp"
 #include "utilities/events.hpp"
 #include "utilities/vmError.hpp"
+#include "utilities/vmErrorStepper.hpp"
 #ifdef COMPILER1
 #include "c1/c1_Runtime1.hpp"
 #endif
@@ -436,34 +438,49 @@ void os::print_context(outputStream *st, const void *context) {
 
   const ucontext_t* uc = (const ucontext_t*)context;
 
-  st->print_cr("Registers:");
-  st->print("pc =" INTPTR_FORMAT "  ", uc->uc_mcontext.jmp_context.iar);
-  st->print("lr =" INTPTR_FORMAT "  ", uc->uc_mcontext.jmp_context.lr);
-  st->print("ctr=" INTPTR_FORMAT "  ", uc->uc_mcontext.jmp_context.ctr);
-  st->cr();
-  for (int i = 0; i < 32; i++) {
-    st->print("r%-2d=" INTPTR_FORMAT "  ", i, uc->uc_mcontext.jmp_context.gpr[i]);
-    if (i % 3 == 2) st->cr();
+# define STEP(instruction1, instruction2) \
+  if (VMErrorStepper::step()) {           \
+    instruction1 ; instruction2 ;         \
   }
-  st->cr();
-  st->cr();
 
-  intptr_t *sp = (intptr_t *)os::Aix::ucontext_get_sp(uc);
-  st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", sp);
-  print_hex_dump(st, (address)sp, (address)(sp + 128), sizeof(intptr_t));
+  STEP(st->print_cr("Register to memory mapping:"), st->cr());
+
+  STEP(st->print("pc ="), print_location(st, (intptr_t)uc->uc_mcontext.jmp_context.iar));
+  STEP(st->print("lr ="), print_location(st, (intptr_t)uc->uc_mcontext.jmp_context.lr));
+  STEP(st->print("sp ="), print_location(st, (intptr_t)os::Aix::ucontext_get_sp(uc)));
+
+  for (int r = 0; r < 32; r++) {
+    STEP(st->print("r%-2d=", r),
+          print_location(st, (intptr_t)uc->uc_mcontext.jmp_context.gpr[r]));
+  }
   st->cr();
 
+# undef STEP
+
+  if (VMErrorStepper::step()) {
+    st->cr();
+    intptr_t *sp = (intptr_t *)os::Aix::ucontext_get_sp(uc);
+    st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", sp);
+    print_hex_dump(st, (address)sp, (address)(sp + 128), sizeof(intptr_t));
+  }
+
   // Note: it may be unsafe to inspect memory near pc. For example, pc may
   // point to garbage if entry point in an nmethod is corrupted. Leave
   // this at the end, and hope for the best.
-  address pc = os::Posix::ucontext_get_pc(uc);
-  print_instructions(st, pc, /*instrsize=*/4);
-  st->cr();
+  if (VMErrorStepper::step()) {
+    st->cr();
+    address pc = os::Posix::ucontext_get_pc(uc);
+    print_instructions(st, pc, /*instrsize=*/4);
+  }
 
   // Try to decode the instructions.
-  st->print_cr("Decoded instructions: (pc=" PTR_FORMAT ")", pc);
-  st->print("<TODO: PPC port - print_context>");
-  // TODO: PPC port Disassembler::decode(pc, 16, 16, st);
+  if (VMErrorStepper::step()) {
+    st->cr();
+    st->print_cr("Decoded instructions: (pc=" PTR_FORMAT ")", pc);
+    st->print("<TODO: PPC port - print_context>");
+    // TODO: PPC port Disassembler::decode(pc, 16, 16, st);
+  }
+
   st->cr();
 }
 
@@ -472,17 +489,18 @@ void os::print_register_info(outputStream *st, const void *context) {
 
   ucontext_t *uc = (ucontext_t*)context;
 
-  st->print_cr("Register to memory mapping:");
+  st->print_cr("Registers:");
+
+  st->print("pc =" INTPTR_FORMAT "  ", uc->uc_mcontext.jmp_context.iar);
+  st->print("lr =" INTPTR_FORMAT "  ", uc->uc_mcontext.jmp_context.lr);
+  st->print("ctr=" INTPTR_FORMAT "  ", uc->uc_mcontext.jmp_context.ctr);
   st->cr();
 
-  st->print("pc ="); print_location(st, (intptr_t)uc->uc_mcontext.jmp_context.iar);
-  st->print("lr ="); print_location(st, (intptr_t)uc->uc_mcontext.jmp_context.lr);
-  st->print("sp ="); print_location(st, (intptr_t)os::Aix::ucontext_get_sp(uc));
   for (int i = 0; i < 32; i++) {
-    st->print("r%-2d=", i);
-    print_location(st, (intptr_t)uc->uc_mcontext.jmp_context.gpr[i]);
+    st->print("r%-2d=" INTPTR_FORMAT "  ", i, uc->uc_mcontext.jmp_context.gpr[i]);
+    if (i % 3 == 2) st->cr();
   }
-
+  st->cr();
   st->cr();
 }
 