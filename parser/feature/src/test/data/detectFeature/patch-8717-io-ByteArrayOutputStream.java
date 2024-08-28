@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -107,6 +107,7 @@ private void ensureCapacity(int minCapacity) {
      *
      * @param   b   the byte to be written.
      */
+    @Override
     public synchronized void write(int b) {
         ensureCapacity(count + 1);
         buf[count] = (byte) b;
@@ -117,14 +118,15 @@ public synchronized void write(int b) {
      * Writes {@code len} bytes from the specified byte array
      * starting at offset {@code off} to this {@code ByteArrayOutputStream}.
      *
-     * @param   b     the data.
-     * @param   off   the start offset in the data.
-     * @param   len   the number of bytes to write.
+     * @param   b     {@inheritDoc}
+     * @param   off   {@inheritDoc}
+     * @param   len   {@inheritDoc}
      * @throws  NullPointerException if {@code b} is {@code null}.
      * @throws  IndexOutOfBoundsException if {@code off} is negative,
      * {@code len} is negative, or {@code len} is greater than
      * {@code b.length - off}
      */
+    @Override
     public synchronized void write(byte[] b, int off, int len) {
         Objects.checkFromIndexSize(off, len, b.length);
         ensureCapacity(count + len);
@@ -212,6 +214,7 @@ public synchronized int size() {
      * @return String decoded from the buffer's contents.
      * @since  1.1
      */
+    @Override
     public synchronized String toString() {
         return new String(buf, 0, count);
     }
@@ -306,6 +309,7 @@ public synchronized String toString(int hibyte) {
      * this class can be called after the stream has been closed without
      * generating an {@code IOException}.
      */
+    @Override
     public void close() throws IOException {
     }
 