@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -98,7 +98,7 @@ public RMIJRMPServerImpl(int port,
         this.env = (env == null) ? Collections.<String, Object>emptyMap() : env;
 
         // This attribute was represented by RMIConnectorServer.CREDENTIALS_TYPES.
-        // This attribute is superceded by
+        // This attribute is superseded by
         // RMIConnectorServer.CREDENTIALS_FILTER_PATTERN.
         // Retaining this for backward compatibility.
         String[] credentialsTypes