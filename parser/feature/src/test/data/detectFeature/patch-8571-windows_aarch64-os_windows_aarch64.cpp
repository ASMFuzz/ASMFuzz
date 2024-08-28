@@ -1,5 +1,6 @@
 /*
  * Copyright (c) 2020, Microsoft Corporation. All rights reserved.
+ * Copyright (c) 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -49,7 +50,7 @@
 #include "utilities/debug.hpp"
 #include "utilities/events.hpp"
 #include "utilities/vmError.hpp"
-
+#include "utilities/vmErrorStepper.hpp"
 
 // put OS-includes here
 # include <sys/types.h>
@@ -164,7 +165,80 @@ void os::print_context(outputStream *st, const void *context) {
 
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
+  STEP(st->print(" X0="), print_location(st, uc->X0));
+  STEP(st->print(" X1="), print_location(st, uc->X1));
+  STEP(st->print(" X2="), print_location(st, uc->X2));
+  STEP(st->print(" X3="), print_location(st, uc->X3));
+  STEP(st->cr(), ;);
+  STEP(st->print(" X4="), print_location(st, uc->X4));
+  STEP(st->print(" X5="), print_location(st, uc->X5));
+  STEP(st->print(" X6="), print_location(st, uc->X6));
+  STEP(st->print(" X7="), print_location(st, uc->X7));
+  STEP(st->cr(), ;);
+  STEP(st->print(" X8="), print_location(st, uc->X8));
+  STEP(st->print(" X9="), print_location(st, uc->X9));
+  STEP(st->print("X10="), print_location(st, uc->X10));
+  STEP(st->print("X11="), print_location(st, uc->X11));
+  STEP(st->cr(), ;);
+  STEP(st->print("X12="), print_location(st, uc->X12));
+  STEP(st->print("X13="), print_location(st, uc->X13));
+  STEP(st->print("X14="), print_location(st, uc->X14));
+  STEP(st->print("X15="), print_location(st, uc->X15));
+  STEP(st->cr(), ;);
+  STEP(st->print("X16="), print_location(st, uc->X16));
+  STEP(st->print("X17="), print_location(st, uc->X17));
+  STEP(st->print("X18="), print_location(st, uc->X18));
+  STEP(st->print("X19="), print_location(st, uc->X19));
+  STEP(st->cr(), ;);
+  STEP(st->print("X20="), print_location(st, uc->X20));
+  STEP(st->print("X21="), print_location(st, uc->X21));
+  STEP(st->print("X22="), print_location(st, uc->X22));
+  STEP(st->print("X23="), print_location(st, uc->X23));
+  STEP(st->cr(), ;);
+  STEP(st->print("X24="), print_location(st, uc->X24));
+  STEP(st->print("X25="), print_location(st, uc->X25));
+  STEP(st->print("X26="), print_location(st, uc->X26));
+  STEP(st->print("X27="), print_location(st, uc->X27));
+  STEP(st->print("X28="), print_location(st, uc->X28));
+
+# undef STEP
+
+  if (VMErrorStepper::step()) {
+    st->cr();
+    intptr_t *sp = (intptr_t *)uc->Sp;
+    st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", sp);
+    print_hex_dump(st, (address)sp, (address)(sp + 32), sizeof(intptr_t));
+  }
+
+  // Note: it may be unsafe to inspect memory near pc. For example, pc may
+  // point to garbage if entry point in an nmethod is corrupted. Leave
+  // this at the end, and hope for the best.
+  if (VMErrorStepper::step()) {
+    st->cr();
+    address pc = (address)uc->Pc;
+    st->print_cr("Instructions: (pc=" PTR_FORMAT ")", pc);
+    print_hex_dump(st, pc - 32, pc + 32, sizeof(char));
+  }
+
+  st->cr();
+}
+
+void os::print_register_info(outputStream *st, const void *context) {
+ if (context == NULL) return;
+
+  const CONTEXT* uc = (const CONTEXT*)context;
+
   st->print_cr("Registers:");
+  st->cr();
 
   st->print(  "X0 =" INTPTR_FORMAT, uc->X0);
   st->print(", X1 =" INTPTR_FORMAT, uc->X1);
@@ -202,68 +276,6 @@ void os::print_context(outputStream *st, const void *context) {
   st->print(", X27=" INTPTR_FORMAT, uc->X27);
   st->print(", X28=" INTPTR_FORMAT, uc->X28);
   st->cr();
-  st->cr();
-
-  intptr_t *sp = (intptr_t *)uc->Sp;
-  st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", sp);
-  print_hex_dump(st, (address)sp, (address)(sp + 32), sizeof(intptr_t));
-  st->cr();
-
-  // Note: it may be unsafe to inspect memory near pc. For example, pc may
-  // point to garbage if entry point in an nmethod is corrupted. Leave
-  // this at the end, and hope for the best.
-  address pc = (address)uc->Pc;
-  st->print_cr("Instructions: (pc=" PTR_FORMAT ")", pc);
-  print_hex_dump(st, pc - 32, pc + 32, sizeof(char));
-  st->cr();
-
-}
-
-void os::print_register_info(outputStream *st, const void *context) {
- if (context == NULL) return;
-
-  const CONTEXT* uc = (const CONTEXT*)context;
-
-  st->print_cr("Register to memory mapping:");
-  st->cr();
-  // this is only for the "general purpose" registers
-  st->print(" X0="); print_location(st, uc->X0);
-  st->print(" X1="); print_location(st, uc->X1);
-  st->print(" X2="); print_location(st, uc->X2);
-  st->print(" X3="); print_location(st, uc->X3);
-  st->cr();
-  st->print(" X4="); print_location(st, uc->X4);
-  st->print(" X5="); print_location(st, uc->X5);
-  st->print(" X6="); print_location(st, uc->X6);
-  st->print(" X7="); print_location(st, uc->X7);
-  st->cr();
-  st->print(" X8="); print_location(st, uc->X8);
-  st->print(" X9="); print_location(st, uc->X9);
-  st->print("X10="); print_location(st, uc->X10);
-  st->print("X11="); print_location(st, uc->X11);
-  st->cr();
-  st->print("X12="); print_location(st, uc->X12);
-  st->print("X13="); print_location(st, uc->X13);
-  st->print("X14="); print_location(st, uc->X14);
-  st->print("X15="); print_location(st, uc->X15);
-  st->cr();
-  st->print("X16="); print_location(st, uc->X16);
-  st->print("X17="); print_location(st, uc->X17);
-  st->print("X18="); print_location(st, uc->X18);
-  st->print("X19="); print_location(st, uc->X19);
-  st->cr();
-  st->print("X20="); print_location(st, uc->X20);
-  st->print("X21="); print_location(st, uc->X21);
-  st->print("X22="); print_location(st, uc->X22);
-  st->print("X23="); print_location(st, uc->X23);
-  st->cr();
-  st->print("X24="); print_location(st, uc->X24);
-  st->print("X25="); print_location(st, uc->X25);
-  st->print("X26="); print_location(st, uc->X26);
-  st->print("X27="); print_location(st, uc->X27);
-  st->print("X28="); print_location(st, uc->X28);
-
-  st->cr();
 }
 
 void os::setup_fpu() {