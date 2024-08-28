@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -340,12 +340,7 @@ PrincipalName getServerAlias() {
         return serverAlias;
     }
 
-    private static void debug(String message) {
-        //      System.err.println(">>> KrbTgsReq: " + message);
-    }
-
     boolean usedSubkey() {
         return useSubkey;
     }
-
 }