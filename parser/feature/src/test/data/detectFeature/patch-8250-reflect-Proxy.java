@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -898,7 +898,7 @@ private static Class<?> getElementType(Class<?> type) {
         private static final AtomicInteger counter = new AtomicInteger();
 
         /*
-         * Define a dynamic module with a packge named $MODULE which
+         * Define a dynamic module with a package named $MODULE which
          * is unconditionally exported and another package named
          * com.sun.proxy.$MODULE which is encapsulated.
          *