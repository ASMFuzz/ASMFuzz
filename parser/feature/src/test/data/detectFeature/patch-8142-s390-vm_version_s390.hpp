@@ -1,6 +1,6 @@
 /*
- * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
- * Copyright (c) 2016, 2021 SAP SE. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022 SAP SE. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -194,7 +194,7 @@ class VM_Version: public Abstract_VM_Version {
   };
   class Cipher {
    public:
-    enum { // KM only!!! KMC uses different parmBlk sizes.
+    enum { // function codes, same for all KM* cipher instructions.
       _Query              =   0,
       _DEA                =   1,
       _TDEA128            =   2,
@@ -254,6 +254,30 @@ class VM_Version: public Abstract_VM_Version {
       _EncryptedXTSAES256_parmBlk_C =  80,
       _PRNG_parmBlk_C               =  32,
 
+      // Parameter block sizes (in bytes) for KMCTR (CounterMode) instruction.
+      _Query_parmBlk_G              =  16,
+      _DEA_parmBlk_G                =   8,
+      _TDEA128_parmBlk_G            =  16,
+      _TDEA192_parmBlk_G            =  24,
+      _EncryptedDEA_parmBlk_G       =  32,
+      _EncryptedDEA128_parmBlk_G    =  40,
+      _EncryptedDEA192_parmBlk_G    =  48,
+      _AES128_parmBlk_G             =  16,
+      _AES192_parmBlk_G             =  24,
+      _AES256_parmBlk_G             =  32,
+      _EnccryptedAES128_parmBlk_G   =  48,
+      _EnccryptedAES192_parmBlk_G   =  56,
+      _EnccryptedAES256_parmBlk_G   =  64,
+
+      // Parameter block sizes (in bytes) for KMA instruction.
+      _Query_parmBlk_A              =  16,
+      _AES128_parmBlk_A             =  96,
+      _AES192_parmBlk_A             = 104,
+      _AES256_parmBlk_A             = 112,
+      _EnccryptedAES128_parmBlk_A   = 128,
+      _EnccryptedAES192_parmBlk_A   = 136,
+      _EnccryptedAES256_parmBlk_A   = 144,
+
       // Data block sizes (in bytes).
       _Query_dataBlk              =   0,
       _DEA_dataBlk                =   8,
@@ -459,9 +483,17 @@ class VM_Version: public Abstract_VM_Version {
   static bool has_VectorPackedDecimalEnh()    { return  (_features[2] & VectorPackedDecimalEnhMask)    == VectorPackedDecimalEnhMask; }
 
   // Crypto features query functions.
-  static bool has_Crypto_AES128()             { return has_Crypto() && test_feature_bit(&_cipher_features_KM[0], Cipher::_AES128, Cipher::_featureBits); }
-  static bool has_Crypto_AES192()             { return has_Crypto() && test_feature_bit(&_cipher_features_KM[0], Cipher::_AES192, Cipher::_featureBits); }
-  static bool has_Crypto_AES256()             { return has_Crypto() && test_feature_bit(&_cipher_features_KM[0], Cipher::_AES256, Cipher::_featureBits); }
+  static bool has_Crypto_AES_GCM128()         { return has_Crypto() && test_feature_bit(&_cipher_features_KMA[0], Cipher::_AES128, Cipher::_featureBits); }
+  static bool has_Crypto_AES_GCM192()         { return has_Crypto() && test_feature_bit(&_cipher_features_KMA[0], Cipher::_AES192, Cipher::_featureBits); }
+  static bool has_Crypto_AES_GCM256()         { return has_Crypto() && test_feature_bit(&_cipher_features_KMA[0], Cipher::_AES256, Cipher::_featureBits); }
+  static bool has_Crypto_AES_GCM()            { return has_Crypto_AES_GCM128() || has_Crypto_AES_GCM192() || has_Crypto_AES_GCM256(); }
+  static bool has_Crypto_AES_CTR128()         { return has_Crypto() && test_feature_bit(&_cipher_features_KMCTR[0], Cipher::_AES128, Cipher::_featureBits); }
+  static bool has_Crypto_AES_CTR192()         { return has_Crypto() && test_feature_bit(&_cipher_features_KMCTR[0], Cipher::_AES192, Cipher::_featureBits); }
+  static bool has_Crypto_AES_CTR256()         { return has_Crypto() && test_feature_bit(&_cipher_features_KMCTR[0], Cipher::_AES256, Cipher::_featureBits); }
+  static bool has_Crypto_AES_CTR()            { return has_Crypto_AES_CTR128() || has_Crypto_AES_CTR192() || has_Crypto_AES_CTR256(); }
+  static bool has_Crypto_AES128()             { return has_Crypto() && test_feature_bit(&_cipher_features_KM[0],  Cipher::_AES128, Cipher::_featureBits); }
+  static bool has_Crypto_AES192()             { return has_Crypto() && test_feature_bit(&_cipher_features_KM[0],  Cipher::_AES192, Cipher::_featureBits); }
+  static bool has_Crypto_AES256()             { return has_Crypto() && test_feature_bit(&_cipher_features_KM[0],  Cipher::_AES256, Cipher::_featureBits); }
   static bool has_Crypto_AES()                { return has_Crypto_AES128() || has_Crypto_AES192() || has_Crypto_AES256(); }
 
   static bool has_Crypto_SHA1()               { return has_Crypto() && test_feature_bit(&_msgdigest_features[0], MsgDigest::_SHA1,   MsgDigest::_featureBits); }