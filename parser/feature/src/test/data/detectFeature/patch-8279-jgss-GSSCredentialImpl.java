@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -90,9 +90,11 @@ protected GSSCredentialImpl(GSSCredentialImpl src) {
             } catch (GSSException e) {
                 if (defaultList) {
                     // Try the next mechanism
-                    GSSUtil.debug("Ignore " + e + " while acquring cred for "
-                        + mechs[i]);
-                    //e.printStackTrace();
+                    if (GSSUtil.DEBUG) {
+                        GSSUtil.debug("Ignore " + e + " while acquiring cred for "
+                                + mechs[i]);
+                        // e.printStackTrace();
+                    }
                 } else throw e; // else try the next mechanism
             }
         }