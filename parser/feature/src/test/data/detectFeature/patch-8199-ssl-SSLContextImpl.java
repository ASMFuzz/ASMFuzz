@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1485,14 +1485,14 @@ private void checkAdditionalTrust(X509Certificate[] chain,
                     String[] peerSupportedSignAlgs =
                             extSession.getLocalSupportedSignatureAlgorithms();
 
-                    constraints = new SSLAlgorithmConstraints(
+                    constraints = SSLAlgorithmConstraints.forSocket(
                                     sslSocket, peerSupportedSignAlgs, true);
                 } else {
                     constraints =
-                            new SSLAlgorithmConstraints(sslSocket, true);
+                            SSLAlgorithmConstraints.forSocket(sslSocket, true);
                 }
             } else {
-                constraints = new SSLAlgorithmConstraints(sslSocket, true);
+                constraints = SSLAlgorithmConstraints.forSocket(sslSocket, true);
             }
 
             checkAlgorithmConstraints(chain, constraints, checkClientTrusted);
@@ -1525,14 +1525,14 @@ private void checkAdditionalTrust(X509Certificate[] chain,
                     String[] peerSupportedSignAlgs =
                             extSession.getLocalSupportedSignatureAlgorithms();
 
-                    constraints = new SSLAlgorithmConstraints(
+                    constraints = SSLAlgorithmConstraints.forEngine(
                                     engine, peerSupportedSignAlgs, true);
                 } else {
                     constraints =
-                            new SSLAlgorithmConstraints(engine, true);
+                            SSLAlgorithmConstraints.forEngine(engine, true);
                 }
             } else {
-                constraints = new SSLAlgorithmConstraints(engine, true);
+                constraints = SSLAlgorithmConstraints.forEngine(engine, true);
             }
 
             checkAlgorithmConstraints(chain, constraints, checkClientTrusted);