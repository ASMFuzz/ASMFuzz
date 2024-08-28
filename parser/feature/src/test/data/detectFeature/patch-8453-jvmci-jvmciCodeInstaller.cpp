@@ -662,7 +662,13 @@ JVMCI::CodeInstallResult CodeInstaller::initialize_buffer(CodeBuffer& buffer, bo
   // section itself so they don't need to be accounted for in the
   // locs_buffer above.
   int stubs_size = estimate_stubs_size(JVMCI_CHECK_OK);
-  int total_size = align_up(_code_size, buffer.insts()->alignment()) + align_up(_constants_size, buffer.consts()->alignment()) + align_up(stubs_size, buffer.stubs()->alignment());
+
+  assert((CodeBuffer::SECT_INSTS == CodeBuffer::SECT_STUBS - 1) &&
+         (CodeBuffer::SECT_CONSTS == CodeBuffer::SECT_INSTS - 1), "sections order: consts, insts, stubs");
+  // buffer content: [constants + code_align] + [code + stubs_align] + [stubs]
+  int total_size = align_up(_constants_size, CodeSection::alignment(CodeBuffer::SECT_INSTS)) +
+                   align_up(_code_size, CodeSection::alignment(CodeBuffer::SECT_STUBS)) +
+                   stubs_size;
 
   if (check_size && total_size > JVMCINMethodSizeLimit) {
     return JVMCI::code_too_large;