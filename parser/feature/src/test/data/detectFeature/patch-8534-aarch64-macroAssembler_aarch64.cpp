@@ -403,6 +403,9 @@ void MacroAssembler::far_call(Address entry, CodeBuffer *cbuf, Register tmp) {
   assert(ReservedCodeCacheSize < 4*G, "branch out of range");
   assert(CodeCache::find_blob(entry.target()) != NULL,
          "destination of far call not found in code cache");
+  assert(entry.rspec().type() == relocInfo::external_word_type
+         || entry.rspec().type() == relocInfo::runtime_call_type
+         || entry.rspec().type() == relocInfo::none, "wrong entry relocInfo type");
   if (target_needs_far_branch(entry.target())) {
     uint64_t offset;
     // We can use ADRP here because we know that the total size of
@@ -421,6 +424,9 @@ int MacroAssembler::far_jump(Address entry, CodeBuffer *cbuf, Register tmp) {
   assert(ReservedCodeCacheSize < 4*G, "branch out of range");
   assert(CodeCache::find_blob(entry.target()) != NULL,
          "destination of far call not found in code cache");
+  assert(entry.rspec().type() == relocInfo::external_word_type
+         || entry.rspec().type() == relocInfo::runtime_call_type
+         || entry.rspec().type() == relocInfo::none, "wrong entry relocInfo type");
   address start = pc();
   if (target_needs_far_branch(entry.target())) {
     uint64_t offset;