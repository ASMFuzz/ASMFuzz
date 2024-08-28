@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2014, Red Hat Inc. All rights reserved.
  * Copyright (c) 2021, Azul Systems, Inc. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
@@ -54,6 +54,7 @@
 #include "utilities/align.hpp"
 #include "utilities/events.hpp"
 #include "utilities/vmError.hpp"
+#include "utilities/vmErrorStepper.hpp"
 
 // put OS-includes here
 # include <sys/types.h>
@@ -420,7 +421,79 @@ void os::print_context(outputStream *st, const void *context) {
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
+  STEP(st->print(" x0="), print_location(st, uc->context_x[ 0]));
+  STEP(st->print(" x1="), print_location(st, uc->context_x[ 1]));
+  STEP(st->print(" x2="), print_location(st, uc->context_x[ 2]));
+  STEP(st->print(" x3="), print_location(st, uc->context_x[ 3]));
+  STEP(st->print(" x4="), print_location(st, uc->context_x[ 4]));
+  STEP(st->print(" x5="), print_location(st, uc->context_x[ 5]));
+  STEP(st->print(" x6="), print_location(st, uc->context_x[ 6]));
+  STEP(st->print(" x7="), print_location(st, uc->context_x[ 7]));
+  STEP(st->print(" x8="), print_location(st, uc->context_x[ 8]));
+  STEP(st->print(" x9="), print_location(st, uc->context_x[ 9]));
+  STEP(st->print("x10="), print_location(st, uc->context_x[10]));
+  STEP(st->print("x11="), print_location(st, uc->context_x[11]));
+  STEP(st->print("x12="), print_location(st, uc->context_x[12]));
+  STEP(st->print("x13="), print_location(st, uc->context_x[13]));
+  STEP(st->print("x14="), print_location(st, uc->context_x[14]));
+  STEP(st->print("x15="), print_location(st, uc->context_x[15]));
+  STEP(st->print("x16="), print_location(st, uc->context_x[16]));
+  STEP(st->print("x17="), print_location(st, uc->context_x[17]));
+  STEP(st->print("x18="), print_location(st, uc->context_x[18]));
+  STEP(st->print("x19="), print_location(st, uc->context_x[19]));
+  STEP(st->print("x20="), print_location(st, uc->context_x[20]));
+  STEP(st->print("x21="), print_location(st, uc->context_x[21]));
+  STEP(st->print("x22="), print_location(st, uc->context_x[22]));
+  STEP(st->print("x23="), print_location(st, uc->context_x[23]));
+  STEP(st->print("x24="), print_location(st, uc->context_x[24]));
+  STEP(st->print("x25="), print_location(st, uc->context_x[25]));
+  STEP(st->print("x26="), print_location(st, uc->context_x[26]));
+  STEP(st->print("x27="), print_location(st, uc->context_x[27]));
+  STEP(st->print("x28="), print_location(st, uc->context_x[28]));
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
+    print_instructions(st, pc, 4/*native instruction size*/);
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
   st->print( " x0=" INTPTR_FORMAT, (intptr_t)uc->context_x[ 0]);
   st->print("  x1=" INTPTR_FORMAT, (intptr_t)uc->context_x[ 1]);
   st->print("  x2=" INTPTR_FORMAT, (intptr_t)uc->context_x[ 2]);
@@ -464,65 +537,6 @@ void os::print_context(outputStream *st, const void *context) {
   st->print(  "pc=" INTPTR_FORMAT,  (intptr_t)uc->context_pc);
   st->print(" cpsr=" INTPTR_FORMAT, (intptr_t)uc->context_cpsr);
   st->cr();
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
-  print_instructions(st, pc, 4/*native instruction size*/);
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
-  st->print(" x0="); print_location(st, uc->context_x[ 0]);
-  st->print(" x1="); print_location(st, uc->context_x[ 1]);
-  st->print(" x2="); print_location(st, uc->context_x[ 2]);
-  st->print(" x3="); print_location(st, uc->context_x[ 3]);
-  st->print(" x4="); print_location(st, uc->context_x[ 4]);
-  st->print(" x5="); print_location(st, uc->context_x[ 5]);
-  st->print(" x6="); print_location(st, uc->context_x[ 6]);
-  st->print(" x7="); print_location(st, uc->context_x[ 7]);
-  st->print(" x8="); print_location(st, uc->context_x[ 8]);
-  st->print(" x9="); print_location(st, uc->context_x[ 9]);
-  st->print("x10="); print_location(st, uc->context_x[10]);
-  st->print("x11="); print_location(st, uc->context_x[11]);
-  st->print("x12="); print_location(st, uc->context_x[12]);
-  st->print("x13="); print_location(st, uc->context_x[13]);
-  st->print("x14="); print_location(st, uc->context_x[14]);
-  st->print("x15="); print_location(st, uc->context_x[15]);
-  st->print("x16="); print_location(st, uc->context_x[16]);
-  st->print("x17="); print_location(st, uc->context_x[17]);
-  st->print("x18="); print_location(st, uc->context_x[18]);
-  st->print("x19="); print_location(st, uc->context_x[19]);
-  st->print("x20="); print_location(st, uc->context_x[20]);
-  st->print("x21="); print_location(st, uc->context_x[21]);
-  st->print("x22="); print_location(st, uc->context_x[22]);
-  st->print("x23="); print_location(st, uc->context_x[23]);
-  st->print("x24="); print_location(st, uc->context_x[24]);
-  st->print("x25="); print_location(st, uc->context_x[25]);
-  st->print("x26="); print_location(st, uc->context_x[26]);
-  st->print("x27="); print_location(st, uc->context_x[27]);
-  st->print("x28="); print_location(st, uc->context_x[28]);
-
-  st->cr();
 }
 
 void os::setup_fpu() {