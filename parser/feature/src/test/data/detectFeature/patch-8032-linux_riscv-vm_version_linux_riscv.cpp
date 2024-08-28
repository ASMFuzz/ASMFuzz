@@ -60,10 +60,6 @@
 #define HWCAP_ISA_V  (1 << ('V' - 'A'))
 #endif
 
-#ifndef HWCAP_ISA_B
-#define HWCAP_ISA_B  (1 << ('B' - 'A'))
-#endif
-
 #define read_csr(csr)                                           \
 ({                                                              \
         register unsigned long __v;                             \
@@ -90,16 +86,18 @@ void VM_Version::get_os_cpu_info() {
   static_assert(CPU_D == HWCAP_ISA_D, "Flag CPU_D must follow Linux HWCAP");
   static_assert(CPU_C == HWCAP_ISA_C, "Flag CPU_C must follow Linux HWCAP");
   static_assert(CPU_V == HWCAP_ISA_V, "Flag CPU_V must follow Linux HWCAP");
-  static_assert(CPU_B == HWCAP_ISA_B, "Flag CPU_B must follow Linux HWCAP");
+
+  // RISC-V has four bit-manipulation ISA-extensions: Zba/Zbb/Zbc/Zbs.
+  // Availability for those extensions could not be queried from HWCAP.
+  // TODO: Add proper detection for those extensions.
   _features = auxv & (
       HWCAP_ISA_I |
       HWCAP_ISA_M |
       HWCAP_ISA_A |
       HWCAP_ISA_F |
       HWCAP_ISA_D |
       HWCAP_ISA_C |
-      HWCAP_ISA_V |
-      HWCAP_ISA_B);
+      HWCAP_ISA_V);
 
   if (FILE *f = fopen("/proc/cpuinfo", "r")) {
     char buf[512], *p;