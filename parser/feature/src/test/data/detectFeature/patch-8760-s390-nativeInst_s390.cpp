@@ -622,7 +622,7 @@ void NativeJump::verify() {
 }
 
 // Patch atomically with an illtrap.
-void NativeJump::patch_verified_entry(address entry, address verified_entry, address dest) {
+void NativeJump::patch_verified_entry(address verified_entry, address dest) {
   ResourceMark rm;
   int code_size = 2;
   CodeBuffer cb(verified_entry, code_size + 1);