@@ -85,7 +85,7 @@ inline frame::frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address
   if (original_pc != NULL) {
     _pc = original_pc;
     assert(_cb->as_compiled_method()->insts_contains_inclusive(_pc),
-           "original PC must be in the main code section of the the compiled method (or must be immediately following it)");
+           "original PC must be in the main code section of the compiled method (or must be immediately following it)");
     _deopt_state = is_deoptimized;
   } else {
     _deopt_state = not_deoptimized;