@@ -1,6 +1,6 @@
 /*
- * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
- * Copyright (c) 2016, 2021 SAP SE. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022 SAP SE. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -36,7 +36,7 @@
 # include <sys/sysinfo.h>
 
 bool VM_Version::_is_determine_features_test_running  = false;
-const char*   VM_Version::_model_string;
+const char*   VM_Version::_model_string = "";
 
 unsigned long VM_Version::_features[_features_buffer_len]              = {0, 0, 0, 0};
 unsigned long VM_Version::_cipher_features_KM[_features_buffer_len]    = {0, 0, 0, 0};
@@ -175,30 +175,38 @@ void VM_Version::initialize() {
   // TODO: UseAESIntrinsics must be made keylength specific.
   // As of March 2015 and Java8, only AES128 is supported by the Java Cryptographic Extensions.
   // Therefore, UseAESIntrinsics is of minimal use at the moment.
-  if (FLAG_IS_DEFAULT(UseAES) && has_Crypto_AES()) {
+  if (FLAG_IS_DEFAULT(UseAES) && (has_Crypto_AES() || has_Crypto_AES_CTR())) {
     FLAG_SET_DEFAULT(UseAES, true);
   }
-  if (UseAES && !has_Crypto_AES()) {
+  if (UseAES && !(has_Crypto_AES() || has_Crypto_AES_CTR())) {
     warning("AES instructions are not available on this CPU");
     FLAG_SET_DEFAULT(UseAES, false);
   }
+
   if (UseAES) {
-    if (FLAG_IS_DEFAULT(UseAESIntrinsics)) {
+    if (FLAG_IS_DEFAULT(UseAESIntrinsics) && has_Crypto_AES()) {
       FLAG_SET_DEFAULT(UseAESIntrinsics, true);
     }
+    if (FLAG_IS_DEFAULT(UseAESCTRIntrinsics) && has_Crypto_AES_CTR()) {
+      FLAG_SET_DEFAULT(UseAESCTRIntrinsics, true);
+    }
   }
+
   if (UseAESIntrinsics && !has_Crypto_AES()) {
     warning("AES intrinsics are not available on this CPU");
     FLAG_SET_DEFAULT(UseAESIntrinsics, false);
   }
+  if (UseAESCTRIntrinsics && !has_Crypto_AES_CTR()) {
+    warning("AES_CTR intrinsics are not available on this CPU");
+    FLAG_SET_DEFAULT(UseAESCTRIntrinsics, false);
+  }
+
   if (UseAESIntrinsics && !UseAES) {
     warning("AES intrinsics require UseAES flag to be enabled. Intrinsics will be disabled.");
     FLAG_SET_DEFAULT(UseAESIntrinsics, false);
   }
-
-  // TODO: implement AES/CTR intrinsics
-  if (UseAESCTRIntrinsics) {
-    warning("AES/CTR intrinsics are not available on this CPU");
+  if (UseAESCTRIntrinsics && !UseAES) {
+    warning("AES_CTR intrinsics require UseAES flag to be enabled. Intrinsics will be disabled.");
     FLAG_SET_DEFAULT(UseAESCTRIntrinsics, false);
   }
 