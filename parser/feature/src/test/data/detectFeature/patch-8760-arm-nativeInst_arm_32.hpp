@@ -271,9 +271,9 @@ class RawNativeJump: public NativeInstruction {
     }
   }
 
-  static void check_verified_entry_alignment(address entry, address verified_entry);
+  static void check_verified_entry_alignment(address verified_entry);
 
-  static void patch_verified_entry(address entry, address verified_entry, address dest);
+  static void patch_verified_entry(address verified_entry, address dest);
 
 };
 