@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -177,7 +177,9 @@ public int read() throws IOException {
      * @param      off   the start offset in array {@code b}
      *                   at which the data is written.
      * @param      len   the maximum number of bytes read.
-     * @return     int   the number of bytes read.
+     * @return     the total number of bytes read into the buffer, or
+     *             {@code -1} if there is no more data because the end of
+     *             the last contained stream has been reached.
      * @throws     NullPointerException If {@code b} is {@code null}.
      * @throws     IndexOutOfBoundsException If {@code off} is negative,
      *             {@code len} is negative, or {@code len} is