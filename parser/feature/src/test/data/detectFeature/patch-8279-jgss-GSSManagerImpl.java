@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -88,8 +88,10 @@ public Oid[] getMechsForName(Oid nameType){
                 }
             } catch (GSSException e) {
                 // Squelch it and just skip over this mechanism
-                GSSUtil.debug("Skip " + mech +
-                              ": error retrieving supported name types");
+                if (GSSUtil.DEBUG) {
+                    GSSUtil.debug("Skip " + mech +
+                            ": error retrieving supported name types");
+                }
             }
         }
 