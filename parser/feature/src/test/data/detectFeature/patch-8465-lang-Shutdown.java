@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -70,11 +70,11 @@ private static class Lock { };
      * be added to the delete on exit list by the application shutdown
      * hooks.
      *
-     * @params slot  the slot in the shutdown hook array, whose element
-     *               will be invoked in order during shutdown
-     * @params registerShutdownInProgress true to allow the hook
-     *               to be registered even if the shutdown is in progress.
-     * @params hook  the hook to be registered
+     * @param slot  the slot in the shutdown hook array, whose element
+     *              will be invoked in order during shutdown
+     * @param registerShutdownInProgress true to allow the hook
+     *              to be registered even if the shutdown is in progress.
+     * @param hook  the hook to be registered
      *
      * @throws IllegalStateException
      *         if registerShutdownInProgress is false and shutdown is in progress; or