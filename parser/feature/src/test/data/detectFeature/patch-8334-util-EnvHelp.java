@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -267,7 +267,7 @@ public static Throwable getCause(Throwable t) {
     public static int getNotifBufferSize(Map<String, ?> env) {
         int defaultQueueSize = 1000; // default value
 
-        // keep it for the compability for the fix:
+        // keep it for the compatibility for the fix:
         // 6174229: Environment parameter should be notification.buffer.size
         // instead of buffer.size
         final String oldP = "jmx.remote.x.buffer.size";