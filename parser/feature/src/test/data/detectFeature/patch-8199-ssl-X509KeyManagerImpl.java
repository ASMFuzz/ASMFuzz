@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2004, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -199,15 +199,15 @@ private AlgorithmConstraints getAlgorithmConstraints(Socket socket) {
                             extSession.getPeerSupportedSignatureAlgorithms();
                     }
 
-                    return new SSLAlgorithmConstraints(
+                    return SSLAlgorithmConstraints.forSocket(
                         sslSocket, peerSupportedSignAlgs, true);
                 }
             }
 
-            return new SSLAlgorithmConstraints(sslSocket, true);
+            return SSLAlgorithmConstraints.forSocket(sslSocket, true);
         }
 
-        return new SSLAlgorithmConstraints((SSLSocket)null, true);
+        return SSLAlgorithmConstraints.DEFAULT;
     }
 
     // Gets algorithm constraints of the engine.
@@ -225,13 +225,13 @@ private AlgorithmConstraints getAlgorithmConstraints(SSLEngine engine) {
                             extSession.getPeerSupportedSignatureAlgorithms();
                     }
 
-                    return new SSLAlgorithmConstraints(
+                    return SSLAlgorithmConstraints.forEngine(
                         engine, peerSupportedSignAlgs, true);
                 }
             }
         }
 
-        return new SSLAlgorithmConstraints(engine, true);
+        return SSLAlgorithmConstraints.forEngine(engine, true);
     }
 
     // we construct the alias we return to JSSE as seen in the code below