@@ -229,20 +229,39 @@ address* frame::compiled_sender_pc_addr(CodeBlob* cb) const {
 
 void frame::patch_pc(Thread* thread, address pc) {
   assert(_cb == CodeCache::find_blob(pc), "unexpected pc");
+  address* pc_addr = (address*)&(own_abi()->lr);
+
   if (TracePcPatching) {
     tty->print_cr("patch_pc at address " PTR_FORMAT " [" PTR_FORMAT " -> " PTR_FORMAT "]",
                   p2i(&((address*) _sp)[-1]), p2i(((address*) _sp)[-1]), p2i(pc));
   }
+  assert(!Continuation::is_return_barrier_entry(*pc_addr), "return barrier");
+  assert(_pc == *pc_addr || pc == *pc_addr || 0 == *pc_addr,
+         "must be (pc: " INTPTR_FORMAT " _pc: " INTPTR_FORMAT " pc_addr: " INTPTR_FORMAT
+         " *pc_addr: " INTPTR_FORMAT  " sp: " INTPTR_FORMAT ")",
+         p2i(pc), p2i(_pc), p2i(pc_addr), p2i(*pc_addr), p2i(sp()));
+  DEBUG_ONLY(address old_pc = _pc;)
   own_abi()->lr = (uint64_t)pc;
-  if (_cb != NULL && _cb->is_nmethod() && ((nmethod*)_cb)->is_deopt_pc(_pc)) {
-    address orig = (((nmethod*)_cb)->get_original_pc(this));
-    assert(orig == _pc, "expected original to be stored before patching");
+  _pc = pc; // must be set before call to get_deopt_original_pc
+  address original_pc = CompiledMethod::get_deopt_original_pc(this);
+  if (original_pc != NULL) {
+    assert(original_pc == old_pc, "expected original PC to be stored before patching");
     _deopt_state = is_deoptimized;
-    // Leave _pc as is.
+    _pc = original_pc;
   } else {
     _deopt_state = not_deoptimized;
-    _pc = pc;
   }
+  assert(!is_compiled_frame() || !_cb->as_compiled_method()->is_deopt_entry(_pc), "must be");
+
+#ifdef ASSERT
+  {
+    frame f(this->sp(), pc, this->unextended_sp());
+    assert(f.is_deoptimized_frame() == this->is_deoptimized_frame() && f.pc() == this->pc() && f.raw_pc() == this->raw_pc(),
+           "must be (f.is_deoptimized_frame(): %d this->is_deoptimized_frame(): %d "
+           "f.pc(): " INTPTR_FORMAT " this->pc(): " INTPTR_FORMAT " f.raw_pc(): " INTPTR_FORMAT " this->raw_pc(): " INTPTR_FORMAT ")",
+           f.is_deoptimized_frame(), this->is_deoptimized_frame(), p2i(f.pc()), p2i(this->pc()), p2i(f.raw_pc()), p2i(this->raw_pc()));
+  }
+#endif
 }
 
 bool frame::is_interpreted_frame_valid(JavaThread* thread) const {
@@ -384,9 +403,14 @@ intptr_t *frame::initial_deoptimization_info() {
 #ifndef PRODUCT
 // This is a generic constructor which is only used by pns() in debug.cpp.
 frame::frame(void* sp, void* fp, void* pc) : _sp((intptr_t*)sp),
+                                             _pc((address)pc),
+                                             _cb(NULL),
+                                             _oop_map(NULL),
                                              _on_heap(false),
-                                             _unextended_sp((intptr_t*)sp) {
-  find_codeblob_and_set_pc_and_deopt_state((address)pc); // also sets _fp and adjusts _unextended_sp
+                                             DEBUG_ONLY(_frame_index(-1) COMMA)
+                                             _unextended_sp((intptr_t*)sp),
+                                             _fp(NULL) {
+  setup(); // also sets _fp and adjusts _unextended_sp
 }
 
 #endif