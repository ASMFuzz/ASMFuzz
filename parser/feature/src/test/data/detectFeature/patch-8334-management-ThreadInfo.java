@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -333,7 +333,7 @@ public Thread.State getThreadState() {
      *
      * <p>The Java virtual machine may measure the time with a high
      * resolution timer.  This statistic is reset when
-     * the thread contention monitoring is reenabled.
+     * the thread contention monitoring is re-enabled.
      *
      * @return the approximate accumulated elapsed time in milliseconds
      * that a thread entered the {@code BLOCKED} state;
@@ -377,7 +377,7 @@ public long getBlockedCount() {
      *
      * <p>The Java virtual machine may measure the time with a high
      * resolution timer.  This statistic is reset when
-     * the thread contention monitoring is reenabled.
+     * the thread contention monitoring is re-enabled.
      *
      * @return the approximate accumulated elapsed time in milliseconds
      * that a thread has been in the {@code WAITING} or