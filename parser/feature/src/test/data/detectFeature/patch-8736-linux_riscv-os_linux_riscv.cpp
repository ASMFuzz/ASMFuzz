@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2020, 2022, Huawei Technologies Co., Ltd. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -333,17 +333,21 @@ static const char* reg_abi_names[] = {
 };
 
 void os::print_context(outputStream *st, const void *context) {
-  if (context == NULL) {
-    return;
-  }
+  if (context == NULL) return;
 
   const ucontext_t *uc = (const ucontext_t*)context;
+
   st->print_cr("Registers:");
   for (int r = 0; r < 32; r++) {
-    st->print("%-*.*s=", 8, 8, reg_abi_names[r]);
-    print_location(st, uc->uc_mcontext.__gregs[r]);
+    st->print_cr("%-*.*s=" INTPTR_FORMAT, 8, 8, reg_abi_names[r], (uintptr_t)uc->uc_mcontext.__gregs[r]);
   }
   st->cr();
+}
+
+void os::print_tos_pc(outputStream *st, const void *context) {
+  if (context == NULL) return;
+
+  const ucontext_t* uc = (const ucontext_t*)context;
 
   intptr_t *frame_sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
   st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(frame_sp));
@@ -359,9 +363,7 @@ void os::print_context(outputStream *st, const void *context) {
 }
 
 void os::print_register_info(outputStream *st, const void *context) {
-  if (context == NULL) {
-    return;
-  }
+  if (context == NULL) return;
 
   const ucontext_t *uc = (const ucontext_t*)context;
 
@@ -374,8 +376,10 @@ void os::print_register_info(outputStream *st, const void *context) {
 
   // this is only for the "general purpose" registers
 
-  for (int r = 0; r < 32; r++)
-    st->print_cr("%-*.*s=" INTPTR_FORMAT, 8, 8, reg_abi_names[r], (uintptr_t)uc->uc_mcontext.__gregs[r]);
+  for (int r = 0; r < 32; r++) {
+    st->print("%-*.*s=", 8, 8, reg_abi_names[r]);
+    print_location(st, uc->uc_mcontext.__gregs[r]);
+  }
   st->cr();
 }
 