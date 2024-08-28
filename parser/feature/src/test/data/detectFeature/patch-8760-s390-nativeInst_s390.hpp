@@ -610,9 +610,9 @@ class NativeJump: public NativeInstruction {
   static void insert(address code_pos, address entry);
 
   // MT-safe insertion of native jump at verified method entry.
-  static void check_verified_entry_alignment(address entry, address verified_entry) { }
+  static void check_verified_entry_alignment(address verified_entry) { }
 
-  static void patch_verified_entry(address entry, address verified_entry, address dest);
+  static void patch_verified_entry(address verified_entry, address dest);
 };
 
 //-------------------------------------