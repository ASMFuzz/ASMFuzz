@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2014, Red Hat Inc. All rights reserved.
  * Copyright (c) 2021, Azul Systems, Inc. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
@@ -420,6 +420,7 @@ void os::print_context(outputStream *st, const void *context) {
   if (context == NULL) return;
 
   const ucontext_t *uc = (const ucontext_t*)context;
+
   st->print_cr("Registers:");
   st->print( " x0=" INTPTR_FORMAT, (intptr_t)uc->context_x[ 0]);
   st->print("  x1=" INTPTR_FORMAT, (intptr_t)uc->context_x[ 1]);
@@ -464,6 +465,12 @@ void os::print_context(outputStream *st, const void *context) {
   st->print(  "pc=" INTPTR_FORMAT,  (intptr_t)uc->context_pc);
   st->print(" cpsr=" INTPTR_FORMAT, (intptr_t)uc->context_cpsr);
   st->cr();
+}
+
+void os::print_tos_pc(outputStream *st, const void *context) {
+  if (context == NULL) return;
+
+  const ucontext_t* uc = (const ucontext_t*)context;
 
   intptr_t *sp = (intptr_t *)os::Bsd::ucontext_get_sp(uc);
   st->print_cr("Top of Stack: (sp=" INTPTR_FORMAT ")", (intptr_t)sp);