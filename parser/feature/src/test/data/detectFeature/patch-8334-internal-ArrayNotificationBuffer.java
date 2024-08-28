@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -437,7 +437,7 @@ public void dispose() {
                     if (isDisposed()) {
                         if (logger.debugOn())
                             logger.debug("fetchNotifications",
-                                         "dispose callled, no wait");
+                                         "dispose called, no wait");
                         return new NotificationResult(earliestSequenceNumber(),
                                                   nextSequenceNumber(),
                                                   new TargetedNotification[0]);