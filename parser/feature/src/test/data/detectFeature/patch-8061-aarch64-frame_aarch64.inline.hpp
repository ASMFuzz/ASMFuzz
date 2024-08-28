@@ -46,7 +46,7 @@ inline frame::frame() {
 
 static int spin;
 
-inline void frame::init(intptr_t* sp, intptr_t* fp, address pc) {
+inline void frame::init(intptr_t* sp, intptr_t* fp, address pc, bool forSignalHandler) {
   assert(pauth_ptr_is_raw(pc), "cannot be signed");
   intptr_t a = intptr_t(sp);
   intptr_t b = intptr_t(fp);
@@ -55,7 +55,7 @@ inline void frame::init(intptr_t* sp, intptr_t* fp, address pc) {
   _fp = fp;
   _pc = pc;
   assert(pc != NULL, "no pc?");
-  _cb = CodeCache::find_blob(pc);
+  _cb = CodeCache::find_blob(pc, forSignalHandler);
   adjust_unextended_sp();
 
   address original_pc = CompiledMethod::get_deopt_original_pc(this);
@@ -68,8 +68,8 @@ inline void frame::init(intptr_t* sp, intptr_t* fp, address pc) {
   _sp_is_trusted = false;
 }
 
-inline frame::frame(intptr_t* sp, intptr_t* fp, address pc) {
-  init(sp, fp, pc);
+inline frame::frame(intptr_t* sp, intptr_t* fp, address pc, bool forSignalHandler) {
+  init(sp, fp, pc, forSignalHandler);
 }
 
 inline frame::frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc) {