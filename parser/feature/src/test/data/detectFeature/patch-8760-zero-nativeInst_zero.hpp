@@ -176,12 +176,10 @@ class NativeJump : public NativeInstruction {
     ShouldNotCallThis();
   }
 
-  static void check_verified_entry_alignment(address entry,
-                                             address verified_entry) {
+  static void check_verified_entry_alignment(address verified_entry) {
   }
 
-  static void patch_verified_entry(address entry,
-                                   address verified_entry,
+  static void patch_verified_entry(address verified_entry,
                                    address dest);
 };
 