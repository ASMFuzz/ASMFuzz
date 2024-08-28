@@ -284,10 +284,10 @@ void NativeMovConstReg::set_pc_relative_offset(address addr, address pc) {
   }
 }
 
-void RawNativeJump::check_verified_entry_alignment(address entry, address verified_entry) {
+void RawNativeJump::check_verified_entry_alignment(address verified_entry) {
 }
 
-void RawNativeJump::patch_verified_entry(address entry, address verified_entry, address dest) {
+void RawNativeJump::patch_verified_entry(address verified_entry, address dest) {
   assert(dest == SharedRuntime::get_handle_wrong_method_stub(), "should be");
   int *a = (int *)verified_entry;
   a[0] = zombie_illegal_instruction; // always illegal