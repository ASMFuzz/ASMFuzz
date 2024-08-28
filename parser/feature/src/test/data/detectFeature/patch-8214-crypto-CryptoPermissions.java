@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -143,11 +143,10 @@ public void add(Permission permission) {
                                         "object");
         }
 
-        if (!(permission instanceof CryptoPermission)) {
+        if (!(permission instanceof CryptoPermission cryptoPerm)) {
             return;
         }
 
-        CryptoPermission cryptoPerm = (CryptoPermission)permission;
         PermissionCollection pc =
                         getPermissionCollection(cryptoPerm);
         pc.add(cryptoPerm);
@@ -156,7 +155,7 @@ public void add(Permission permission) {
     }
 
     /**
-     * Checks if this object's PermissionCollection for permissons
+     * Checks if this object's PermissionCollection for permissions
      * of the specified permission's algorithm implies the specified
      * permission. Returns true if the checking succeeded.
      *
@@ -168,12 +167,10 @@ public void add(Permission permission) {
      */
     @Override
     public boolean implies(Permission permission) {
-        if (!(permission instanceof CryptoPermission)) {
+        if (!(permission instanceof CryptoPermission cryptoPerm)) {
             return false;
         }
 
-        CryptoPermission cryptoPerm = (CryptoPermission)permission;
-
         PermissionCollection pc =
             getPermissionCollection(cryptoPerm.getAlgorithm());
 
@@ -299,7 +296,7 @@ CryptoPermissions getMinimum(CryptoPermissions other) {
      * Get the minimum of the two given PermissionCollection
      * <code>thisPc</code> and <code>thatPc</code>.
      *
-     * @param thisPc the first given PermissionColloection
+     * @param thisPc the first given PermissionCollection
      * object.
      *
      * @param thatPc the second given PermissionCollection