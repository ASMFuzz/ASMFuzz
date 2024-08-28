@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -51,8 +51,8 @@
  * @test
  * @bug 8219014 8245121
  * @summary Ensure that a bulk put of a buffer into another is correct.
- * @compile --enable-preview -source ${jdk.version} BulkPutBuffer.java
- * @run testng/othervm --enable-preview BulkPutBuffer
+ * @compile BulkPutBuffer.java
+ * @run testng/othervm BulkPutBuffer
  */
 public class BulkPutBuffer {
     static final long SEED = System.nanoTime();