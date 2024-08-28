@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -79,7 +79,7 @@ public FilterOutputStream(OutputStream out) {
      * <p>
      * Implements the abstract {@code write} method of {@code OutputStream}.
      *
-     * @param      b   the {@code byte}.
+     * @param      b   {@inheritDoc}
      * @throws     IOException  if an I/O error occurs.
      */
     @Override
@@ -89,18 +89,18 @@ public void write(int b) throws IOException {
 
     /**
      * Writes {@code b.length} bytes to this output stream.
-     * <p>
+     * @implSpec
      * The {@code write} method of {@code FilterOutputStream}
      * calls its {@code write} method of three arguments with the
      * arguments {@code b}, {@code 0}, and
      * {@code b.length}.
-     * <p>
-     * Note that this method does not call the one-argument
+     * @implNote
+     * Note that this method does <em>not</em> call the one-argument
      * {@code write} method of its underlying output stream with
      * the single argument {@code b}.
      *
      * @param      b   the data to be written.
-     * @throws     IOException  if an I/O error occurs.
+     * @throws     IOException  {@inheritDoc}
      * @see        java.io.FilterOutputStream#write(byte[], int, int)
      */
     @Override
@@ -112,19 +112,19 @@ public void write(byte[] b) throws IOException {
      * Writes {@code len} bytes from the specified
      * {@code byte} array starting at offset {@code off} to
      * this output stream.
-     * <p>
+     * @implSpec
      * The {@code write} method of {@code FilterOutputStream}
      * calls the {@code write} method of one argument on each
      * {@code byte} to output.
-     * <p>
+     * @implNote
      * Note that this method does not call the {@code write} method
      * of its underlying output stream with the same arguments. Subclasses
      * of {@code FilterOutputStream} should provide a more efficient
      * implementation of this method.
      *
-     * @param      b     the data.
-     * @param      off   the start offset in the data.
-     * @param      len   the number of bytes to write.
+     * @param      b     {@inheritDoc}
+     * @param      off   {@inheritDoc}
+     * @param      len   {@inheritDoc}
      * @throws     IOException  if an I/O error occurs.
      * @see        java.io.FilterOutputStream#write(int)
      */
@@ -141,11 +141,11 @@ public void write(byte[] b, int off, int len) throws IOException {
     /**
      * Flushes this output stream and forces any buffered output bytes
      * to be written out to the stream.
-     * <p>
+     * @implSpec
      * The {@code flush} method of {@code FilterOutputStream}
      * calls the {@code flush} method of its underlying output stream.
      *
-     * @throws     IOException  if an I/O error occurs.
+     * @throws     IOException  {@inheritDoc}
      * @see        java.io.FilterOutputStream#out
      */
     @Override
@@ -156,7 +156,7 @@ public void flush() throws IOException {
     /**
      * Closes this output stream and releases any system resources
      * associated with the stream.
-     * <p>
+     * @implSpec
      * When not already closed, the {@code close} method of {@code
      * FilterOutputStream} calls its {@code flush} method, and then
      * calls the {@code close} method of its underlying output stream.