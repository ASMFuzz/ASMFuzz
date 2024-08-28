@@ -1,5 +1,6 @@
 /*
  * Copyright (c) 2020, Microsoft Corporation. All rights reserved.
+ * Copyright (c) 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -203,6 +204,12 @@ void os::print_context(outputStream *st, const void *context) {
   st->print(", X28=" INTPTR_FORMAT, uc->X28);
   st->cr();
   st->cr();
+}
+
+void os::print_tos_pc(outputStream *st, const void *context) {
+  if (context == NULL) return;
+
+  const CONTEXT* uc = (const CONTEXT*)context;
 
   intptr_t *sp = (intptr_t *)uc->Sp;
   st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", sp);
@@ -216,7 +223,6 @@ void os::print_context(outputStream *st, const void *context) {
   st->print_cr("Instructions: (pc=" PTR_FORMAT ")", pc);
   print_hex_dump(st, pc - 32, pc + 32, sizeof(char));
   st->cr();
-
 }
 
 void os::print_register_info(outputStream *st, const void *context) {