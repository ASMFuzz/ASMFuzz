@@ -325,11 +325,11 @@ class NativeJump: public NativeInstruction {
   }
 
   // MT-safe insertion of native jump at verified method entry
-  static void patch_verified_entry(address entry, address verified_entry, address dest);
+  static void patch_verified_entry(address verified_entry, address dest);
 
   void verify() NOT_DEBUG_RETURN;
 
-  static void check_verified_entry_alignment(address entry, address verified_entry) {
+  static void check_verified_entry_alignment(address verified_entry) {
     // We just patch one instruction on ppc64, so the jump doesn't have to
     // be aligned. Nothing to do here.
   }