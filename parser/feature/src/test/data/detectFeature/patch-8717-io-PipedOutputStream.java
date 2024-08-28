@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1995, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1995, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -114,6 +114,7 @@ public synchronized void connect(PipedInputStream snk) throws IOException {
      *          {@link #connect(java.io.PipedInputStream) unconnected},
      *          closed, or if an I/O error occurs.
      */
+    @Override
     public void write(int b)  throws IOException {
         var sink = this.sink;
         if (sink == null) {
@@ -128,13 +129,14 @@ public void write(int b)  throws IOException {
      * This method blocks until all the bytes are written to the output
      * stream.
      *
-     * @param   b     the data.
-     * @param   off   the start offset in the data.
-     * @param   len   the number of bytes to write.
+     * @param   b     {@inheritDoc}
+     * @param   off   {@inheritDoc}
+     * @param   len   {@inheritDoc}
      * @throws  IOException if the pipe is <a href=#BROKEN> broken</a>,
      *          {@link #connect(java.io.PipedInputStream) unconnected},
      *          closed, or if an I/O error occurs.
      */
+    @Override
     public void write(byte[] b, int off, int len) throws IOException {
         var sink = this.sink;
         if (sink == null) {
@@ -155,8 +157,9 @@ public void write(byte[] b, int off, int len) throws IOException {
      * to be written out.
      * This will notify any readers that bytes are waiting in the pipe.
      *
-     * @throws    IOException if an I/O error occurs.
+     * @throws    IOException {@inheritDoc}
      */
+    @Override
     public synchronized void flush() throws IOException {
         if (sink != null) {
             synchronized (sink) {
@@ -170,8 +173,9 @@ public synchronized void flush() throws IOException {
      * associated with this stream. This stream may no longer be used for
      * writing bytes.
      *
-     * @throws     IOException  if an I/O error occurs.
+     * @throws     IOException  {@inheritDoc}
      */
+    @Override
     public void close()  throws IOException {
         var sink = this.sink;
         if (sink != null) {