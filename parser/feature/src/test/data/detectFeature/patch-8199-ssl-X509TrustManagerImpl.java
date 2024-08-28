@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -216,10 +216,10 @@ private void checkTrusted(X509Certificate[] chain,
                 String[] localSupportedSignAlgs =
                         extSession.getLocalSupportedSignatureAlgorithms();
 
-                constraints = new SSLAlgorithmConstraints(
+                constraints = SSLAlgorithmConstraints.forSocket(
                                 sslSocket, localSupportedSignAlgs, false);
             } else {
-                constraints = new SSLAlgorithmConstraints(sslSocket, false);
+                constraints = SSLAlgorithmConstraints.forSocket(sslSocket, false);
             }
 
             // Grab any stapled OCSP responses for use in validation
@@ -270,10 +270,10 @@ private void checkTrusted(X509Certificate[] chain,
                 String[] localSupportedSignAlgs =
                         extSession.getLocalSupportedSignatureAlgorithms();
 
-                constraints = new SSLAlgorithmConstraints(
+                constraints = SSLAlgorithmConstraints.forEngine(
                                 engine, localSupportedSignAlgs, false);
             } else {
-                constraints = new SSLAlgorithmConstraints(engine, false);
+                constraints = SSLAlgorithmConstraints.forEngine(engine, false);
             }
 
             // Grab any stapled OCSP responses for use in validation