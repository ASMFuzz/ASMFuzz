@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2013, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2013, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -86,7 +86,7 @@ abstract class GaloisCounterMode extends CipherSpi {
     // data size when buffer is divided up to aid in intrinsics
     private static final int TRIGGERLEN = 65536;  // 64k
     // x86-64 parallel intrinsic data size
-    private static final int PARALLEL_LEN = 8192;
+    private static final int PARALLEL_LEN = 7680;
     // max data size for x86-64 intrinsic
     private static final int SPLIT_LEN = 1048576;  // 1MB
 