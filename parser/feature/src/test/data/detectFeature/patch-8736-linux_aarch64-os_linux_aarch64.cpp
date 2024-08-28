@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2014, Red Hat Inc. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -327,12 +327,18 @@ void os::print_context(outputStream *st, const void *context) {
   if (context == NULL) return;
 
   const ucontext_t *uc = (const ucontext_t*)context;
+
   st->print_cr("Registers:");
   for (int r = 0; r < 31; r++) {
-    st->print("R%-2d=", r);
-    print_location(st, uc->uc_mcontext.regs[r]);
+    st->print_cr(  "R%d=" INTPTR_FORMAT, r, (uintptr_t)uc->uc_mcontext.regs[r]);
   }
   st->cr();
+}
+
+void os::print_tos_pc(outputStream *st, const void *context) {
+  if (context == NULL) return;
+
+  const ucontext_t* uc = (const ucontext_t*)context;
 
   intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
   st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(sp));
@@ -361,8 +367,10 @@ void os::print_register_info(outputStream *st, const void *context) {
 
   // this is only for the "general purpose" registers
 
-  for (int r = 0; r < 31; r++)
-    st->print_cr(  "R%d=" INTPTR_FORMAT, r, (uintptr_t)uc->uc_mcontext.regs[r]);
+  for (int r = 0; r < 31; r++) {
+    st->print("R%-2d=", r);
+    print_location(st, uc->uc_mcontext.regs[r]);
+  }
   st->cr();
 }
 