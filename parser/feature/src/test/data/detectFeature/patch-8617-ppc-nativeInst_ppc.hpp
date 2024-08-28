@@ -506,13 +506,13 @@ class NativeMovRegMem: public NativeInstruction {
 class NativePostCallNop: public NativeInstruction {
 public:
   bool check() const { Unimplemented(); return false; }
-  int displacement() const { Unimplemented(); return 0; }
+  int displacement() const { return 0; }
   void patch(jint diff) { Unimplemented(); }
   void make_deopt() { Unimplemented(); }
 };
 
 inline NativePostCallNop* nativePostCallNop_at(address address) {
-  Unimplemented();
+  // Unimplemented();
   return NULL;
 }
 
@@ -524,7 +524,7 @@ class NativeDeoptInstruction: public NativeInstruction {
   void  verify() { Unimplemented(); }
 
   static bool is_deopt_at(address instr) {
-    Unimplemented();
+    // Unimplemented();
     return false;
   }
 