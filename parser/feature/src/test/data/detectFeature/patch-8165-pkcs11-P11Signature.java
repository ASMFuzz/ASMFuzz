@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -37,7 +37,7 @@
 import sun.security.util.*;
 import sun.security.x509.AlgorithmId;
 
-import sun.security.rsa.RSASignature;
+import sun.security.rsa.RSAUtil;
 import sun.security.rsa.RSAPadding;
 
 import sun.security.pkcs11.wrapper.*;
@@ -766,7 +766,7 @@ private byte[] pkcs1Pad(byte[] data) {
 
     private byte[] encodeSignature(byte[] digest) throws SignatureException {
         try {
-            return RSASignature.encodeSignature(digestOID, digest);
+            return RSAUtil.encodeSignature(digestOID, digest);
         } catch (IOException e) {
             throw new SignatureException("Invalid encoding", e);
         }