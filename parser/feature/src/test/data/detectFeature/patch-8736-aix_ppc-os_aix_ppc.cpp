@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2012, 2021 SAP SE. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -447,6 +447,12 @@ void os::print_context(outputStream *st, const void *context) {
   }
   st->cr();
   st->cr();
+}
+
+void os::print_tos_pc(outputStream *st, const void *context) {
+  if (context == NULL) return;
+
+  const ucontext_t* uc = (const ucontext_t*)context;
 
   intptr_t *sp = (intptr_t *)os::Aix::ucontext_get_sp(uc);
   st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", sp);