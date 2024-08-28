@@ -474,7 +474,7 @@ void NativeJump::insert(address code_pos, address entry) {
   ICache::invalidate_range(code_pos, instruction_size);
 }
 
-void NativeJump::check_verified_entry_alignment(address entry, address verified_entry) {
+void NativeJump::check_verified_entry_alignment(address verified_entry) {
   // Patching to not_entrant can happen while activations of the method are
   // in use. The patching in that instance must happen only when certain
   // alignment restrictions are true. These guarantees check those
@@ -508,7 +508,7 @@ void NativeJump::check_verified_entry_alignment(address entry, address verified_
 // In C1 the restriction is enforced by CodeEmitter::method_entry
 // In JVMCI, the restriction is enforced by HotSpotFrameContext.enter(...)
 //
-void NativeJump::patch_verified_entry(address entry, address verified_entry, address dest) {
+void NativeJump::patch_verified_entry(address verified_entry, address dest) {
   // complete jump instruction (to be inserted) is in code_buffer;
   unsigned char code_buffer[5];
   code_buffer[0] = instruction_code;
@@ -518,7 +518,7 @@ void NativeJump::patch_verified_entry(address entry, address verified_entry, add
 #endif // AMD64
   *(int32_t*)(code_buffer + 1) = (int32_t)disp;
 
-  check_verified_entry_alignment(entry, verified_entry);
+  check_verified_entry_alignment(verified_entry);
 
   // Can't call nativeJump_at() because it's asserts jump exists
   NativeJump* n_jump = (NativeJump*) verified_entry;