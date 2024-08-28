@@ -295,13 +295,13 @@ synchronized void receivedLast() {
      * This method blocks until input data is available, the end of the
      * stream is detected, or an exception is thrown.
      *
-     * @return   the next byte of data, or {@code -1} if the end of the
-     *           stream is reached.
+     * @return   {@inheritDoc}
      * @throws   IOException  if the pipe is
      *           {@link #connect(java.io.PipedOutputStream) unconnected},
      *           <a href="#BROKEN"> {@code broken}</a>, closed,
      *           or if an I/O error occurs.
      */
+    @Override
     public synchronized int read()  throws IOException {
         if (!connected) {
             throw new IOException("Pipe not connected");
@@ -352,20 +352,17 @@ public synchronized int read()  throws IOException {
      * available, end of the stream has been detected, or an exception is
      * thrown.
      *
-     * @param      b     the buffer into which the data is read.
-     * @param      off   the start offset in the destination array {@code b}
-     * @param      len   the maximum number of bytes read.
-     * @return     the total number of bytes read into the buffer, or
-     *             {@code -1} if there is no more data because the end of
-     *             the stream has been reached.
-     * @throws     NullPointerException If {@code b} is {@code null}.
-     * @throws     IndexOutOfBoundsException If {@code off} is negative,
-     *             {@code len} is negative, or {@code len} is greater than
-     *             {@code b.length - off}
+     * @param      b     {@inheritDoc}
+     * @param      off   {@inheritDoc}
+     * @param      len   {@inheritDoc}
+     * @return     {@inheritDoc}
+     * @throws     NullPointerException {@inheritDoc}
+     * @throws     IndexOutOfBoundsException {@inheritDoc}
      * @throws     IOException if the pipe is <a href="#BROKEN"> {@code broken}</a>,
      *           {@link #connect(java.io.PipedOutputStream) unconnected},
      *           closed, or if an I/O error occurs.
      */
+    @Override
     public synchronized int read(byte[] b, int off, int len)  throws IOException {
         if (b == null) {
             throw new NullPointerException();
@@ -422,9 +419,10 @@ public synchronized int read(byte[] b, int off, int len)  throws IOException {
      *         is {@link #connect(java.io.PipedOutputStream) unconnected}, or
      *         <a href="#BROKEN"> {@code broken}</a>.
      *
-     * @throws IOException  if an I/O error occurs.
+     * @throws IOException  {@inheritDoc}
      * @since  1.0.2
      */
+    @Override
     public synchronized int available() throws IOException {
         if(in < 0)
             return 0;
@@ -437,11 +435,11 @@ else if (in > out)
     }
 
     /**
-     * Closes this piped input stream and releases any system resources
-     * associated with the stream.
+     * {@inheritDoc}
      *
-     * @throws     IOException  if an I/O error occurs.
+     * @throws     IOException  {@inheritDoc}
      */
+    @Override
     public void close()  throws IOException {
         closedByReader = true;
         synchronized (this) {