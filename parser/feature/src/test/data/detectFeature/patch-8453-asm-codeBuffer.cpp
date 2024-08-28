@@ -96,13 +96,14 @@ CodeBuffer::CodeBuffer(CodeBlob* blob) DEBUG_ONLY(: Scrubber(this, sizeof(*this)
 }
 
 void CodeBuffer::initialize(csize_t code_size, csize_t locs_size) {
-  // Compute maximal alignment.
-  int align = _insts.alignment();
   // Always allow for empty slop around each section.
   int slop = (int) CodeSection::end_slop();
 
+  assert(SECT_LIMIT == 3, "total_size explicitly lists all section alignments");
+  int total_size = code_size + _consts.alignment() + _insts.alignment() + _stubs.alignment() + SECT_LIMIT * slop;
+
   assert(blob() == NULL, "only once");
-  set_blob(BufferBlob::create(_name, code_size + (align+slop) * (SECT_LIMIT+1)));
+  set_blob(BufferBlob::create(_name, total_size));
   if (blob() == NULL) {
     // The assembler constructor will throw a fatal on an empty CodeBuffer.
     return;  // caller must test this