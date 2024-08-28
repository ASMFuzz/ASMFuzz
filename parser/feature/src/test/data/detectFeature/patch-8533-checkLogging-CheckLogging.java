@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -107,7 +107,7 @@ public class CheckLogging {
             REGISTRY_PORT = TestLibrary.getRegistryPort(registry);
             LOCATION = "rmi://localhost:" + REGISTRY_PORT + "/";
         } catch (Exception e) {
-            TestLibrary.bomb("could not create registry");
+            TestLibrary.bomb("could not create registry", e);
         }
     }
 