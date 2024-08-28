@@ -32,10 +32,10 @@
 
 // Inline functions for z/Architecture frames:
 
-inline void frame::find_codeblob_and_set_pc_and_deopt_state(address pc) {
+inline void frame::find_codeblob_and_set_pc_and_deopt_state(address pc, bool forSignalHandler) {
   assert(pc != NULL, "precondition: must have PC");
 
-  _cb = CodeCache::find_blob(pc);
+  _cb = CodeCache::find_blob(pc, forSignalHandler);
   _pc = pc;   // Must be set for get_deopt_original_pc().
 
   _fp = (intptr_t *) own_abi()->callers_sp;
@@ -60,8 +60,8 @@ inline frame::frame(intptr_t* sp) : _sp(sp), _unextended_sp(sp) {
   find_codeblob_and_set_pc_and_deopt_state((address)own_abi()->return_pc);
 }
 
-inline frame::frame(intptr_t* sp, address pc) : _sp(sp), _unextended_sp(sp) {
-  find_codeblob_and_set_pc_and_deopt_state(pc); // Also sets _fp and adjusts _unextended_sp.
+inline frame::frame(intptr_t* sp, address pc, bool forSignalHandler) : _sp(sp), _unextended_sp(sp) {
+  find_codeblob_and_set_pc_and_deopt_state(pc, forSignalHandler); // Also sets _fp and adjusts _unextended_sp.
 }
 
 inline frame::frame(intptr_t* sp, address pc, intptr_t* unextended_sp) : _sp(sp), _unextended_sp(unextended_sp) {