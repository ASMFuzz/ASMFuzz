@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -183,7 +183,7 @@ public long getFrameLength() {
      * stream's frame size must be one byte, or an {@code IOException} will be
      * thrown.
      *
-     * @return the next byte of data, or -1 if the end of the stream is reached
+     * @return {@inheritDoc}
      * @throws IOException if an input or output error occurs
      * @see #read(byte[], int, int)
      * @see #read(byte[])
@@ -214,9 +214,8 @@ public int read() throws IOException {
      * of the array is not an integral number of frames, a maximum of
      * {@code b.length - (b.length % frameSize)} bytes will be read.
      *
-     * @param  b the buffer into which the data is read
-     * @return the total number of bytes read into the buffer, or -1 if there is
-     *         no more data because the end of the stream has been reached
+     * @param  b {@inheritDoc}
+     * @return {@inheritDoc}
      * @throws IOException if an input or output error occurs
      * @see #read(byte[], int, int)
      * @see #read()
@@ -235,12 +234,10 @@ public int read(byte[] b) throws IOException {
      * does not specify an integral number of frames, a maximum of
      * {@code len - (len % frameSize)} bytes will be read.
      *
-     * @param  b the buffer into which the data is read
-     * @param  off the offset, from the beginning of array {@code b}, at which
-     *         the data will be written
-     * @param  len the maximum number of bytes to read
-     * @return the total number of bytes read into the buffer, or -1 if there is
-     *         no more data because the end of the stream has been reached
+     * @param  b {@inheritDoc}
+     * @param  off {@inheritDoc}
+     * @param  len {@inheritDoc}
+     * @return {@inheritDoc}
      * @throws IOException if an input or output error occurs
      * @see #read(byte[])
      * @see #read()