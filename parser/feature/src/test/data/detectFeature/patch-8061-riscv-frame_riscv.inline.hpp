@@ -45,15 +45,15 @@ inline frame::frame() {
 
 static int spin;
 
-inline void frame::init(intptr_t* ptr_sp, intptr_t* ptr_fp, address pc) {
+inline void frame::init(intptr_t* ptr_sp, intptr_t* ptr_fp, address pc, bool forSignalHandler) {
   intptr_t a = intptr_t(ptr_sp);
   intptr_t b = intptr_t(ptr_fp);
   _sp = ptr_sp;
   _unextended_sp = ptr_sp;
   _fp = ptr_fp;
   _pc = pc;
   assert(pc != NULL, "no pc?");
-  _cb = CodeCache::find_blob(pc);
+  _cb = CodeCache::find_blob(pc, forSignalHandler);
   adjust_unextended_sp();
 
   address original_pc = CompiledMethod::get_deopt_original_pc(this);
@@ -65,8 +65,8 @@ inline void frame::init(intptr_t* ptr_sp, intptr_t* ptr_fp, address pc) {
   }
 }
 
-inline frame::frame(intptr_t* ptr_sp, intptr_t* ptr_fp, address pc) {
-  init(ptr_sp, ptr_fp, pc);
+inline frame::frame(intptr_t* ptr_sp, intptr_t* ptr_fp, address pc, bool forSignalHandler) {
+  init(ptr_sp, ptr_fp, pc, forSignalHandler);
 }
 
 inline frame::frame(intptr_t* ptr_sp, intptr_t* unextended_sp, intptr_t* ptr_fp, address pc) {