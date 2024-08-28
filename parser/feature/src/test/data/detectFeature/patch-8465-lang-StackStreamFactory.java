@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -376,8 +376,8 @@ private R beginStackWalk() {
         /*
          * Fetches stack frames.
          *
-         * @params batchSize number of elements of the frame  buffers for this batch
-         * @returns number of frames fetched in this batch
+         * @param batchSize number of elements of the frame buffers for this batch
+         * @return number of frames fetched in this batch
          */
         private int fetchStackFrames(int batchSize) {
             int startIndex = frameBuffer.startIndex();