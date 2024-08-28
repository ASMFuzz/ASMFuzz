@@ -29,6 +29,7 @@
 
 #include "code/codeCache.hpp"
 #include "code/vmreg.inline.hpp"
+#include "runtime/sharedRuntime.hpp"
 
 // Inline functions for RISCV frames:
 
@@ -54,20 +55,31 @@ inline void frame::init(intptr_t* ptr_sp, intptr_t* ptr_fp, address pc) {
   _unextended_sp = ptr_sp;
   _fp = ptr_fp;
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
+           "original PC must be in the main code section of the compiled method (or must be immediately following it)");
   } else {
-    _deopt_state = not_deoptimized;
+    if (_cb == SharedRuntime::deopt_blob()) {
+      _deopt_state = is_deoptimized;
+    } else {
+      _deopt_state = not_deoptimized;
+    }
   }
-
-  _on_heap = false;
-  DEBUG_ONLY(_frame_index = -1;)
 }
 
 inline frame::frame(intptr_t* ptr_sp, intptr_t* ptr_fp, address pc) {
@@ -83,20 +95,11 @@ inline frame::frame(intptr_t* ptr_sp, intptr_t* unextended_sp, intptr_t* ptr_fp,
   _pc = pc;
   assert(pc != NULL, "no pc?");
   _cb = CodeCache::find_blob(pc);
-  adjust_unextended_sp();
-
-  address original_pc = CompiledMethod::get_deopt_original_pc(this);
-  if (original_pc != NULL) {
-    _pc = original_pc;
-    assert(_cb->as_compiled_method()->insts_contains_inclusive(_pc),
-           "original PC must be in the main code section of the the compiled method (or must be immediately following it)");
-    _deopt_state = is_deoptimized;
-  } else {
-    _deopt_state = not_deoptimized;
-  }
-
+  _oop_map = NULL;
   _on_heap = false;
   DEBUG_ONLY(_frame_index = -1;)
+
+  setup(pc);
 }
 
 inline frame::frame(intptr_t* ptr_sp) {
@@ -293,7 +296,11 @@ inline void frame::set_saved_oop_result(RegisterMap* map, oop obj) {
 PRAGMA_DIAG_POP
 
 inline const ImmutableOopMap* frame::get_oop_map() const {
-  Unimplemented();
+  if (_cb == NULL) return NULL;
+  if (_cb->oop_maps() != NULL) {
+    const ImmutableOopMap* oop_map = OopMapSet::find_map(this);
+    return oop_map;
+  }
   return NULL;
 }
 