@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -324,7 +324,7 @@ public static Class<?> loadProxyClass(String codebase, String[] interfaces,
      * {@link RMIClassLoaderSpi#getClassLoader(String)} method
      * of the provider instance, passing <code>codebase</code> as the argument.
      *
-     * <p>If there is a security manger, its <code>checkPermission</code>
+     * <p>If there is a security manager, its <code>checkPermission</code>
      * method will be invoked with a
      * <code>RuntimePermission("getClassLoader")</code> permission;
      * this could result in a <code>SecurityException</code>.