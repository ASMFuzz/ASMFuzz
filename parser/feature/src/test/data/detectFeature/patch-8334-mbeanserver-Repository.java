@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -98,7 +98,7 @@ public interface RegistrationContext {
     /**
      * We use a global reentrant read write lock to protect the repository.
      * This seems safer and more efficient: we are using Maps of Maps,
-     * Guaranteing consistency while using Concurent objects at each level
+     * Guaranteing consistency while using Concurrent objects at each level
      * may be more difficult.
      **/
     private final ReentrantReadWriteLock lock;
@@ -377,7 +377,7 @@ public String[] getDomains() {
      *                can be stored in the repository with that {@code name}.
      *                If {@link RegistrationContext#registering()
      *                context.registering()} throws an exception, the
-     *                operation is abandonned, the MBean is not added to the
+     *                operation is abandoned, the MBean is not added to the
      *                repository, and a {@link RuntimeOperationsException}
      *                is thrown.
      */