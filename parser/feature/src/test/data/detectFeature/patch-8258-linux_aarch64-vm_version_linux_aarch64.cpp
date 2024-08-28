@@ -80,19 +80,23 @@
 #define HWCAP2_SVE2 (1 << 1)
 #endif
 
+#ifndef HWCAP2_SVEBITPERM
+#define HWCAP2_SVEBITPERM (1 << 4)
+#endif
+
 #ifndef PR_SVE_GET_VL
 // For old toolchains which do not have SVE related macros defined.
 #define PR_SVE_SET_VL   50
 #define PR_SVE_GET_VL   51
 #endif
 
 int VM_Version::get_current_sve_vector_length() {
-  assert(_features & CPU_SVE, "should not call this");
+  assert(VM_Version::supports_sve(), "should not call this");
   return prctl(PR_SVE_GET_VL);
 }
 
 int VM_Version::set_and_get_current_sve_vector_length(int length) {
-  assert(_features & CPU_SVE, "should not call this");
+  assert(VM_Version::supports_sve(), "should not call this");
   int new_length = prctl(PR_SVE_SET_VL, length);
   return new_length;
 }
@@ -133,6 +137,7 @@ void VM_Version::get_os_cpu_info() {
       HWCAP_PACA);
 
   if (auxv2 & HWCAP2_SVE2) _features |= CPU_SVE2;
+  if (auxv2 & HWCAP2_SVEBITPERM) _features |= CPU_SVEBITPERM;
 
   uint64_t ctr_el0;
   uint64_t dczid_el0;