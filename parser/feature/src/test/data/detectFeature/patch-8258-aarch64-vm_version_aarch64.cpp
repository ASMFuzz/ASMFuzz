@@ -124,7 +124,7 @@ void VM_Version::initialize() {
     // if dcpop is available publish data cache line flush size via
     // generic field, otherwise let if default to zero thereby
     // disabling writeback
-    if (_features & CPU_DCPOP) {
+    if (VM_Version::supports_dcpop()) {
       _data_cache_line_flush_size = dcache_line;
     }
   }
@@ -226,17 +226,17 @@ void VM_Version::initialize() {
   char buf[512];
   sprintf(buf, "0x%02x:0x%x:0x%03x:%d", _cpu, _variant, _model, _revision);
   if (_model2) sprintf(buf+strlen(buf), "(0x%03x)", _model2);
-#define ADD_FEATURE_IF_SUPPORTED(id, name, bit) if (_features & CPU_##id) strcat(buf, ", " name);
+#define ADD_FEATURE_IF_SUPPORTED(id, name, bit) if (VM_Version::supports_##name()) strcat(buf, ", " #name);
   CPU_FEATURE_FLAGS(ADD_FEATURE_IF_SUPPORTED)
 #undef ADD_FEATURE_IF_SUPPORTED
 
   _features_string = os::strdup(buf);
 
   if (FLAG_IS_DEFAULT(UseCRC32)) {
-    UseCRC32 = (_features & CPU_CRC32) != 0;
+    UseCRC32 = VM_Version::supports_crc32();
   }
 
-  if (UseCRC32 && (_features & CPU_CRC32) == 0) {
+  if (UseCRC32 && !VM_Version::supports_crc32()) {
     warning("UseCRC32 specified, but not supported on this CPU");
     FLAG_SET_DEFAULT(UseCRC32, false);
   }
@@ -250,7 +250,7 @@ void VM_Version::initialize() {
     FLAG_SET_DEFAULT(UseVectorizedMismatchIntrinsic, false);
   }
 
-  if (_features & CPU_LSE) {
+  if (VM_Version::supports_lse()) {
     if (FLAG_IS_DEFAULT(UseLSE))
       FLAG_SET_DEFAULT(UseLSE, true);
   } else {
@@ -260,7 +260,7 @@ void VM_Version::initialize() {
     }
   }
 
-  if (_features & CPU_AES) {
+  if (VM_Version::supports_aes()) {
     UseAES = UseAES || FLAG_IS_DEFAULT(UseAES);
     UseAESIntrinsics =
         UseAESIntrinsics || (UseAES && FLAG_IS_DEFAULT(UseAESIntrinsics));
@@ -291,7 +291,7 @@ void VM_Version::initialize() {
     UseCRC32Intrinsics = true;
   }
 
-  if (_features & CPU_CRC32) {
+  if (VM_Version::supports_crc32()) {
     if (FLAG_IS_DEFAULT(UseCRC32CIntrinsics)) {
       FLAG_SET_DEFAULT(UseCRC32CIntrinsics, true);
     }
@@ -308,7 +308,8 @@ void VM_Version::initialize() {
     UseMD5Intrinsics = true;
   }
 
-  if (_features & (CPU_SHA1 | CPU_SHA2 | CPU_SHA3 | CPU_SHA512)) {
+  if (VM_Version::supports_sha1() || VM_Version::supports_sha2() ||
+      VM_Version::supports_sha3() || VM_Version::supports_sha512()) {
     if (FLAG_IS_DEFAULT(UseSHA)) {
       FLAG_SET_DEFAULT(UseSHA, true);
     }
@@ -317,7 +318,7 @@ void VM_Version::initialize() {
     FLAG_SET_DEFAULT(UseSHA, false);
   }
 
-  if (UseSHA && (_features & CPU_SHA1)) {
+  if (UseSHA && VM_Version::supports_sha1()) {
     if (FLAG_IS_DEFAULT(UseSHA1Intrinsics)) {
       FLAG_SET_DEFAULT(UseSHA1Intrinsics, true);
     }
@@ -326,7 +327,7 @@ void VM_Version::initialize() {
     FLAG_SET_DEFAULT(UseSHA1Intrinsics, false);
   }
 
-  if (UseSHA && (_features & CPU_SHA2)) {
+  if (UseSHA && VM_Version::supports_sha2()) {
     if (FLAG_IS_DEFAULT(UseSHA256Intrinsics)) {
       FLAG_SET_DEFAULT(UseSHA256Intrinsics, true);
     }
@@ -335,7 +336,7 @@ void VM_Version::initialize() {
     FLAG_SET_DEFAULT(UseSHA256Intrinsics, false);
   }
 
-  if (UseSHA && (_features & CPU_SHA3)) {
+  if (UseSHA && VM_Version::supports_sha3()) {
     // Do not auto-enable UseSHA3Intrinsics until it has been fully tested on hardware
     // if (FLAG_IS_DEFAULT(UseSHA3Intrinsics)) {
       // FLAG_SET_DEFAULT(UseSHA3Intrinsics, true);
@@ -345,7 +346,7 @@ void VM_Version::initialize() {
     FLAG_SET_DEFAULT(UseSHA3Intrinsics, false);
   }
 
-  if (UseSHA && (_features & CPU_SHA512)) {
+  if (UseSHA && VM_Version::supports_sha512()) {
     // Do not auto-enable UseSHA512Intrinsics until it has been fully tested on hardware
     // if (FLAG_IS_DEFAULT(UseSHA512Intrinsics)) {
       // FLAG_SET_DEFAULT(UseSHA512Intrinsics, true);
@@ -359,7 +360,7 @@ void VM_Version::initialize() {
     FLAG_SET_DEFAULT(UseSHA, false);
   }
 
-  if (_features & CPU_PMULL) {
+  if (VM_Version::supports_pmull()) {
     if (FLAG_IS_DEFAULT(UseGHASHIntrinsics)) {
       FLAG_SET_DEFAULT(UseGHASHIntrinsics, true);
     }
@@ -384,18 +385,26 @@ void VM_Version::initialize() {
     FLAG_SET_DEFAULT(UseBlockZeroing, false);
   }
 
-  if (_features & CPU_SVE) {
+  if (VM_Version::supports_sve2()) {
     if (FLAG_IS_DEFAULT(UseSVE)) {
-      FLAG_SET_DEFAULT(UseSVE, (_features & CPU_SVE2) ? 2 : 1);
+      FLAG_SET_DEFAULT(UseSVE, 2);
     }
-    if (UseSVE > 0) {
-      _initial_sve_vector_length = get_current_sve_vector_length();
+  } else if (VM_Version::supports_sve()) {
+    if (FLAG_IS_DEFAULT(UseSVE)) {
+      FLAG_SET_DEFAULT(UseSVE, 1);
+    } else if (UseSVE > 1) {
+      warning("SVE2 specified, but not supported on current CPU. Using SVE.");
+      FLAG_SET_DEFAULT(UseSVE, 1);
     }
   } else if (UseSVE > 0) {
     warning("UseSVE specified, but not supported on current CPU. Disabling SVE.");
     FLAG_SET_DEFAULT(UseSVE, 0);
   }
 
+  if (UseSVE > 0) {
+    _initial_sve_vector_length = get_current_sve_vector_length();
+  }
+
   // This machine allows unaligned memory accesses
   if (FLAG_IS_DEFAULT(UseUnalignedAccesses)) {
     FLAG_SET_DEFAULT(UseUnalignedAccesses, true);
@@ -416,14 +425,14 @@ void VM_Version::initialize() {
     _rop_protection = false;
     // Enable PAC if this code has been built with branch-protection and the CPU/OS supports it.
 #ifdef __ARM_FEATURE_PAC_DEFAULT
-    if ((_features & CPU_PACA) != 0) {
+    if (VM_Version::supports_paca()) {
       _rop_protection = true;
     }
 #endif
   } else if (strcmp(UseBranchProtection, "pac-ret") == 0) {
     _rop_protection = true;
 #ifdef __ARM_FEATURE_PAC_DEFAULT
-    if ((_features & CPU_PACA) == 0) {
+    if (!VM_Version::supports_paca()) {
       warning("ROP-protection specified, but not supported on this CPU.");
       // Disable PAC to prevent illegal instruction crashes.
       _rop_protection = false;