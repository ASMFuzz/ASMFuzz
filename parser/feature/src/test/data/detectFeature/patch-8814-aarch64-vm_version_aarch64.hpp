@@ -31,6 +31,7 @@
 #include "utilities/sizes.hpp"
 
 class VM_Version : public Abstract_VM_Version {
+  friend class VMStructs;
   friend class JVMCIVMStructs;
 
 protected:
@@ -46,6 +47,7 @@ class VM_Version : public Abstract_VM_Version {
   static int _icache_line_size;
   static int _initial_sve_vector_length;
   static bool _rop_protection;
+  static uintptr_t _pac_mask;
 
   static SpinWait _spin_wait;
 