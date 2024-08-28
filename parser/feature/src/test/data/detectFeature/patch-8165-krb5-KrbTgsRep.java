@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -40,7 +40,7 @@
  * This class encapsulates a TGS-REP that is sent from the KDC to the
  * Kerberos client.
  */
-public class KrbTgsRep extends KrbKdcRep {
+final class KrbTgsRep extends KrbKdcRep {
     private TGSRep rep;
     private Credentials creds;
     private Credentials additionalCreds;
@@ -121,7 +121,7 @@ public class KrbTgsRep extends KrbKdcRep {
     /**
      * Return the credentials that were contained in this KRB-TGS-REP.
      */
-    public Credentials getCreds() {
+    Credentials getCreds() {
         return creds;
     }
 