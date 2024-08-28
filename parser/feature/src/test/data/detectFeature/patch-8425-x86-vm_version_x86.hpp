@@ -370,10 +370,11 @@ class VM_Version : public Abstract_VM_Version {
     decl(AVX512_VBMI,       "avx512_vbmi",       45) /* Vector BMI instructions */ \
     decl(HV,                "hv",                46) /* Hypervisor instructions */ \
     decl(SERIALIZE,         "serialize",         47) /* CPU SERIALIZE */ \
-                                                     \
     decl(RDTSCP,            "rdtscp",            48) /* RDTSCP instruction */ \
     decl(RDPID,             "rdpid",             49) /* RDPID instruction */ \
-    decl(FSRM,              "fsrm",              50) /* Fast Short REP MOV */
+    decl(FSRM,              "fsrm",              50) /* Fast Short REP MOV */ \
+    decl(GFNI,              "gfni",              51) /* Vector GFNI instructions */ \
+    decl(AVX512_BITALG,     "avx512_bitalg",     52) /* Vector sub-word popcount and bit gather instructions */
 
 #define DECLARE_CPU_FEATURE_FLAG(id, name, bit) CPU_##id = (1ULL << bit),
     CPU_FEATURE_FLAGS(DECLARE_CPU_FEATURE_FLAG)
@@ -603,8 +604,12 @@ class VM_Version : public Abstract_VM_Version {
           result |= CPU_AVX512_VPCLMULQDQ;
         if (_cpuid_info.sef_cpuid7_ecx.bits.vaes != 0)
           result |= CPU_AVX512_VAES;
+        if (_cpuid_info.sef_cpuid7_ecx.bits.gfni != 0)
+          result |= CPU_GFNI;
         if (_cpuid_info.sef_cpuid7_ecx.bits.avx512_vnni != 0)
           result |= CPU_AVX512_VNNI;
+        if (_cpuid_info.sef_cpuid7_ecx.bits.avx512_bitalg != 0)
+          result |= CPU_AVX512_BITALG;
         if (_cpuid_info.sef_cpuid7_ecx.bits.avx512_vbmi != 0)
           result |= CPU_AVX512_VBMI;
         if (_cpuid_info.sef_cpuid7_ecx.bits.avx512_vbmi2 != 0)
@@ -918,7 +923,9 @@ class VM_Version : public Abstract_VM_Version {
   static bool supports_avx512_vpopcntdq()  { return (_features & CPU_AVX512_VPOPCNTDQ) != 0; }
   static bool supports_avx512_vpclmulqdq() { return (_features & CPU_AVX512_VPCLMULQDQ) != 0; }
   static bool supports_avx512_vaes()  { return (_features & CPU_AVX512_VAES) != 0; }
+  static bool supports_gfni()         { return (_features & CPU_GFNI) != 0; }
   static bool supports_avx512_vnni()  { return (_features & CPU_AVX512_VNNI) != 0; }
+  static bool supports_avx512_bitalg()  { return (_features & CPU_AVX512_BITALG) != 0; }
   static bool supports_avx512_vbmi()  { return (_features & CPU_AVX512_VBMI) != 0; }
   static bool supports_avx512_vbmi2() { return (_features & CPU_AVX512_VBMI2) != 0; }
   static bool supports_hv()           { return (_features & CPU_HV) != 0; }