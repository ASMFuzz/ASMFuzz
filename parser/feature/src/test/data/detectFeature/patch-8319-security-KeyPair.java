@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,8 +25,6 @@
 
 package java.security;
 
-import java.util.*;
-
 /**
  * This class is a simple holder for a key pair (a public key and a
  * private key). It does not enforce any security, and, when initialized,
@@ -45,10 +43,10 @@ public final class KeyPair implements java.io.Serializable {
     private static final long serialVersionUID = -7565189502268009837L;
 
     /** The private key. */
-    private PrivateKey privateKey;
+    private final PrivateKey privateKey;
 
     /** The public key. */
-    private PublicKey publicKey;
+    private final PublicKey publicKey;
 
     /**
      * Constructs a key pair from the given public key and private key.