@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2020, 2022, Huawei Technologies Co., Ltd. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -52,6 +52,7 @@
 #include "utilities/debug.hpp"
 #include "utilities/events.hpp"
 #include "utilities/vmError.hpp"
+#include "utilities/vmErrorStepper.hpp"
 
 // put OS-includes here
 # include <dlfcn.h>
@@ -333,39 +334,50 @@ static const char* reg_abi_names[] = {
 };
 
 void os::print_context(outputStream *st, const void *context) {
-  if (context == NULL) {
-    return;
-  }
+  if (context == NULL) return;
 
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
   for (int r = 0; r < 32; r++) {
-    st->print("%-*.*s=", 8, 8, reg_abi_names[r]);
-    print_location(st, uc->uc_mcontext.__gregs[r]);
+    STEP(st->print("%-*.*s=", 8, 8, reg_abi_names[r]),
+         print_location(st, uc->uc_mcontext.__gregs[r]));
   }
   st->cr();
 
-  intptr_t *frame_sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
-  st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(frame_sp));
-  print_hex_dump(st, (address)frame_sp, (address)(frame_sp + 64), sizeof(intptr_t));
-  st->cr();
+# undef STEP
+
+  if (VMErrorStepper::step()) {
+    st->cr();
+    intptr_t *frame_sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
+    st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(frame_sp));
+    print_hex_dump(st, (address)frame_sp, (address)(frame_sp + 64), sizeof(intptr_t));
+  }
 
   // Note: it may be unsafe to inspect memory near pc. For example, pc may
   // point to garbage if entry point in an nmethod is corrupted. Leave
   // this at the end, and hope for the best.
-  address pc = os::Posix::ucontext_get_pc(uc);
-  print_instructions(st, pc, sizeof(char));
+  if (VMErrorStepper::step()) {
+    st->cr();
+    address pc = os::Posix::ucontext_get_pc(uc);
+    print_instructions(st, pc, sizeof(char));
+  }
+
   st->cr();
 }
 
 void os::print_register_info(outputStream *st, const void *context) {
-  if (context == NULL) {
-    return;
-  }
+  if (context == NULL) return;
 
   const ucontext_t *uc = (const ucontext_t*)context;
 
-  st->print_cr("Register to memory mapping:");
+  st->print_cr("Registers:");
   st->cr();
 
   // this is horrendously verbose but the layout of the registers in the