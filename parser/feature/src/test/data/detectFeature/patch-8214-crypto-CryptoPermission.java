@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,7 @@
 
 package javax.crypto;
 
+import java.io.Serial;
 import java.security.*;
 import java.security.spec.AlgorithmParameterSpec;
 import java.io.Serializable;
@@ -52,7 +53,7 @@ class CryptoPermission extends java.security.Permission {
     @java.io.Serial
     private static final long serialVersionUID = 8987399626114087514L;
 
-    private String alg;
+    private final String alg;
     private int maxKeySize = Integer.MAX_VALUE; // no restriction on maxKeySize
     private String exemptionMechanism = null;
     @SuppressWarnings("serial") // Not statically typed as Serializable
@@ -219,11 +220,9 @@ class CryptoPermission extends java.security.Permission {
      * implied by this permission, false otherwise.
      */
     public boolean implies(Permission p) {
-        if (!(p instanceof CryptoPermission))
+        if (!(p instanceof CryptoPermission cp))
             return false;
 
-        CryptoPermission cp = (CryptoPermission)p;
-
         if ((!alg.equalsIgnoreCase(cp.alg)) &&
             (!alg.equalsIgnoreCase(ALG_NAME_WILDCARD))) {
             return false;
@@ -238,9 +237,7 @@ public boolean implies(Permission p) {
             }
 
             // check exemptionMechanism.
-            if (impliesExemptionMechanism(cp.exemptionMechanism)) {
-                return true;
-            }
+            return impliesExemptionMechanism(cp.exemptionMechanism);
         }
 
         return false;
@@ -261,11 +258,9 @@ public boolean equals(Object obj) {
         if (obj == this)
             return true;
 
-        if (!(obj instanceof CryptoPermission))
+        if (!(obj instanceof CryptoPermission that))
             return false;
 
-        CryptoPermission that = (CryptoPermission) obj;
-
         if (!(alg.equalsIgnoreCase(that.alg)) ||
             (maxKeySize != that.maxKeySize)) {
             return false;
@@ -300,7 +295,7 @@ public int hashCode() {
 
     /**
      * There is no action defined for a CryptoPermission
-     * onject.
+     * object.
      */
     public String getActions()
     {
@@ -398,11 +393,7 @@ private boolean impliesExemptionMechanism(String exemptionMechanism) {
             return false;
         }
 
-        if (this.exemptionMechanism.equals(exemptionMechanism)) {
-            return true;
-        }
-
-        return false;
+        return this.exemptionMechanism.equals(exemptionMechanism);
     }
 
     private boolean impliesParameterSpec(boolean checkParam,
@@ -442,20 +433,15 @@ private boolean impliesParameterSpec(boolean checkParam,
 
             // For classes we don't know, the following
             // may be the best try.
-            if (this.algParamSpec.equals(algParamSpec)) {
-                return true;
-            }
-            return false;
-        } else if (this.checkParam) {
-            return false;
+            return this.algParamSpec.equals(algParamSpec);
         } else {
-            return true;
+            return !this.checkParam;
         }
     }
 
     private boolean equalObjects(Object obj1, Object obj2) {
         if (obj1 == null) {
-            return (obj2 == null ? true : false);
+            return (obj2 == null);
         }
 
         return obj1.equals(obj2);
@@ -475,16 +461,17 @@ private boolean equalObjects(Object obj1, Object obj2) {
 final class CryptoPermissionCollection extends PermissionCollection
     implements Serializable
 {
+    @Serial
     private static final long serialVersionUID = -511215555898802763L;
 
-    private Vector<Permission> permissions;
+    private final Vector<Permission> permissions;
 
     /**
      * Creates an empty CryptoPermissionCollection
      * object.
      */
     CryptoPermissionCollection() {
-        permissions = new Vector<Permission>(3);
+        permissions = new Vector<>(3);
     }
 
     /**
@@ -516,11 +503,9 @@ public void add(Permission permission) {
      * CryptoPermissionCollection, false if not.
      */
     public boolean implies(Permission permission) {
-        if (!(permission instanceof CryptoPermission))
+        if (!(permission instanceof CryptoPermission cp))
             return false;
 
-        CryptoPermission cp = (CryptoPermission)permission;
-
         Enumeration<Permission> e = permissions.elements();
 
         while (e.hasMoreElements()) {