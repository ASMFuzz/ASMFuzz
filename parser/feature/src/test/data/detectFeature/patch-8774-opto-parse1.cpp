@@ -23,7 +23,6 @@
  */
 
 #include "precompiled.hpp"
-#include "jvm_io.h"
 #include "compiler/compileLog.hpp"
 #include "interpreter/linkResolver.hpp"
 #include "memory/resourceArea.hpp"
@@ -1557,22 +1556,7 @@ void Parse::do_one_block() {
     assert(!have_se || pre_bc_sp >= inputs, "have enough stack to execute this BC: pre_bc_sp=%d, inputs=%d", pre_bc_sp, inputs);
 #endif //ASSERT
 
-    // Try parsing machine-dependently, then if it is not needed then parse
-    // the bytecode in a machine independent manner
-    if (!do_one_bytecode_targeted()) {
-      do_one_bytecode_common();
-    }
-#ifndef PRODUCT
-    if (C->should_print_igv(1)) {
-      IdealGraphPrinter* printer = C->igv_printer();
-      char buffer[256];
-      jio_snprintf(buffer, sizeof(buffer), "Bytecode %d: %s", bci(), Bytecodes::name(bc()));
-      bool old = printer->traverse_outs();
-      printer->set_traverse_outs(true);
-      printer->print_method(buffer, 4);
-      printer->set_traverse_outs(old);
-    }
-#endif
+    do_one_bytecode();
 
     assert(!have_se || stopped() || failing() || (sp() - pre_bc_sp) == depth,
            "incorrect depth prediction: sp=%d, pre_bc_sp=%d, depth=%d", sp(), pre_bc_sp, depth);