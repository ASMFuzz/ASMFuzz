@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -283,7 +283,7 @@ public static Duration ofNanos(long nanos) {
         long secs = nanos / NANOS_PER_SECOND;
         int nos = (int) (nanos % NANOS_PER_SECOND);
         if (nos < 0) {
-            nos += NANOS_PER_SECOND;
+            nos += (int) NANOS_PER_SECOND;
             secs--;
         }
         return create(secs, nos);