@@ -26,8 +26,12 @@
 #ifndef CPU_AARCH64_FRAME_AARCH64_INLINE_HPP
 #define CPU_AARCH64_FRAME_AARCH64_INLINE_HPP
 
-#include "code/codeCache.hpp"
+#include "code/codeBlob.inline.hpp"
+#include "code/codeCache.inline.hpp"
 #include "code/vmreg.inline.hpp"
+#include "interpreter/interpreter.hpp"
+#include "interpreter/oopMapCache.hpp"
+#include "runtime/sharedRuntime.hpp"
 #include "pauth_aarch64.hpp"
 
 // Inline functions for AArch64 frames:
@@ -42,6 +46,8 @@ inline frame::frame() {
   _cb = NULL;
   _deopt_state = unknown;
   _sp_is_trusted = false;
+  _on_heap = false;
+  DEBUG_ONLY(_frame_index = -1;)
 }
 
 static int spin;
@@ -54,16 +60,30 @@ inline void frame::init(intptr_t* sp, intptr_t* fp, address pc) {
   _unextended_sp = sp;
   _fp = fp;
   _pc = pc;
+  _oop_map = NULL;
+  _on_heap = false;
+  DEBUG_ONLY(_frame_index = -1;)
+
   assert(pc != NULL, "no pc?");
   _cb = CodeCache::find_blob(pc);
+  setup(pc);
+}
+
+inline void frame::setup(address pc) {
   adjust_unextended_sp();
 
   address original_pc = CompiledMethod::get_deopt_original_pc(this);
   if (original_pc != NULL) {
     _pc = original_pc;
     _deopt_state = is_deoptimized;
+    assert(_cb == NULL || _cb->as_compiled_method()->insts_contains_inclusive(_pc),
+           "original PC must be in the main code section of the the compiled method (or must be immediately following it)");
   } else {
-    _deopt_state = not_deoptimized;
+    if (_cb == SharedRuntime::deopt_blob()) {
+      _deopt_state = is_deoptimized;
+    } else {
+      _deopt_state = not_deoptimized;
+    }
   }
   _sp_is_trusted = false;
 }
@@ -72,7 +92,7 @@ inline frame::frame(intptr_t* sp, intptr_t* fp, address pc) {
   init(sp, fp, pc);
 }
 
-inline frame::frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc) {
+inline frame::frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc, CodeBlob* cb) {
   assert(pauth_ptr_is_raw(pc), "cannot be signed");
   intptr_t a = intptr_t(sp);
   intptr_t b = intptr_t(fp);
@@ -81,28 +101,68 @@ inline frame::frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address
   _fp = fp;
   _pc = pc;
   assert(pc != NULL, "no pc?");
-  _cb = CodeCache::find_blob(pc);
-  adjust_unextended_sp();
+  _cb = cb;
+  _oop_map = NULL;
+  assert(_cb != NULL, "pc: " INTPTR_FORMAT, p2i(pc));
+  _on_heap = false;
+  DEBUG_ONLY(_frame_index = -1;)
 
-  address original_pc = CompiledMethod::get_deopt_original_pc(this);
-  if (original_pc != NULL) {
-    _pc = original_pc;
-    assert(_cb->as_compiled_method()->insts_contains_inclusive(_pc),
-           "original PC must be in the main code section of the the compiled method (or must be immediately following it)");
-    _deopt_state = is_deoptimized;
-  } else {
-    _deopt_state = not_deoptimized;
-  }
+  setup(pc);
+}
+
+inline frame::frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc, CodeBlob* cb, const ImmutableOopMap* oop_map, bool on_heap) {
+  _sp = sp;
+  _unextended_sp = unextended_sp;
+  _fp = fp;
+  _pc = pc;
+  _cb = cb;
+  _oop_map = oop_map;
+  _deopt_state = not_deoptimized;
   _sp_is_trusted = false;
+  _on_heap = on_heap;
+  DEBUG_ONLY(_frame_index = -1;)
+
+  // In thaw, non-heap frames use this constructor to pass oop_map.  I don't know why.
+  assert(_on_heap || _cb != nullptr, "these frames are always heap frames");
+  if (cb != NULL) {
+    setup(pc);
+  }
+#ifdef ASSERT
+  // The following assertion has been disabled because it would sometime trap for Continuation.run,
+  // which is not *in* a continuation and therefore does not clear the _cont_fastpath flag, but this
+  // is benign even in fast mode (see Freeze::setup_jump)
+  // We might freeze deoptimized frame in slow mode
+  // assert(_pc == pc && _deopt_state == not_deoptimized, "");
+#endif
+}
+
+inline frame::frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc) {
+  intptr_t a = intptr_t(sp);
+  intptr_t b = intptr_t(fp);
+  _sp = sp;
+  _unextended_sp = unextended_sp;
+  _fp = fp;
+  _pc = pc;
+  _cb = CodeCache::find_blob_fast(pc);
+  _oop_map = NULL;
+  assert(_cb != NULL, "pc: " INTPTR_FORMAT " sp: " INTPTR_FORMAT " unextended_sp: " INTPTR_FORMAT " fp: " INTPTR_FORMAT, p2i(pc), p2i(sp), p2i(unextended_sp), p2i(fp));
+  _on_heap = false;
+  DEBUG_ONLY(_frame_index = -1;)
+
+  setup(pc);
 }
 
+inline frame::frame(intptr_t* sp) : frame(sp, sp, *(intptr_t**)(sp - frame::sender_sp_offset), *(address*)(sp - 1)) {}
+
 inline frame::frame(intptr_t* sp, intptr_t* fp) {
   intptr_t a = intptr_t(sp);
   intptr_t b = intptr_t(fp);
   _sp = sp;
   _unextended_sp = sp;
   _fp = fp;
   _pc = (address)(sp[-1]);
+  _on_heap = false;
+  DEBUG_ONLY(_frame_index = -1;)
 
   // Here's a sticky one. This constructor can be called via AsyncGetCallTrace
   // when last_Java_sp is non-null but the pc fetched is junk. If we are truly
@@ -155,7 +215,41 @@ inline intptr_t* frame::link_or_null() const {
   return os::is_readable_pointer(ptr) ? *ptr : NULL;
 }
 
-inline intptr_t* frame::unextended_sp() const     { return _unextended_sp; }
+inline intptr_t* frame::unextended_sp() const          { assert_absolute(); return _unextended_sp; }
+inline void frame::set_unextended_sp(intptr_t* value)  { _unextended_sp = value; }
+inline int  frame::offset_unextended_sp() const        { assert_offset();   return _offset_unextended_sp; }
+inline void frame::set_offset_unextended_sp(int value) { assert_on_heap();  _offset_unextended_sp = value; }
+
+inline intptr_t* frame::real_fp() const {
+  if (_cb != NULL) {
+    // use the frame size if valid
+    int size = _cb->frame_size();
+    if (size > 0) {
+      return unextended_sp() + size;
+    }
+  }
+  // else rely on fp()
+  assert(! is_compiled_frame(), "unknown compiled frame size");
+  return fp();
+}
+
+inline int frame::frame_size() const {
+  return is_interpreted_frame()
+    ? sender_sp() - sp()
+    : cb()->frame_size();
+}
+
+inline int frame::compiled_frame_stack_argsize() const {
+  assert(cb()->is_compiled(), "");
+  return (cb()->as_compiled_method()->method()->num_stack_arg_slots() * VMRegImpl::stack_slot_size) >> LogBytesPerWord;
+}
+
+inline void frame::interpreted_frame_oop_map(InterpreterOopMap* mask) const {
+  assert(mask != NULL, "");
+  Method* m = interpreter_frame_method();
+  int   bci = interpreter_frame_bci();
+  m->mask_for(bci, mask); // OopMapCache::compute_one_oop_map(m, bci, mask);
+}
 
 // Return address:
 
@@ -170,7 +264,7 @@ inline intptr_t** frame::interpreter_frame_locals_addr() const {
 }
 
 inline intptr_t* frame::interpreter_frame_last_sp() const {
-  return *(intptr_t**)addr_at(interpreter_frame_last_sp_offset);
+  return (intptr_t*)at(interpreter_frame_last_sp_offset);
 }
 
 inline intptr_t* frame::interpreter_frame_bcp_addr() const {
@@ -244,21 +338,147 @@ inline JavaCallWrapper** frame::entry_frame_call_wrapper_addr() const {
 inline oop frame::saved_oop_result(RegisterMap* map) const {
   PRAGMA_DIAG_PUSH
   PRAGMA_NONNULL_IGNORED
-  oop* result_adr = (oop *)map->location(r0->as_VMReg());
+  oop* result_adr = (oop *)map->location(r0->as_VMReg(), sp());
   PRAGMA_DIAG_POP
   guarantee(result_adr != NULL, "bad register save location");
-
-  return (*result_adr);
+  return *result_adr;
 }
 
 inline void frame::set_saved_oop_result(RegisterMap* map, oop obj) {
   PRAGMA_DIAG_PUSH
   PRAGMA_NONNULL_IGNORED
-  oop* result_adr = (oop *)map->location(r0->as_VMReg());
+  oop* result_adr = (oop *)map->location(r0->as_VMReg(), sp());
   PRAGMA_DIAG_POP
   guarantee(result_adr != NULL, "bad register save location");
 
   *result_adr = obj;
 }
 
+inline bool frame::is_interpreted_frame() const {
+  return Interpreter::contains(pc());
+}
+
+inline int frame::sender_sp_ret_address_offset() {
+  return frame::sender_sp_offset - frame::return_addr_offset;
+}
+
+inline const ImmutableOopMap* frame::get_oop_map() const {
+  if (_cb == NULL) return NULL;
+  if (_cb->oop_maps() != NULL) {
+    NativePostCallNop* nop = nativePostCallNop_at(_pc);
+    if (nop != NULL && nop->displacement() != 0) {
+      int slot = ((nop->displacement() >> 24) & 0xff);
+      return _cb->oop_map_for_slot(slot, _pc);
+    }
+    const ImmutableOopMap* oop_map = OopMapSet::find_map(this);
+    return oop_map;
+  }
+  return NULL;
+}
+
+//------------------------------------------------------------------------------
+// frame::sender
+inline frame frame::sender(RegisterMap* map) const {
+  frame result = sender_raw(map);
+
+  if (map->process_frames() && !map->in_cont()) {
+    StackWatermarkSet::on_iteration(map->thread(), result);
+  }
+
+  return result;
+}
+
+inline frame frame::sender_raw(RegisterMap* map) const {
+  // Default is we done have to follow them. The sender_for_xxx will
+  // update it accordingly
+  map->set_include_argument_oops(false);
+
+  if (map->in_cont()) { // already in an h-stack
+    return map->stack_chunk()->sender(*this, map);
+  }
+
+  if (is_entry_frame())           return sender_for_entry_frame(map);
+  if (is_optimized_entry_frame()) return sender_for_optimized_entry_frame(map);
+  if (is_interpreted_frame())     return sender_for_interpreter_frame(map);
+
+  assert(_cb == CodeCache::find_blob(pc()), "Must be the same");
+  if (_cb != NULL) return sender_for_compiled_frame(map);
+
+  // Must be native-compiled frame, i.e. the marshaling code for native
+  // methods that exists in the core system.
+
+  // Native code may or may not have signed the return address, we have no way to be sure or what
+  // signing methods they used. Instead, just ensure the stripped value is used.
+
+  return frame(sender_sp(), link(), sender_pc());
+}
+
+inline frame frame::sender_for_compiled_frame(RegisterMap* map) const {
+  // we cannot rely upon the last fp having been saved to the thread
+  // in C2 code but it will have been pushed onto the stack. so we
+  // have to find it relative to the unextended sp
+
+  assert(_cb->frame_size() >= 0, "must have non-zero frame size");
+  intptr_t* l_sender_sp = (!PreserveFramePointer || _sp_is_trusted) ? unextended_sp() + _cb->frame_size()
+                                                                    : sender_sp();
+  assert(!_sp_is_trusted || l_sender_sp == real_fp(), "");
+
+  // the return_address is always the word on the stack
+  // For ROP protection, C1/C2 will have signed the sender_pc, but there is no requirement to authenticate it here.
+  address sender_pc = pauth_strip_verifiable((address) *(l_sender_sp-1), (address) *(l_sender_sp-2));
+
+  intptr_t** saved_fp_addr = (intptr_t**) (l_sender_sp - frame::sender_sp_offset);
+
+  if (map->update_map()) {
+    // Tell GC to use argument oopmaps for some runtime stubs that need it.
+    // For C1, the runtime stub might not have oop maps, so set this flag
+    // outside of update_register_map.
+    if (!_cb->is_compiled()) { // compiled frames do not use callee-saved registers
+      map->set_include_argument_oops(_cb->caller_must_gc_arguments(map->thread()));
+      if (oop_map() != NULL) {
+        _oop_map->update_register_map(this, map);
+      }
+    } else {
+      assert(!_cb->caller_must_gc_arguments(map->thread()), "");
+      assert(!map->include_argument_oops(), "");
+      assert(oop_map() == NULL || !oop_map()->has_any(OopMapValue::callee_saved_value), "callee-saved value in compiled frame");
+    }
+
+    // Since the prolog does the save and restore of EBP there is no oopmap
+    // for it so we must fill in its location as if there was an oopmap entry
+    // since if our caller was compiled code there could be live jvm state in it.
+    update_map_with_saved_link(map, saved_fp_addr);
+  }
+
+  if (Continuation::is_return_barrier_entry(sender_pc)) {
+    if (map->walk_cont()) { // about to walk into an h-stack
+      return Continuation::top_frame(*this, map);
+    } else {
+      Continuation::fix_continuation_bottom_sender(map->thread(), *this, &sender_pc, &l_sender_sp);
+    }
+  }
+
+  intptr_t* unextended_sp = l_sender_sp;
+  return frame(l_sender_sp, unextended_sp, *saved_fp_addr, sender_pc);
+}
+
+template <typename RegisterMapT>
+void frame::update_map_with_saved_link(RegisterMapT* map, intptr_t** link_addr) {
+  // The interpreter and compiler(s) always save EBP/RBP in a known
+  // location on entry. We must record where that location is
+  // so this if EBP/RBP was live on callout from c2 we can find
+  // the saved copy no matter what it called.
+
+  // Since the interpreter always saves EBP/RBP if we record where it is then
+  // we don't have to always save EBP/RBP on entry and exit to c2 compiled
+  // code, on entry will be enough.
+  map->set_location(rfp->as_VMReg(), (address) link_addr);
+  // this is weird "H" ought to be at a higher address however the
+  // oopMaps seems to have the "H" regs at the same address and the
+  // vanilla register.
+  // XXXX make this go away
+  if (true) {
+    map->set_location(rfp->as_VMReg()->next(), (address) link_addr);
+  }
+}
 #endif // CPU_AARCH64_FRAME_AARCH64_INLINE_HPP