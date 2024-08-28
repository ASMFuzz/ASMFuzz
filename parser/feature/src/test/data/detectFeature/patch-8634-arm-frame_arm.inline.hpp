@@ -40,16 +40,17 @@ inline frame::frame() {
   _cb = NULL;
   _deopt_state = unknown;
   _on_heap = false;
+  _oop_map = NULL;
   DEBUG_ONLY(_frame_index = -1;)
 }
 
 inline frame::frame(intptr_t* sp) {
   Unimplemented();
 }
 
-inline void frame::init(intptr_t* sp, intptr_t* fp, address pc) {
+inline void frame::init(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc) {
   _sp = sp;
-  _unextended_sp = sp;
+  _unextended_sp = unextended_sp;
   _fp = fp;
   _pc = pc;
   assert(pc != NULL, "no pc?");
@@ -60,59 +61,28 @@ inline void frame::init(intptr_t* sp, intptr_t* fp, address pc) {
   address original_pc = CompiledMethod::get_deopt_original_pc(this);
   if (original_pc != NULL) {
     _pc = original_pc;
+    assert(_cb->as_compiled_method()->insts_contains_inclusive(_pc),
+           "original PC must be in the main code section of the the compiled method (or must be immediately following it)");
     _deopt_state = is_deoptimized;
   } else {
     _deopt_state = not_deoptimized;
   }
   _on_heap = false;
+  _oop_map = NULL;
 }
 
 inline frame::frame(intptr_t* sp, intptr_t* fp, address pc) {
-  init(sp, fp, pc);
+  init(sp, sp, fp, pc);
 }
 
 inline frame::frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc) {
-  _sp = sp;
-  _unextended_sp = unextended_sp;
-  _fp = fp;
-  _pc = pc;
-  assert(pc != NULL, "no pc?");
-  _cb = CodeCache::find_blob(pc);
-  adjust_unextended_sp();
-  DEBUG_ONLY(_frame_index = -1;)
-
-  address original_pc = CompiledMethod::get_deopt_original_pc(this);
-  if (original_pc != NULL) {
-    _pc = original_pc;
-    assert(_cb->as_compiled_method()->insts_contains_inclusive(_pc),
-           "original PC must be in the main code section of the compiled method (or must be immediately following it)");
-    _deopt_state = is_deoptimized;
-  } else {
-    _deopt_state = not_deoptimized;
-  }
-  _on_heap = false;
+  init(sp, unextended_sp, fp, pc);
 }
 
-
 inline frame::frame(intptr_t* sp, intptr_t* fp) {
-  _sp = sp;
-  _unextended_sp = sp;
-  _fp = fp;
-  assert(sp != NULL,"null SP ?");
-  _pc = (address)(sp[-1]);
-  // assert(_pc != NULL, "no pc?"); // see comments in x86
-  _cb = CodeCache::find_blob(_pc);
-  adjust_unextended_sp();
-  DEBUG_ONLY(_frame_index = -1;)
-
-  address original_pc = CompiledMethod::get_deopt_original_pc(this);
-  if (original_pc != NULL) {
-    _pc = original_pc;
-    _deopt_state = is_deoptimized;
-  } else {
-    _deopt_state = not_deoptimized;
-  }
-  _on_heap = false;
+  assert(sp != NULL, "null SP?");
+  address pc = (address)(sp[-1]);
+  init(sp, sp, fp, pc);
 }
 
 
@@ -243,7 +213,16 @@ inline int frame::frame_size() const {
 }
 
 inline const ImmutableOopMap* frame::get_oop_map() const {
-  Unimplemented();
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
   return NULL;
 }
 