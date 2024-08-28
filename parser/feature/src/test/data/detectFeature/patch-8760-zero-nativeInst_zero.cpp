@@ -35,8 +35,7 @@
 // (dest) at the start of a compiled method (verified_entry) to avoid
 // a race where a method is invoked while being made non-entrant.
 
-void NativeJump::patch_verified_entry(address entry,
-                                      address verified_entry,
+void NativeJump::patch_verified_entry(address verified_entry,
                                       address dest) {
   assert(dest == SharedRuntime::get_handle_wrong_method_stub(), "should be");
 