@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2012, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -52,5 +52,5 @@ public interface HostnameVerifier {
      * @param session SSLSession used on the connection to host
      * @return true if the host name is acceptable
      */
-    public boolean verify(String hostname, SSLSession session);
+    boolean verify(String hostname, SSLSession session);
 }