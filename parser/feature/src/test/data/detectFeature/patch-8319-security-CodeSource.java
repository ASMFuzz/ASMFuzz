@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -80,7 +80,7 @@ public class CodeSource implements java.io.Serializable {
 
     /**
      * A String form of the URL for use as a key in HashMaps/Sets. The String
-     * form should be behave in the same manner as the URL when compared for
+     * form should behave in the same manner as the URL when compared for
      * equality in a HashMap/Set, except that no nameservice lookup is done
      * on the hostname (only string comparison), and the fragment is not
      * considered.
@@ -211,7 +211,7 @@ public final java.security.cert.Certificate[] getCertificates() {
                     signers[i].getSignerCertPath().getCertificates());
             }
             certs = certChains.toArray(
-                        new java.security.cert.Certificate[certChains.size()]);
+                    new java.security.cert.Certificate[0]);
             return certs.clone();
 
         } else {
@@ -330,7 +330,7 @@ public boolean implies(CodeSource codesource)
      *
      * @param that the CodeSource to check against.
      * @param strict if true then a strict equality match is performed.
-     *               Otherwise a subset match is performed.
+     *               Otherwise, a subset match is performed.
      */
     boolean matchCerts(CodeSource that, boolean strict)
     {
@@ -461,9 +461,7 @@ private boolean matchLocation(CodeSource that) {
                 if (that.sp == null) {
                     that.sp = new SocketPermission(thatHost, "resolve");
                 }
-                if (!this.sp.implies(that.sp)) {
-                    return false;
-                }
+                return this.sp.implies(that.sp);
             }
         }
         // everything matches
@@ -570,7 +568,7 @@ private void readObject(java.io.ObjectInputStream ois)
             // we know of 3 different cert types: X.509, PGP, SDSI, which
             // could all be present in the stream at the same time
             cfs = new Hashtable<>(3);
-            certList = new ArrayList<>(size > 20 ? 20 : size);
+            certList = new ArrayList<>(Math.min(size, 20));
         } else if (size < 0) {
             throw new IOException("size cannot be negative");
         }
@@ -665,7 +663,7 @@ private CodeSigner[] convertCertArrayToSignerArray(
             if (signers.isEmpty()) {
                 return null;
             } else {
-                return signers.toArray(new CodeSigner[signers.size()]);
+                return signers.toArray(new CodeSigner[0]);
             }
 
         } catch (CertificateException e) {