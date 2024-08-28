@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,6 +31,7 @@
 import static sun.security.ec.ECOperations.IntermediateValueException;
 
 import java.math.BigInteger;
+import java.security.MessageDigest;
 import java.security.ProviderException;
 import java.security.spec.*;
 import java.util.Arrays;
@@ -256,10 +257,8 @@ public boolean verifySignedDigest(byte[] digest, byte[] sig, ECPoint pp) {
 
         ecOps.setSum(p1, p2.asAffine());
         IntegerModuloP result = p1.asAffine().getX();
-        result = result.additiveInverse().add(ri);
-
         b2a(result, orderField, temp1);
-        return ECOperations.allZero(temp1);
+        return MessageDigest.isEqual(temp1, r);
     }
 
     public static ImmutableIntegerModuloP b2a(IntegerModuloP b,