@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,8 +25,12 @@
 
 package sun.security.rsa;
 
+import java.io.IOException;
 import java.security.*;
 import java.security.spec.*;
+import sun.security.util.DerInputStream;
+import sun.security.util.DerOutputStream;
+import sun.security.util.DerValue;
 import sun.security.util.ObjectIdentifier;
 import sun.security.x509.AlgorithmId;
 
@@ -161,4 +165,42 @@ public static Object[] getTypeAndParamSpec(AlgorithmId algid)
         result[1] = getParamSpec(algid.getParameters());
         return result;
     }
+
+    /**
+     * Encode the digest, return the to-be-signed data.
+     * Also used by the PKCS#11 provider.
+     */
+    public static byte[] encodeSignature(ObjectIdentifier oid, byte[] digest)
+            throws IOException {
+        DerOutputStream out = new DerOutputStream();
+        new AlgorithmId(oid).encode(out);
+        out.putOctetString(digest);
+        DerValue result =
+            new DerValue(DerValue.tag_Sequence, out.toByteArray());
+        return result.toByteArray();
+    }
+
+    /**
+     * Decode the signature data. Verify that the object identifier matches
+     * and return the message digest.
+     */
+    public static byte[] decodeSignature(ObjectIdentifier oid, byte[] sig)
+            throws IOException {
+        // Enforce strict DER checking for signatures
+        DerInputStream in = new DerInputStream(sig, 0, sig.length, false);
+        DerValue[] values = in.getSequence(2);
+        if ((values.length != 2) || (in.available() != 0)) {
+            throw new IOException("SEQUENCE length error");
+        }
+        AlgorithmId algId = AlgorithmId.parse(values[0]);
+        if (algId.getOID().equals(oid) == false) {
+            throw new IOException("ObjectIdentifier mismatch: "
+                + algId.getOID());
+        }
+        if (algId.getEncodedParams() != null) {
+            throw new IOException("Unexpected AlgorithmId parameters");
+        }
+        byte[] digest = values[1].getOctetString();
+        return digest;
+    }
 }