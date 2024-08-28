@@ -338,7 +338,7 @@ void frame::verify_deopt_original_pc(CompiledMethod* nm, intptr_t* unextended_sp
 
   address original_pc = nm->get_original_pc(&fr);
   assert(nm->insts_contains_inclusive(original_pc),
-         "original PC must be in the main code section of the the compiled method (or must be immediately following it)");
+         "original PC must be in the main code section of the compiled method (or must be immediately following it)");
   assert(nm->is_method_handle_return(original_pc) == is_method_handle_return, "must be");
 }
 #endif