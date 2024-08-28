@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -105,7 +105,7 @@ private static String getHostnameProperty() {
     /**
      * Find host name of local machine.  Property "java.rmi.server.hostname"
      * is used if set, so server administrator can compensate for the possible
-     * inablility to get fully qualified host name from VM.
+     * inability to get fully qualified host name from VM.
      */
     static {
         localHostKnown = true;
@@ -130,7 +130,7 @@ private static String getHostnameProperty() {
                     localHost = FQDN.attemptFQDN(localAddr);
                 } else {
                     /* default to using ip addresses, names will
-                     * work across seperate domains.
+                     * work across separate domains.
                      */
                     localHost = localAddr.getHostAddress();
                 }