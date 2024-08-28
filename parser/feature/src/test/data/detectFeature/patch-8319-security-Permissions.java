@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -432,7 +432,7 @@ private void readObject(ObjectInputStream in) throws IOException,
 final class PermissionsEnumerator implements Enumeration<Permission> {
 
     // all the perms
-    private Iterator<PermissionCollection> perms;
+    private final Iterator<PermissionCollection> perms;
     // the current set
     private Enumeration<Permission> permset;
 