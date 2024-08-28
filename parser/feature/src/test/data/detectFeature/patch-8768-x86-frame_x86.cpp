@@ -414,7 +414,7 @@ void frame::verify_deopt_original_pc(CompiledMethod* nm, intptr_t* unextended_sp
 
   address original_pc = nm->get_original_pc(&fr);
   assert(nm->insts_contains_inclusive(original_pc),
-         "original PC must be in the main code section of the the compiled method (or must be immediately following it) original_pc: " INTPTR_FORMAT " unextended_sp: " INTPTR_FORMAT " name: %s", p2i(original_pc), p2i(unextended_sp), nm->name());
+         "original PC must be in the main code section of the compiled method (or must be immediately following it) original_pc: " INTPTR_FORMAT " unextended_sp: " INTPTR_FORMAT " name: %s", p2i(original_pc), p2i(unextended_sp), nm->name());
 }
 #endif
 