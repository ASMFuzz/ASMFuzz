@@ -33,10 +33,10 @@
 // Inline functions for ppc64 frames:
 
 // Find codeblob and set deopt_state.
-inline void frame::find_codeblob_and_set_pc_and_deopt_state(address pc) {
+inline void frame::find_codeblob_and_set_pc_and_deopt_state(address pc, bool forSignalHandler) {
   assert(pc != NULL, "precondition: must have PC");
 
-  _cb = CodeCache::find_blob(pc);
+  _cb = CodeCache::find_blob(pc, forSignalHandler);
   _pc = pc;   // Must be set for get_deopt_original_pc()
 
   _fp = (intptr_t*)own_abi()->callers_sp;
@@ -61,8 +61,8 @@ inline frame::frame(intptr_t* sp) : _sp(sp), _unextended_sp(sp) {
   find_codeblob_and_set_pc_and_deopt_state((address)own_abi()->lr); // also sets _fp and adjusts _unextended_sp
 }
 
-inline frame::frame(intptr_t* sp, address pc) : _sp(sp), _unextended_sp(sp) {
-  find_codeblob_and_set_pc_and_deopt_state(pc); // also sets _fp and adjusts _unextended_sp
+inline frame::frame(intptr_t* sp, address pc, bool forSignalHandler) : _sp(sp), _unextended_sp(sp) {
+  find_codeblob_and_set_pc_and_deopt_state(pc, forSignalHandler); // also sets _fp and adjusts _unextended_sp
 }
 
 inline frame::frame(intptr_t* sp, address pc, intptr_t* unextended_sp) : _sp(sp), _unextended_sp(unextended_sp) {