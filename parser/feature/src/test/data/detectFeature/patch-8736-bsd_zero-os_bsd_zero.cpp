@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright 2007, 2008, 2009, 2010 Red Hat, Inc.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -247,6 +247,10 @@ void os::print_context(outputStream* st, const void* context) {
   ShouldNotCallThis();
 }
 
+void os::print_tos_pc(outputStream *st, const void *context) {
+  ShouldNotCallThis();
+}
+
 void os::print_register_info(outputStream *st, const void *context) {
   ShouldNotCallThis();
 }