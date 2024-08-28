@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -405,6 +405,9 @@ public Key engineGetKey(String alias, char[] password)
                         // decode secret key
                     } else {
                         byte[] keyBytes = in.getOctetString();
+                        if (keyAlgo.equals(KnownOIDs.OIW_DES_CBC.stdName())) {
+                            keyAlgo = "DES";
+                        }
                         SecretKeySpec secretKeySpec =
                                 new SecretKeySpec(keyBytes, keyAlgo);
 