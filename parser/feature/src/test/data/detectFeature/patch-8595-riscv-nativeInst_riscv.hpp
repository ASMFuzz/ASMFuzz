@@ -28,6 +28,7 @@
 #define CPU_RISCV_NATIVEINST_RISCV_HPP
 
 #include "asm/assembler.hpp"
+#include "runtime/continuation.hpp"
 #include "runtime/icache.hpp"
 #include "runtime/os.hpp"
 
@@ -195,7 +196,7 @@ class NativeInstruction {
   }
   static bool is_lwu_to_zr(address instr);
 
-  inline bool is_nop();
+  inline bool is_nop() const;
   inline bool is_jump_or_nop();
   bool is_safepoint_poll();
   bool is_sigill_zombie_not_entrant();
@@ -494,7 +495,7 @@ class NativeIllegalInstruction: public NativeInstruction {
   static void insert(address code_pos);
 };
 
-inline bool NativeInstruction::is_nop()         {
+inline bool NativeInstruction::is_nop() const {
   uint32_t insn = *(uint32_t*)addr_at(0);
   return insn == 0x13;
 }
@@ -571,14 +572,17 @@ class NativeFenceI : public NativeInstruction {
 
 class NativePostCallNop: public NativeInstruction {
 public:
-  bool check() const { Unimplemented(); return false; }
-  int displacement() const { Unimplemented(); return 0; }
+  bool check() const { return is_nop(); }
+  int displacement() const { return 0; }
   void patch(jint diff) { Unimplemented(); }
   void make_deopt() { Unimplemented(); }
 };
 
 inline NativePostCallNop* nativePostCallNop_at(address address) {
-  Unimplemented();
+  NativePostCallNop* nop = (NativePostCallNop*) address;
+  if (nop->check()) {
+    return nop;
+  }
   return NULL;
 }
 
@@ -590,6 +594,7 @@ class NativeDeoptInstruction: public NativeInstruction {
   void  verify() { Unimplemented(); }
 
   static bool is_deopt_at(address instr) {
+    if (!Continuations::enabled()) return false;
     Unimplemented();
     return false;
   }