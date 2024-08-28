@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -46,14 +46,14 @@ public final class CodeSigner implements Serializable {
      *
      * @serial
      */
-    private CertPath signerCertPath;
+    private final CertPath signerCertPath;
 
     /**
      * The signature timestamp.
      *
      * @serial
      */
-    private Timestamp timestamp;
+    private final Timestamp timestamp;
 
     /*
      * Hash code for this code signer.
@@ -126,7 +126,7 @@ public int hashCode() {
      * @return true if the objects are considered equal, false otherwise.
      */
     public boolean equals(Object obj) {
-        if (obj == null || (!(obj instanceof CodeSigner that))) {
+        if ((!(obj instanceof CodeSigner that))) {
             return false;
         }
 
@@ -139,8 +139,7 @@ public boolean equals(Object obj) {
                 return false;
             }
         } else {
-            if (thatTimestamp == null ||
-                (! timestamp.equals(thatTimestamp))) {
+            if ((!timestamp.equals(thatTimestamp))) {
                 return false;
             }
         }