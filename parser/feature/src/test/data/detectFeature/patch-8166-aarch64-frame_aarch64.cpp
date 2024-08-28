@@ -56,6 +56,9 @@ void RegisterMap::check_location_valid() {
 // Profiling/safepoint support
 
 bool frame::safe_for_sender(JavaThread *thread) {
+  if (is_heap_frame()) {
+    return true;
+  }
   address   sp = (address)_sp;
   address   fp = (address)_fp;
   address   unextended_sp = (address)_unextended_sp;
@@ -156,6 +159,12 @@ bool frame::safe_for_sender(JavaThread *thread) {
       sender_pc = pauth_strip_verifiable((address) *(sender_sp-1), (address)saved_fp);
     }
 
+    if (Continuation::is_return_barrier_entry(sender_pc)) {
+      // If our sender_pc is the return barrier, then our "real" sender is the continuation entry
+      frame s = Continuation::continuation_bottom_sender(thread, *this, sender_sp);
+      sender_sp = s.sp();
+      sender_pc = s.pc();
+    }
 
     // If the potential sender is the interpreter then we can do some more checking
     if (Interpreter::contains(sender_pc)) {
@@ -271,6 +280,7 @@ void frame::patch_pc(Thread* thread, address pc) {
   address signing_sp = (((address*) sp())[-2]);
   address signed_pc = pauth_sign_return_address(pc, (address)signing_sp);
   address pc_old = pauth_strip_verifiable(*pc_addr, (address)signing_sp);
+
   if (TracePcPatching) {
     tty->print("patch_pc at address " INTPTR_FORMAT " [" INTPTR_FORMAT " -> " INTPTR_FORMAT "]",
                   p2i(pc_addr), p2i(pc_old), p2i(pc));
@@ -280,30 +290,24 @@ void frame::patch_pc(Thread* thread, address pc) {
     tty->print_cr("");
   }
 
+  assert(!Continuation::is_return_barrier_entry(pc_old), "return barrier");
+
   // Either the return address is the original one or we are going to
   // patch in the same address that's already there.
-  assert(_pc == pc_old || pc == pc_old, "must be");
+  assert(_pc == pc_old || pc == pc_old || pc_old == 0, "");
+  DEBUG_ONLY(address old_pc = _pc;)
   *pc_addr = signed_pc;
+  _pc = pc; // must be set before call to get_deopt_original_pc
   address original_pc = CompiledMethod::get_deopt_original_pc(this);
   if (original_pc != NULL) {
-    assert(original_pc == _pc, "expected original PC to be stored before patching");
+    assert(original_pc == old_pc, "expected original PC to be stored before patching");
     _deopt_state = is_deoptimized;
-    // leave _pc as is
+    _pc = original_pc;
   } else {
     _deopt_state = not_deoptimized;
-    _pc = pc;
   }
 }
 
-bool frame::is_interpreted_frame() const  {
-  return Interpreter::contains(pc());
-}
-
-int frame::frame_size(RegisterMap* map) const {
-  frame sender = this->sender(map);
-  return sender.sp() - sp();
-}
-
 intptr_t* frame::entry_frame_argument_at(int offset) const {
   // convert offset to index to deal with tsi
   int index = (Interpreter::expr_offset_in_bytes(offset)/wordSize);
@@ -330,7 +334,7 @@ BasicObjectLock* frame::interpreter_frame_monitor_begin() const {
 }
 
 BasicObjectLock* frame::interpreter_frame_monitor_end() const {
-  BasicObjectLock* result = (BasicObjectLock*) *addr_at(interpreter_frame_monitor_block_top_offset);
+  BasicObjectLock* result = (BasicObjectLock*) at(interpreter_frame_monitor_block_top_offset);
   // make sure the pointer points inside the frame
   assert(sp() <= (intptr_t*) result, "monitor end should be above the stack pointer");
   assert((intptr_t*) result < fp(),  "monitor end should be strictly below the frame pointer");
@@ -401,6 +405,7 @@ void frame::verify_deopt_original_pc(CompiledMethod* nm, intptr_t* unextended_sp
 
 //------------------------------------------------------------------------------
 // frame::adjust_unextended_sp
+#ifdef ASSERT
 void frame::adjust_unextended_sp() {
   // On aarch64, sites calling method handle intrinsics and lambda forms are treated
   // as any other call site. Therefore, no special action is needed when we are
@@ -412,32 +417,12 @@ void frame::adjust_unextended_sp() {
       // If the sender PC is a deoptimization point, get the original PC.
       if (sender_cm->is_deopt_entry(_pc) ||
           sender_cm->is_deopt_mh_entry(_pc)) {
-        DEBUG_ONLY(verify_deopt_original_pc(sender_cm, _unextended_sp));
+        verify_deopt_original_pc(sender_cm, _unextended_sp);
       }
     }
   }
 }
-
-//------------------------------------------------------------------------------
-// frame::update_map_with_saved_link
-void frame::update_map_with_saved_link(RegisterMap* map, intptr_t** link_addr) {
-  // The interpreter and compiler(s) always save fp in a known
-  // location on entry. We must record where that location is
-  // so that if fp was live on callout from c2 we can find
-  // the saved copy no matter what it called.
-
-  // Since the interpreter always saves fp if we record where it is then
-  // we don't have to always save fp on entry and exit to c2 compiled
-  // code, on entry will be enough.
-  map->set_location(rfp->as_VMReg(), (address) link_addr);
-  // this is weird "H" ought to be at a higher address however the
-  // oopMaps seems to have the "H" regs at the same address and the
-  // vanilla register.
-  // XXXX make this go away
-  if (true) {
-    map->set_location(rfp->as_VMReg()->next(), (address) link_addr);
-  }
-}
+#endif
 
 
 //------------------------------------------------------------------------------
@@ -449,6 +434,7 @@ frame frame::sender_for_interpreter_frame(RegisterMap* map) const {
 
   // This is the sp before any possible extension (adapter/locals).
   intptr_t* unextended_sp = interpreter_frame_sender_sp();
+  intptr_t* sender_fp = link();
 
 #if COMPILER2_OR_JVMCI
   if (map->update_map()) {
@@ -459,94 +445,15 @@ frame frame::sender_for_interpreter_frame(RegisterMap* map) const {
   // For ROP protection, Interpreter will have signed the sender_pc, but there is no requirement to authenticate it here.
   address sender_pc = pauth_strip_verifiable(sender_pc_maybe_signed(), (address)link());
 
-  return frame(sender_sp, unextended_sp, link(), sender_pc);
-}
-
-//------------------------------------------------------------------------------
-// frame::sender_for_compiled_frame
-frame frame::sender_for_compiled_frame(RegisterMap* map) const {
-  // When the sp of a compiled frame is correct, we can get the correct sender sp
-  // by unextended sp + frame size.
-  // For the following two scenarios, the sp of a compiled frame is correct:
-  //  a) This compiled frame is built from the anchor.
-  //  b) This compiled frame is built from a callee frame, and the callee frame can
-  //    calculate its sp correctly.
-  //
-  // For b), if the callee frame is a native code frame (such as leaf call), the sp of
-  // the compiled frame cannot be calculated correctly. There is currently no suitable
-  // solution to solve this problem perfectly. But when PreserveFramePointer is enabled,
-  // we can get the correct sender sp by fp + 2 (that is sender_sp()).
-
-  assert(_cb->frame_size() >= 0, "must have non-zero frame size");
-  intptr_t* l_sender_sp = (!PreserveFramePointer || _sp_is_trusted) ? unextended_sp() + _cb->frame_size()
-                                                                    : sender_sp();
-  intptr_t* unextended_sp = l_sender_sp;
-
-  // the return_address is always the word on the stack
-
-  // For ROP protection, C1/C2 will have signed the sender_pc, but there is no requirement to authenticate it here.
-  address sender_pc = pauth_strip_verifiable((address) *(l_sender_sp-1), (address) *(l_sender_sp-2));
-
-  intptr_t** saved_fp_addr = (intptr_t**) (l_sender_sp - frame::sender_sp_offset);
-
-  // assert (sender_sp() == l_sender_sp, "should be");
-  // assert (*saved_fp_addr == link(), "should be");
-
-  if (map->update_map()) {
-    // Tell GC to use argument oopmaps for some runtime stubs that need it.
-    // For C1, the runtime stub might not have oop maps, so set this flag
-    // outside of update_register_map.
-    map->set_include_argument_oops(_cb->caller_must_gc_arguments(map->thread()));
-    if (_cb->oop_maps() != NULL) {
-      OopMapSet::update_register_map(this, map);
+  if (Continuation::is_return_barrier_entry(sender_pc)) {
+    if (map->walk_cont()) { // about to walk into an h-stack
+      return Continuation::top_frame(*this, map);
+    } else {
+      return Continuation::continuation_bottom_sender(map->thread(), *this, sender_sp);
     }
-
-    // Since the prolog does the save and restore of FP there is no
-    // oopmap for it so we must fill in its location as if there was
-    // an oopmap entry since if our caller was compiled code there
-    // could be live jvm state in it.
-    update_map_with_saved_link(map, saved_fp_addr);
   }
 
-  return frame(l_sender_sp, unextended_sp, *saved_fp_addr, sender_pc);
-}
-
-//------------------------------------------------------------------------------
-// frame::sender_raw
-frame frame::sender_raw(RegisterMap* map) const {
-  // Default is we done have to follow them. The sender_for_xxx will
-  // update it accordingly
-   map->set_include_argument_oops(false);
-
-  if (is_entry_frame())
-    return sender_for_entry_frame(map);
-  if (is_interpreted_frame())
-    return sender_for_interpreter_frame(map);
-  assert(_cb == CodeCache::find_blob(pc()),"Must be the same");
-
-  // This test looks odd: why is it not is_compiled_frame() ?  That's
-  // because stubs also have OOP maps.
-  if (_cb != NULL) {
-    return sender_for_compiled_frame(map);
-  }
-
-  // Must be native-compiled frame, i.e. the marshaling code for native
-  // methods that exists in the core system.
-
-  // Native code may or may not have signed the return address, we have no way to be sure or what
-  // signing methods they used. Instead, just ensure the stripped value is used.
-
-  return frame(sender_sp(), link(), sender_pc());
-}
-
-frame frame::sender(RegisterMap* map) const {
-  frame result = sender_raw(map);
-
-  if (map->process_frames()) {
-    StackWatermarkSet::on_iteration(map->thread(), result);
-  }
-
-  return result;
+  return frame(sender_sp, unextended_sp, sender_fp, sender_pc);
 }
 
 bool frame::is_interpreted_frame_valid(JavaThread* thread) const {
@@ -655,7 +562,6 @@ BasicType frame::interpreter_frame_result(oop* oop_result, jvalue* value_result)
   return type;
 }
 
-
 intptr_t* frame::interpreter_frame_tos_at(jint offset) const {
   int index = (Interpreter::expr_offset_in_bytes(offset)/wordSize);
   return &interpreter_frame_tos_address()[index];
@@ -678,6 +584,14 @@ void frame::describe_pd(FrameValues& values, int frame_no) {
     DESCRIBE_FP_OFFSET(interpreter_frame_bcp);
     DESCRIBE_FP_OFFSET(interpreter_frame_initial_sp);
   }
+
+  intptr_t* ret_pc_loc = sp() - return_addr_offset;
+  address ret_pc = *(address*)ret_pc_loc;
+  if (Continuation::is_return_barrier_entry(ret_pc))
+    values.describe(frame_no, ret_pc_loc, "return address (return barrier)");
+  else
+    values.describe(frame_no, ret_pc_loc, err_msg("return address for #%d", frame_no));
+  values.describe(frame_no, sp() - sender_sp_offset, err_msg("saved fp for #%d", frame_no), 0);
 }
 #endif
 
@@ -686,19 +600,6 @@ intptr_t *frame::initial_deoptimization_info() {
   return NULL;
 }
 
-intptr_t* frame::real_fp() const {
-  if (_cb != NULL) {
-    // use the frame size if valid
-    int size = _cb->frame_size();
-    if (size > 0) {
-      return unextended_sp() + size;
-    }
-  }
-  // else rely on fp()
-  assert(! is_compiled_frame(), "unknown compiled frame size");
-  return fp();
-}
-
 #undef DESCRIBE_FP_OFFSET
 
 #define DESCRIBE_FP_OFFSET(name)                     \