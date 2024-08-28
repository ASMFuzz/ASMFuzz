@@ -100,32 +100,39 @@ class VM_Version : public Abstract_VM_Version {
     CPU_APPLE     = 'a',
   };
 
-  enum Feature_Flag {
 #define CPU_FEATURE_FLAGS(decl)               \
-    decl(FP,            "fp",            0)   \
-    decl(ASIMD,         "simd",          1)   \
-    decl(EVTSTRM,       "evtstrm",       2)   \
-    decl(AES,           "aes",           3)   \
-    decl(PMULL,         "pmull",         4)   \
-    decl(SHA1,          "sha1",          5)   \
-    decl(SHA2,          "sha256",        6)   \
-    decl(CRC32,         "crc",           7)   \
-    decl(LSE,           "lse",           8)   \
-    decl(DCPOP,         "dcpop",         16)  \
-    decl(SHA3,          "sha3",          17)  \
-    decl(SHA512,        "sha512",        21)  \
-    decl(SVE,           "sve",           22)  \
-    decl(PACA,          "paca",          30)  \
+    decl(FP,            fp,            0)     \
+    decl(ASIMD,         simd,          1)     \
+    decl(EVTSTRM,       evtstrm,       2)     \
+    decl(AES,           aes,           3)     \
+    decl(PMULL,         pmull,         4)     \
+    decl(SHA1,          sha1,          5)     \
+    decl(SHA2,          sha2,          6)     \
+    decl(CRC32,         crc32,         7)     \
+    decl(LSE,           lse,           8)     \
+    decl(DCPOP,         dcpop,         16)    \
+    decl(SHA3,          sha3,          17)    \
+    decl(SHA512,        sha512,        21)    \
+    decl(SVE,           sve,           22)    \
+    decl(PACA,          paca,          30)    \
     /* flags above must follow Linux HWCAP */ \
-    decl(SVE2,          "sve2",          28)  \
-    decl(STXR_PREFETCH, "stxr_prefetch", 29)  \
-    decl(A53MAC,        "a53mac",        31)
+    decl(SVEBITPERM,    svebitperm,    27)    \
+    decl(SVE2,          sve2,          28)    \
+    decl(STXR_PREFETCH, stxr_prefetch, 29)    \
+    decl(A53MAC,        a53mac,        31)
 
+  enum Feature_Flag {
 #define DECLARE_CPU_FEATURE_FLAG(id, name, bit) CPU_##id = (1 << bit),
     CPU_FEATURE_FLAGS(DECLARE_CPU_FEATURE_FLAG)
 #undef DECLARE_CPU_FEATURE_FLAG
   };
 
+  // Feature identification
+#define CPU_FEATURE_DETECTION(id, name, bit) \
+  static bool supports_##name() { return (_features & CPU_##id) != 0; };
+  CPU_FEATURE_FLAGS(CPU_FEATURE_DETECTION)
+#undef CPU_FEATURE_DETECTION
+
   static int cpu_family()                     { return _cpu; }
   static int cpu_model()                      { return _model; }
   static int cpu_model2()                     { return _model2; }