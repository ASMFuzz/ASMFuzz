@@ -837,6 +837,8 @@ bool Disassembler::load_library(outputStream* st) {
   if (_library != NULL) {
     _decode_instructions_virtual = CAST_TO_FN_PTR(Disassembler::decode_func_virtual,
                                           os::dll_lookup(_library, decode_instructions_virtual_name));
+  } else {
+    log_warning(os)("Loading hsdis library failed");
   }
   _tried_to_load_library = true;
   _library_usable        = _decode_instructions_virtual != NULL;