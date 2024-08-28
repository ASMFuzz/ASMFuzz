@@ -434,33 +434,40 @@ inline NativeCall* nativeCall_before(address return_address) {
 
 class NativePostCallNop: public NativeInstruction {
 public:
-  bool check() const { Unimplemented(); return false; }
-  int displacement() const { Unimplemented(); return 0; }
-  void patch(jint diff) { Unimplemented(); }
-  void make_deopt() { Unimplemented(); }
+  bool check() const { return is_nop(); }
+  int displacement() const { return 0; }
+  void patch(jint diff);
+  void make_deopt();
 };
 
 inline NativePostCallNop* nativePostCallNop_at(address address) {
-  Unimplemented();
+  NativePostCallNop* nop = (NativePostCallNop*) address;
+  if (nop->check()) {
+    return nop;
+  }
   return NULL;
 }
 
 class NativeDeoptInstruction: public NativeInstruction {
 public:
-  address instruction_address() const       { Unimplemented(); return NULL; }
-  address next_instruction_address() const  { Unimplemented(); return NULL; }
+  enum {
+    instruction_size            =    4,
+    instruction_offset          =    0,
+  };
 
-  void  verify() { Unimplemented(); }
+  address instruction_address() const       { return addr_at(instruction_offset); }
+  address next_instruction_address() const  { return addr_at(instruction_size); }
+
+  void  verify();
 
   static bool is_deopt_at(address instr) {
-    Unimplemented();
-    return false;
+    assert(instr != NULL, "");
+    uint32_t value = *(uint32_t *) instr;
+    return value == 0xe7fdecfa;
   }
 
   // MT-safe patching
-  static void insert(address code_pos) {
-    Unimplemented();
-  }
+  static void insert(address code_pos);
 };
 
 #endif // CPU_ARM_NATIVEINST_ARM_32_HPP