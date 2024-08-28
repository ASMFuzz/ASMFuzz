@@ -264,7 +264,7 @@ void NativeMovRegMem::verify() {
 void NativeJump::verify() { }
 
 
-void NativeJump::check_verified_entry_alignment(address entry, address verified_entry) {
+void NativeJump::check_verified_entry_alignment(address verified_entry) {
 }
 
 
@@ -347,7 +347,7 @@ bool NativeInstruction::is_stop() {
 // MT-safe inserting of a jump over a jump or a nop (used by
 // nmethod::make_not_entrant_or_zombie)
 
-void NativeJump::patch_verified_entry(address entry, address verified_entry, address dest) {
+void NativeJump::patch_verified_entry(address verified_entry, address dest) {
 
   assert(dest == SharedRuntime::get_handle_wrong_method_stub(), "expected fixed destination of patch");
 