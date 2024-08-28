@@ -77,7 +77,7 @@ inline void frame::setup(address pc) {
     _pc = original_pc;
     _deopt_state = is_deoptimized;
     assert(_cb == NULL || _cb->as_compiled_method()->insts_contains_inclusive(_pc),
-           "original PC must be in the main code section of the the compiled method (or must be immediately following it)");
+           "original PC must be in the main code section of the compiled method (or must be immediately following it)");
   } else {
     if (_cb == SharedRuntime::deopt_blob()) {
       _deopt_state = is_deoptimized;