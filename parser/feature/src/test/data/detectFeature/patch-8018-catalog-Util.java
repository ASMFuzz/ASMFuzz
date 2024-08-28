@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -74,25 +74,9 @@ class Util {
      * @return the resolved systemId if a match is found, null otherwise
      */
     static String resolve(CatalogImpl catalog, String publicId, String systemId) {
-        String resolvedSystemId = null;
-
         //search the current catalog
         catalog.reset();
-        if (systemId != null) {
-            /*
-             If a system identifier is specified, it is used no matter how
-             prefer is set.
-             */
-            resolvedSystemId = catalog.matchSystem(systemId);
-        }
-
-        if (resolvedSystemId == null && publicId != null) {
-            resolvedSystemId = catalog.matchPublic(publicId);
-        }
-
-        if (resolvedSystemId == null && systemId != null) {
-            resolvedSystemId = catalog.matchURI(systemId);
-        }
+        String resolvedSystemId = catalog.resolve(publicId, systemId);
 
         //mark the catalog as having been searched before trying alternatives
         catalog.markAsSearched();