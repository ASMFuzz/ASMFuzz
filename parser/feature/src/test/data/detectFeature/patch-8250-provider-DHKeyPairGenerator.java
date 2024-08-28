@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -184,7 +184,7 @@ public KeyPair generateKeyPair() {
 
         //
         // PKCS#3 section 7.1 "Private-value generation"
-        // Repeat if either of the followings does not hold:
+        // Repeat if either of the following does not hold:
         //     0 < x < p-1
         //     2^(lSize-1) <= x < 2^(lSize)
         //