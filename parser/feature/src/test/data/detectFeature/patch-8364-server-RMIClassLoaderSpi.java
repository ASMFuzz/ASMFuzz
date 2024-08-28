@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -151,7 +151,7 @@ public abstract Class<?> loadProxyClass(String codebase,
      * Returns a class loader that loads classes from the given codebase
      * URL path.
      *
-     * <p>If there is a security manger, its <code>checkPermission</code>
+     * <p>If there is a security manager, its <code>checkPermission</code>
      * method will be invoked with a
      * <code>RuntimePermission("getClassLoader")</code> permission;
      * this could result in a <code>SecurityException</code>.