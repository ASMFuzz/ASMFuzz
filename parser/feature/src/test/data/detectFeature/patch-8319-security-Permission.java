@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -71,7 +71,7 @@ public abstract class Permission implements Guard, java.io.Serializable {
     /**
      * The permission name.
      */
-    private String name;
+    private final String name;
 
     /**
      * Constructs a permission with the specified name.
@@ -116,7 +116,7 @@ public void checkGuard(Object object) throws SecurityException {
      * only ones that can impose semantics on a Permission object.
      *
      * <p>The {@code implies} method is used by the AccessController to determine
-     * whether or not a requested permission is implied by another permission that
+     * whether a requested permission is implied by another permission that
      * is known to be valid in the current execution context.
      *
      * @param permission the permission to check against.
@@ -207,7 +207,7 @@ public final String getName() {
      * If null is returned,
      * then the caller of this method is free to store permissions of this
      * type in any PermissionCollection they choose (one that uses a Hashtable,
-     * one that uses a Vector, etc).
+     * one that uses a Vector, etc.).
      *
      * @return a new PermissionCollection object for this type of Permission, or
      * null if one is not defined.