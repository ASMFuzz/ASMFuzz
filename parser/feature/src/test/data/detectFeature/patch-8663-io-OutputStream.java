@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -102,9 +102,6 @@ public void close() {
      * to the output stream. The byte to be written is the eight
      * low-order bits of the argument {@code b}. The 24
      * high-order bits of {@code b} are ignored.
-     * <p>
-     * Subclasses of {@code OutputStream} must provide an
-     * implementation for this method.
      *
      * @param      b   the {@code byte}.
      * @throws     IOException  if an I/O error occurs. In particular,
@@ -135,11 +132,7 @@ public void write(byte[] b) throws IOException {
      * output stream in order; element {@code b[off]} is the first
      * byte written and {@code b[off+len-1]} is the last byte written
      * by this operation.
-     * <p>
-     * The {@code write} method of {@code OutputStream} calls
-     * the write method of one argument on each of the bytes to be
-     * written out. Subclasses are encouraged to override this method and
-     * provide a more efficient implementation.
+     *
      * <p>
      * If {@code b} is {@code null}, a
      * {@code NullPointerException} is thrown.
@@ -148,6 +141,15 @@ public void write(byte[] b) throws IOException {
      * {@code off+len} is greater than the length of the array
      * {@code b}, then an {@code IndexOutOfBoundsException} is thrown.
      *
+     * @implSpec
+     * The {@code write} method of {@code OutputStream} calls
+     * the write method of one argument on each of the bytes to be
+     * written out.
+     *
+     * @apiNote
+     * Subclasses are encouraged to override this method and
+     * provide a more efficient implementation.
+     *
      * @param      b     the data.
      * @param      off   the start offset in the data.
      * @param      len   the number of bytes to write.
@@ -176,7 +178,8 @@ public void write(byte[] b, int off, int len) throws IOException {
      * stream guarantees only that bytes previously written to the stream are
      * passed to the operating system for writing; it does not guarantee that
      * they are actually written to a physical device such as a disk drive.
-     * <p>
+     *
+     * @implSpec
      * The {@code flush} method of {@code OutputStream} does nothing.
      *
      * @throws     IOException  if an I/O error occurs.
@@ -189,7 +192,8 @@ public void flush() throws IOException {
      * associated with this stream. The general contract of {@code close}
      * is that it closes the output stream. A closed stream cannot perform
      * output operations and cannot be reopened.
-     * <p>
+     *
+     * @implSpec
      * The {@code close} method of {@code OutputStream} does nothing.
      *
      * @throws     IOException  if an I/O error occurs.