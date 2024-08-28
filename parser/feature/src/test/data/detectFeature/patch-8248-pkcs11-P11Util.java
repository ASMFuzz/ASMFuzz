@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,7 @@
 
 package sun.security.pkcs11;
 
+import java.lang.ref.Cleaner;
 import java.math.BigInteger;
 import java.security.*;
 
@@ -39,6 +40,9 @@
  */
 public final class P11Util {
 
+    // A cleaner, shared within this module.
+    public static final Cleaner cleaner = Cleaner.create();
+
     private static Object LOCK = new Object();
 
     private static volatile Provider sun, sunRsaSign, sunJce;