@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -66,7 +66,7 @@
 
 final class CryptoPolicyParser {
 
-    private Vector<GrantEntry> grantEntries;
+    private final Vector<GrantEntry> grantEntries;
 
     // Convenience variables for parsing
     private StreamTokenizer st;
@@ -76,7 +76,7 @@ final class CryptoPolicyParser {
      * Creates a CryptoPolicyParser object.
      */
     CryptoPolicyParser() {
-        grantEntries = new Vector<GrantEntry>();
+        grantEntries = new Vector<>();
     }
 
     /**
@@ -141,8 +141,7 @@ void read(Reader policy)
         while (lookahead != StreamTokenizer.TT_EOF) {
             if (peek("grant")) {
                 GrantEntry ge = parseGrantEntry(processedPermissions);
-                if (ge != null)
-                    grantEntries.addElement(ge);
+                grantEntries.addElement(ge);
             } else {
                 throw new ParsingException(st.lineno(), "expected grant " +
                                            "statement");
@@ -280,11 +279,11 @@ private CryptoPermissionEntry parsePermissionEntry(
         return e;
     }
 
-    private static final AlgorithmParameterSpec getInstance(String type,
-                                                            Integer[] params)
+    private static AlgorithmParameterSpec getInstance(String type,
+                                                      Integer[] params)
         throws ParsingException
     {
-        AlgorithmParameterSpec ret = null;
+        AlgorithmParameterSpec ret;
 
         try {
             Class<?> apsClass = Class.forName(type);
@@ -496,7 +495,7 @@ private boolean isConsistent(String alg, String exemptionMechanism,
             exemptionMechanism == null ? "none" : exemptionMechanism;
 
         if (processedPermissions == null) {
-            processedPermissions = new Hashtable<String, Vector<String>>();
+            processedPermissions = new Hashtable<>();
             Vector<String> exemptionMechanisms = new Vector<>(1);
             exemptionMechanisms.addElement(thisExemptionMechanism);
             processedPermissions.put(alg, exemptionMechanisms);
@@ -515,7 +514,7 @@ private boolean isConsistent(String alg, String exemptionMechanism,
                 return false;
             }
         } else {
-            exemptionMechanisms = new Vector<String>(1);
+            exemptionMechanisms = new Vector<>(1);
         }
 
         exemptionMechanisms.addElement(thisExemptionMechanism);
@@ -553,10 +552,10 @@ private boolean isConsistent(String alg, String exemptionMechanism,
 
     private static class GrantEntry {
 
-        private Vector<CryptoPermissionEntry> permissionEntries;
+        private final Vector<CryptoPermissionEntry> permissionEntries;
 
         GrantEntry() {
-            permissionEntries = new Vector<CryptoPermissionEntry>();
+            permissionEntries = new Vector<>();
         }
 
         void add(CryptoPermissionEntry pe)
@@ -643,11 +642,9 @@ public boolean equals(Object obj) {
             if (obj == this)
                 return true;
 
-            if (!(obj instanceof CryptoPermissionEntry))
+            if (!(obj instanceof CryptoPermissionEntry that))
                 return false;
 
-            CryptoPermissionEntry that = (CryptoPermissionEntry) obj;
-
             if (this.cryptoPermission == null) {
                 if (that.cryptoPermission != null) return false;
             } else {
@@ -668,14 +665,10 @@ public boolean equals(Object obj) {
             if (this.checkParam != that.checkParam) return false;
 
             if (this.algParamSpec == null) {
-                if (that.algParamSpec != null) return false;
+                return that.algParamSpec == null;
             } else {
-                if (!this.algParamSpec.equals(that.algParamSpec))
-                    return false;
+                return this.algParamSpec.equals(that.algParamSpec);
             }
-
-            // everything matched -- the 2 objects are equal
-            return true;
         }
     }
 