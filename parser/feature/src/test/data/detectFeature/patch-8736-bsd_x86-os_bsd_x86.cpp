@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -801,6 +801,7 @@ void os::print_context(outputStream *st, const void *context) {
   if (context == NULL) return;
 
   const ucontext_t *uc = (const ucontext_t*)context;
+
   st->print_cr("Registers:");
 #ifdef AMD64
   st->print(  "RAX=" INTPTR_FORMAT, (intptr_t)uc->context_rax);
@@ -844,6 +845,12 @@ void os::print_context(outputStream *st, const void *context) {
 #endif // AMD64
   st->cr();
   st->cr();
+}
+
+void os::print_tos_pc(outputStream *st, const void *context) {
+  if (context == NULL) return;
+
+  const ucontext_t* uc = (const ucontext_t*)context;
 
   intptr_t *sp = (intptr_t *)os::Bsd::ucontext_get_sp(uc);
   st->print_cr("Top of Stack: (sp=" INTPTR_FORMAT ")", (intptr_t)sp);