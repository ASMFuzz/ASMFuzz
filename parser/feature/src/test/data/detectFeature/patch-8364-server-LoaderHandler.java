@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -710,7 +710,7 @@ private static Class<?> loadProxyClass(ClassLoader loader, Class<?>[] interfaces
     }
 
     /*
-     * Load Class objects for the names in the interfaces array fron
+     * Load Class objects for the names in the interfaces array from
      * the given class loader.
      *
      * We pass classObjs and nonpublic arrays to avoid needing a
@@ -882,7 +882,7 @@ private static Loader lookupLoader(final URL[] urls,
                  * A matching loader was not found, so create a new class
                  * loader instance for the requested codebase URL path and
                  * parent class loader.  The instance is created within an
-                 * access control context retricted to the permissions
+                 * access control context restricted to the permissions
                  * necessary to load classes from its codebase URL path.
                  */
                 AccessControlContext acc = getLoaderAccessControlContext(urls);