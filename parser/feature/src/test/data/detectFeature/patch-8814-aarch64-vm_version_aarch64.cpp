@@ -24,6 +24,7 @@
  */
 
 #include "precompiled.hpp"
+#include "pauth_aarch64.hpp"
 #include "runtime/arguments.hpp"
 #include "runtime/globals_extension.hpp"
 #include "runtime/java.hpp"
@@ -46,6 +47,7 @@ int VM_Version::_dcache_line_size;
 int VM_Version::_icache_line_size;
 int VM_Version::_initial_sve_vector_length;
 bool VM_Version::_rop_protection;
+uintptr_t VM_Version::_pac_mask;
 
 SpinWait VM_Version::_spin_wait;
 
@@ -444,8 +446,12 @@ void VM_Version::initialize() {
     vm_exit_during_initialization(err_msg("Unsupported UseBranchProtection: %s", UseBranchProtection));
   }
 
-  // The frame pointer must be preserved for ROP protection.
   if (_rop_protection == true) {
+    // Determine the mask of address bits used for PAC. Clear bit 55 of
+    // the input to make it look like a user address.
+    _pac_mask = (uintptr_t)pauth_strip_pointer((address)~(UINT64_C(1) << 55));
+
+    // The frame pointer must be preserved for ROP protection.
     if (FLAG_IS_DEFAULT(PreserveFramePointer) == false && PreserveFramePointer == false ) {
       vm_exit_during_initialization(err_msg("PreserveFramePointer cannot be disabled for ROP-protection"));
     }