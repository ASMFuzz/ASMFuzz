@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -268,7 +268,7 @@ public enum KnownOIDs {
     HmacSHA512$256("1.2.840.113549.2.13", "HmacSHA512/256"),
 
     // encryptionAlgs 1.2.840.113549.3.*
-    RC2$CBC$PKCS5Padding("1.2.840.113549.3.2", "RC2/CBC/PKCS5Padding"),
+    RC2$CBC$PKCS5Padding("1.2.840.113549.3.2", "RC2/CBC/PKCS5Padding", "RC2"),
     ARCFOUR("1.2.840.113549.3.4", "ARCFOUR", "RC4"),
     DESede$CBC$NoPadding("1.2.840.113549.3.7", "DESede/CBC/NoPadding"),
     RC5$CBC$PKCS5Padding("1.2.840.113549.3.9", "RC5/CBC/PKCS5Padding"),
@@ -427,7 +427,9 @@ public enum KnownOIDs {
     SkipIPAddress("1.3.6.1.4.1.42.2.11.2.1"),
     JAVASOFT_JDKKeyProtector("1.3.6.1.4.1.42.2.17.1.1"),
     JAVASOFT_JCEKeyProtector("1.3.6.1.4.1.42.2.19.1"),
-    MICROSOFT_ExportApproved("1.3.6.1.4.1.311.10.3.3");
+    MICROSOFT_ExportApproved("1.3.6.1.4.1.311.10.3.3"),
+
+    Blowfish("1.3.6.1.4.1.3029.1.1.2");
 
     private String stdName;
     private String oid;