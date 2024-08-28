@@ -330,7 +330,7 @@ void NativeMovConstReg::verify() {
 }
 #endif // ASSERT
 
-void NativeJump::patch_verified_entry(address entry, address verified_entry, address dest) {
+void NativeJump::patch_verified_entry(address verified_entry, address dest) {
   ResourceMark rm;
   int code_size = 1 * BytesPerInstWord;
   CodeBuffer cb(verified_entry, code_size + 1);