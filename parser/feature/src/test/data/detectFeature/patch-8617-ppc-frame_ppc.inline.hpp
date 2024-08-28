@@ -28,61 +28,66 @@
 
 #include "code/codeCache.hpp"
 #include "code/vmreg.inline.hpp"
+#include "runtime/sharedRuntime.hpp"
 #include "utilities/align.hpp"
 
 // Inline functions for ppc64 frames:
 
-// Find codeblob and set deopt_state.
-inline void frame::find_codeblob_and_set_pc_and_deopt_state(address pc) {
-  assert(pc != NULL, "precondition: must have PC");
+// Initialize frame members (_pc and _sp must be given)
+inline void frame::setup() {
+  assert(_pc != nullptr, "precondition: must have PC");
 
-  _cb = CodeCache::find_blob(pc);
-  _pc = pc;   // Must be set for get_deopt_original_pc()
+  if (_cb == nullptr) {
+    _cb = CodeCache::find_blob(_pc);
+  }
+
+  if (_fp == nullptr) {
+    _fp = (intptr_t*)own_abi()->callers_sp;
+  }
 
-  _fp = (intptr_t*)own_abi()->callers_sp;
+  // When thawing continuation frames the _unextended_sp passed to the constructor is not aligend
+  assert(_on_heap || (is_aligned(_sp, alignment_in_bytes) && is_aligned(_fp, alignment_in_bytes)),
+         "invalid alignment sp:" PTR_FORMAT " unextended_sp:" PTR_FORMAT " fp:" PTR_FORMAT, p2i(_sp), p2i(_unextended_sp), p2i(_fp));
 
   address original_pc = CompiledMethod::get_deopt_original_pc(this);
-  if (original_pc != NULL) {
+  if (original_pc != nullptr) {
     _pc = original_pc;
     _deopt_state = is_deoptimized;
+    assert(_cb == nullptr || _cb->as_compiled_method()->insts_contains_inclusive(_pc),
+           "original PC must be in the main code section of the the compiled method (or must be immediately following it)");
   } else {
-    _deopt_state = not_deoptimized;
+    if (_cb == SharedRuntime::deopt_blob()) {
+      _deopt_state = is_deoptimized;
+    } else {
+      _deopt_state = not_deoptimized;
+    }
   }
 
-  assert(((uint64_t)_sp & 0xf) == 0, "SP must be 16-byte aligned");
+  assert(_on_heap || is_aligned(_sp, frame::frame_alignment), "SP must be 16-byte aligned");
 }
 
 // Constructors
 
 // Initialize all fields, _unextended_sp will be adjusted in find_codeblob_and_set_pc_and_deopt_state.
-inline frame::frame() : _sp(NULL), _pc(NULL), _cb(NULL),  _deopt_state(unknown), _on_heap(false),
-#ifdef ASSERT
-                        _frame_index(-1),
-#endif
-                        _unextended_sp(NULL), _fp(NULL) {}
+inline frame::frame() : _sp(nullptr), _pc(nullptr), _cb(nullptr), _oop_map(nullptr), _deopt_state(unknown),
+                        _on_heap(false), DEBUG_ONLY(_frame_index(-1) COMMA) _unextended_sp(nullptr), _fp(nullptr) {}
 
-inline frame::frame(intptr_t* sp) : _sp(sp), _on_heap(false),
-#ifdef ASSERT
-                        _frame_index(-1),
-#endif
-                        _unextended_sp(sp) {
-  find_codeblob_and_set_pc_and_deopt_state((address)own_abi()->lr); // also sets _fp and adjusts _unextended_sp
+inline frame::frame(intptr_t* sp)
+  : _sp(sp), _pc((address)own_abi()->lr), _cb(nullptr), _oop_map(nullptr),
+    _on_heap(false), DEBUG_ONLY(_frame_index(-1) COMMA) _unextended_sp(sp), _fp(nullptr) {
+  setup();
 }
 
-inline frame::frame(intptr_t* sp, address pc) : _sp(sp), _on_heap(false),
-#ifdef ASSERT
-                         _frame_index(-1),
-#endif
-                        _unextended_sp(sp) {
-  find_codeblob_and_set_pc_and_deopt_state(pc); // also sets _fp and adjusts _unextended_sp
+inline frame::frame(intptr_t* sp, address pc)
+  : _sp(sp), _pc(pc), _cb(nullptr), _oop_map(nullptr),
+    _on_heap(false), DEBUG_ONLY(_frame_index(-1) COMMA) _unextended_sp(sp), _fp(nullptr) {
+  setup();
 }
 
-inline frame::frame(intptr_t* sp, address pc, intptr_t* unextended_sp) : _sp(sp), _on_heap(false),
-#ifdef ASSERT
-                    _frame_index(-1),
-#endif
-                    _unextended_sp(unextended_sp) {
-  find_codeblob_and_set_pc_and_deopt_state(pc); // also sets _fp and adjusts _unextended_sp
+inline frame::frame(intptr_t* sp, address pc, intptr_t* unextended_sp, intptr_t* fp, CodeBlob* cb)
+  : _sp(sp), _pc(pc), _cb(nullptr), _oop_map(nullptr),
+    _on_heap(false), DEBUG_ONLY(_frame_index(-1) COMMA) _unextended_sp(unextended_sp), _fp(fp) {
+  setup();
 }
 
 // Accessors
@@ -233,7 +238,16 @@ inline void frame::set_saved_oop_result(RegisterMap* map, oop obj) {
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
 