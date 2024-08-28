@@ -41,13 +41,13 @@ inline frame::frame() {
   _deopt_state = unknown;
 }
 
-inline void frame::init(intptr_t* sp, intptr_t* fp, address pc) {
+inline void frame::init(intptr_t* sp, intptr_t* fp, address pc, bool forSignalHandler) {
   _sp = sp;
   _unextended_sp = sp;
   _fp = fp;
   _pc = pc;
   assert(pc != NULL, "no pc?");
-  _cb = CodeCache::find_blob(pc);
+  _cb = CodeCache::find_blob(pc, forSignalHandler);
   adjust_unextended_sp();
 
   address original_pc = CompiledMethod::get_deopt_original_pc(this);
@@ -59,8 +59,8 @@ inline void frame::init(intptr_t* sp, intptr_t* fp, address pc) {
   }
 }
 
-inline frame::frame(intptr_t* sp, intptr_t* fp, address pc) {
-  init(sp, fp, pc);
+inline frame::frame(intptr_t* sp, intptr_t* fp, address pc, bool forSignalHandler) {
+  init(sp, fp, pc, forSignalHandler);
 }
 
 inline frame::frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc) {