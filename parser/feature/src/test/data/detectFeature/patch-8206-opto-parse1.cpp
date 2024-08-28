@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -23,6 +23,7 @@
  */
 
 #include "precompiled.hpp"
+#include "jvm_io.h"
 #include "compiler/compileLog.hpp"
 #include "interpreter/linkResolver.hpp"
 #include "memory/resourceArea.hpp"
@@ -1552,7 +1553,22 @@ void Parse::do_one_block() {
     assert(!have_se || pre_bc_sp >= inputs, "have enough stack to execute this BC: pre_bc_sp=%d, inputs=%d", pre_bc_sp, inputs);
 #endif //ASSERT
 
-    do_one_bytecode();
+    // Try parsing machine-dependently, then if it is not needed then parse
+    // the bytecode in a machine independent manner
+    if (!do_one_bytecode_targeted()) {
+      do_one_bytecode_common();
+    }
+#ifndef PRODUCT
+    if (C->should_print_igv(1)) {
+      IdealGraphPrinter* printer = C->igv_printer();
+      char buffer[256];
+      jio_snprintf(buffer, sizeof(buffer), "Bytecode %d: %s", bci(), Bytecodes::name(bc()));
+      bool old = printer->traverse_outs();
+      printer->set_traverse_outs(true);
+      printer->print_method(buffer, 4);
+      printer->set_traverse_outs(old);
+    }
+#endif
 
     assert(!have_se || stopped() || failing() || (sp() - pre_bc_sp) == depth,
            "incorrect depth prediction: sp=%d, pre_bc_sp=%d, depth=%d", sp(), pre_bc_sp, depth);