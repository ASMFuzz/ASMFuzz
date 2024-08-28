@@ -456,8 +456,8 @@ class NativeJump: public NativeInstruction {
   // Insertion of native jump instruction
   static void insert(address code_pos, address entry);
   // MT-safe insertion of native jump at verified method entry
-  static void check_verified_entry_alignment(address entry, address verified_entry);
-  static void patch_verified_entry(address entry, address verified_entry, address dest);
+  static void check_verified_entry_alignment(address verified_entry);
+  static void patch_verified_entry(address verified_entry, address dest);
 };
 
 inline NativeJump* nativeJump_at(address address) {