@@ -321,12 +321,26 @@ class MacroAssembler: public Assembler {
   Address argument_address(RegisterOrConstant arg_slot, int extra_slot_offset = 0);
 
   // only if +VerifyOops
-  void verify_oop(Register reg, const char* s = "broken oop");
-  void verify_oop_addr(Address addr, const char* s = "broken oop addr");
+  void _verify_oop(Register reg, const char* s, const char* file, int line);
+  void _verify_oop_addr(Address addr, const char* s, const char* file, int line);
+
+  void _verify_oop_checked(Register reg, const char* s, const char* file, int line) {
+    if (VerifyOops) {
+      _verify_oop(reg, s, file, line);
+    }
+  }
+  void _verify_oop_addr_checked(Address reg, const char* s, const char* file, int line) {
+    if (VerifyOops) {
+      _verify_oop_addr(reg, s, file, line);
+    }
+  }
 
   void _verify_method_ptr(Register reg, const char* msg, const char* file, int line) {}
   void _verify_klass_ptr(Register reg, const char* msg, const char* file, int line) {}
 
+#define verify_oop(reg) _verify_oop_checked(reg, "broken oop " #reg, __FILE__, __LINE__)
+#define verify_oop_msg(reg, msg) _verify_oop_checked(reg, "broken oop " #reg ", " #msg, __FILE__, __LINE__)
+#define verify_oop_addr(addr) _verify_oop_addr_checked(addr, "broken oop addr " #addr, __FILE__, __LINE__)
 #define verify_method_ptr(reg) _verify_method_ptr(reg, "broken method " #reg, __FILE__, __LINE__)
 #define verify_klass_ptr(reg) _verify_method_ptr(reg, "broken klass " #reg, __FILE__, __LINE__)
 