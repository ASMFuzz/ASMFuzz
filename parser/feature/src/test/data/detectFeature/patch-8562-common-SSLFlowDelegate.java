@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -781,6 +781,7 @@ private void processData() {
                                 + hsTriggered() + ", needWrap:" + needWrap());
 
                 while (Utils.synchronizedRemaining(writeList) > 0 || hsTriggered() || needWrap()) {
+                    if (scheduler.isStopped()) return;
                     ByteBuffer[] outbufs = writeList.toArray(Utils.EMPTY_BB_ARRAY);
                     EngineResult result = wrapBuffers(outbufs);
                     if (debugw.on())