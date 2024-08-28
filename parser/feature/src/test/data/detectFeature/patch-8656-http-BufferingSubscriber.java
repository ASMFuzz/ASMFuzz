@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -61,7 +61,7 @@ public class BufferingSubscriber<T> implements TrustedSubscriber<T>
     /** The internal buffers holding the buffered data. */
     private ArrayList<ByteBuffer> internalBuffers;
     /** The actual accumulated remaining bytes in internalBuffers. */
-    private int accumulatedBytes;
+    private long accumulatedBytes;
 
     /** Holds the Throwable from upstream's onError. */
     private volatile Throwable throwable;