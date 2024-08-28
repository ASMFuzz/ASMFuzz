@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -57,46 +57,98 @@ final class SSLAlgorithmConstraints implements AlgorithmConstraints {
 
     // the default algorithm constraints
     static final AlgorithmConstraints DEFAULT =
-                        new SSLAlgorithmConstraints(null);
+                        new SSLAlgorithmConstraints(null, true);
 
     // the default SSL only algorithm constraints
     static final AlgorithmConstraints DEFAULT_SSL_ONLY =
-                        new SSLAlgorithmConstraints((SSLSocket)null, false);
+                        new SSLAlgorithmConstraints(null, false);
 
-    SSLAlgorithmConstraints(AlgorithmConstraints userSpecifiedConstraints) {
-        this.userSpecifiedConstraints = userSpecifiedConstraints;
-        this.peerSpecifiedConstraints = null;
-        this.enabledX509DisabledAlgConstraints = true;
+    private SSLAlgorithmConstraints(AlgorithmConstraints userSpecifiedConstraints,
+                                    boolean enabledX509DisabledAlgConstraints) {
+        this(userSpecifiedConstraints, null, enabledX509DisabledAlgConstraints);
     }
 
-    SSLAlgorithmConstraints(SSLSocket socket,
+    private SSLAlgorithmConstraints(
+            AlgorithmConstraints userSpecifiedConstraints,
+            SupportedSignatureAlgorithmConstraints peerSpecifiedConstraints,
             boolean withDefaultCertPathConstraints) {
-        this.userSpecifiedConstraints = getUserSpecifiedConstraints(socket);
-        this.peerSpecifiedConstraints = null;
+        this.userSpecifiedConstraints = userSpecifiedConstraints;
+        this.peerSpecifiedConstraints = peerSpecifiedConstraints;
         this.enabledX509DisabledAlgConstraints = withDefaultCertPathConstraints;
     }
 
-    SSLAlgorithmConstraints(SSLEngine engine,
+    /**
+     * Returns a SSLAlgorithmConstraints instance that checks the provided
+     * {@code userSpecifiedConstraints} in addition to standard checks.
+     * Returns a singleton instance if parameter is null or DEFAULT.
+     * @param userSpecifiedConstraints additional constraints to check
+     * @return a SSLAlgorithmConstraints instance
+     */
+    static AlgorithmConstraints wrap(AlgorithmConstraints userSpecifiedConstraints) {
+        return wrap(userSpecifiedConstraints, true);
+    }
+
+    private static AlgorithmConstraints wrap(
+            AlgorithmConstraints userSpecifiedConstraints,
             boolean withDefaultCertPathConstraints) {
-        this.userSpecifiedConstraints = getUserSpecifiedConstraints(engine);
-        this.peerSpecifiedConstraints = null;
-        this.enabledX509DisabledAlgConstraints = withDefaultCertPathConstraints;
+        if (nullIfDefault(userSpecifiedConstraints) == null) {
+            return withDefaultCertPathConstraints ? DEFAULT : DEFAULT_SSL_ONLY;
+        }
+        return new SSLAlgorithmConstraints(userSpecifiedConstraints,
+                withDefaultCertPathConstraints);
+    }
+
+    /**
+     * Returns a SSLAlgorithmConstraints instance that checks the constraints
+     * configured for the given {@code socket} in addition to standard checks.
+     * Returns a singleton instance if the constraints are null or DEFAULT.
+     * @param socket socket with configured constraints
+     * @return a SSLAlgorithmConstraints instance
+     */
+    static AlgorithmConstraints forSocket(SSLSocket socket,
+                                          boolean withDefaultCertPathConstraints) {
+        AlgorithmConstraints userSpecifiedConstraints =
+                getUserSpecifiedConstraints(socket);
+        return wrap(userSpecifiedConstraints, withDefaultCertPathConstraints);
     }
 
-    SSLAlgorithmConstraints(SSLSocket socket, String[] supportedAlgorithms,
+    static SSLAlgorithmConstraints forSocket(
+            SSLSocket socket,
+            String[] supportedAlgorithms,
             boolean withDefaultCertPathConstraints) {
-        this.userSpecifiedConstraints = getUserSpecifiedConstraints(socket);
-        this.peerSpecifiedConstraints =
-                new SupportedSignatureAlgorithmConstraints(supportedAlgorithms);
-        this.enabledX509DisabledAlgConstraints = withDefaultCertPathConstraints;
+        return new SSLAlgorithmConstraints(
+                nullIfDefault(getUserSpecifiedConstraints(socket)),
+                new SupportedSignatureAlgorithmConstraints(supportedAlgorithms),
+                withDefaultCertPathConstraints);
+    }
+
+    /**
+     * Returns a SSLAlgorithmConstraints instance that checks the constraints
+     * configured for the given {@code engine} in addition to standard checks.
+     * Returns a singleton instance if the constraints are null or DEFAULT.
+     * @param engine engine with configured constraints
+     * @return a SSLAlgorithmConstraints instance
+     */
+    static AlgorithmConstraints forEngine(SSLEngine engine,
+                                          boolean withDefaultCertPathConstraints) {
+        AlgorithmConstraints userSpecifiedConstraints =
+                getUserSpecifiedConstraints(engine);
+        return wrap(userSpecifiedConstraints, withDefaultCertPathConstraints);
     }
 
-    SSLAlgorithmConstraints(SSLEngine engine, String[] supportedAlgorithms,
+    static SSLAlgorithmConstraints forEngine(
+            SSLEngine engine,
+            String[] supportedAlgorithms,
             boolean withDefaultCertPathConstraints) {
-        this.userSpecifiedConstraints = getUserSpecifiedConstraints(engine);
-        this.peerSpecifiedConstraints =
-                new SupportedSignatureAlgorithmConstraints(supportedAlgorithms);
-        this.enabledX509DisabledAlgConstraints = withDefaultCertPathConstraints;
+        return new SSLAlgorithmConstraints(
+                nullIfDefault(getUserSpecifiedConstraints(engine)),
+                new SupportedSignatureAlgorithmConstraints(supportedAlgorithms),
+                withDefaultCertPathConstraints);
+    }
+
+    private static AlgorithmConstraints nullIfDefault(
+            AlgorithmConstraints constraints) {
+        return constraints == DEFAULT ? null : constraints;
     }
 
     private static AlgorithmConstraints getUserSpecifiedConstraints(