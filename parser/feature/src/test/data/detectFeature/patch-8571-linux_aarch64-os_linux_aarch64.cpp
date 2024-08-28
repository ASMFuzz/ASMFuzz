@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2014, Red Hat Inc. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -52,6 +52,7 @@
 #include "utilities/debug.hpp"
 #include "utilities/events.hpp"
 #include "utilities/vmError.hpp"
+#include "utilities/vmErrorStepper.hpp"
 
 // put OS-includes here
 # include <sys/types.h>
@@ -327,23 +328,37 @@ void os::print_context(outputStream *st, const void *context) {
   if (context == NULL) return;
 
   const ucontext_t *uc = (const ucontext_t*)context;
-  st->print_cr("Registers:");
+
+# define STEP(instruction1, instruction2) \
+  if (VMErrorStepper::step()) {           \
+    instruction1 ; instruction2 ;         \
+  }
+
+  STEP(st->print_cr("Register to memory mapping:"), st->cr());
+
   for (int r = 0; r < 31; r++) {
-    st->print("R%-2d=", r);
-    print_location(st, uc->uc_mcontext.regs[r]);
+    STEP(st->print("R%-2d=", r), print_location(st, uc->uc_mcontext.regs[r]));
   }
   st->cr();
 
-  intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
-  st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(sp));
-  print_hex_dump(st, (address)sp, (address)(sp + 8*sizeof(intptr_t)), sizeof(intptr_t));
-  st->cr();
+# undef STEP
+
+  if (VMErrorStepper::step()) {
+    st->cr();
+    intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
+    st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(sp));
+    print_hex_dump(st, (address)sp, (address)(sp + 8*sizeof(intptr_t)), sizeof(intptr_t));
+  }
 
   // Note: it may be unsafe to inspect memory near pc. For example, pc may
   // point to garbage if entry point in an nmethod is corrupted. Leave
   // this at the end, and hope for the best.
-  address pc = os::Posix::ucontext_get_pc(uc);
-  print_instructions(st, pc, 4/*native instruction size*/);
+  if (VMErrorStepper::step()) {
+    st->cr();
+    address pc = os::Posix::ucontext_get_pc(uc);
+    print_instructions(st, pc, 4/*native instruction size*/);
+  }
+
   st->cr();
 }
 
@@ -352,13 +367,9 @@ void os::print_register_info(outputStream *st, const void *context) {
 
   const ucontext_t *uc = (const ucontext_t*)context;
 
-  st->print_cr("Register to memory mapping:");
+  st->print_cr("Registers:");
   st->cr();
 
-  // this is horrendously verbose but the layout of the registers in the
-  // context does not match how we defined our abstract Register set, so
-  // we can't just iterate through the gregs area
-
   // this is only for the "general purpose" registers
 
   for (int r = 0; r < 31; r++)