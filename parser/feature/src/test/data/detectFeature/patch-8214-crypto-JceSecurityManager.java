@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -90,7 +90,7 @@ private JceSecurityManager() {
     CryptoPermission getCryptoPermission(String theAlg) {
 
         // Need to convert to uppercase since the crypto perm
-        // lookup is case sensitive.
+        // lookup is case-sensitive.
         final String alg = theAlg.toUpperCase(Locale.ENGLISH);
 
         // If CryptoAllPermission is granted by default, we return that.
@@ -199,7 +199,6 @@ CryptoPermission getCryptoPermissionFromURL(URL callerCodeBase,
                     return cp;
                 }
             } catch (Exception e) {
-                continue;
             }
         }
         return defaultPerm;