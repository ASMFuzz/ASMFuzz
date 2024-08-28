@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -164,7 +164,7 @@ protected HandshakeContext(SSLContextImpl sslContext,
         this.conContext = conContext;
         this.sslConfig = (SSLConfiguration)conContext.sslConfig.clone();
 
-        this.algorithmConstraints = new SSLAlgorithmConstraints(
+        this.algorithmConstraints = SSLAlgorithmConstraints.wrap(
                 sslConfig.userSpecifiedAlgorithmConstraints);
         this.activeProtocols = getActiveProtocols(sslConfig.enabledProtocols,
                 sslConfig.enabledCipherSuites, algorithmConstraints);