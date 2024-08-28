@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -134,6 +134,11 @@ public boolean verify(EdDSAParameterSpec sigParams, AffinePoint affineA,
         if (signature == null) {
             throw new SignatureException("signature was null");
         }
+
+        if (params.getKeyLength() * 2 != signature.length) {
+            throw new SignatureException("signature length invalid");
+        }
+
         byte[] encR = Arrays.copyOf(signature, signature.length / 2);
         byte[] encS = Arrays.copyOfRange(signature, signature.length / 2,
             signature.length);