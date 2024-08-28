@@ -58,20 +58,12 @@ protected FilterInputStream(InputStream in) {
     }
 
     /**
-     * Reads the next byte of data from this input stream. The value
-     * byte is returned as an {@code int} in the range
-     * {@code 0} to {@code 255}. If no byte is available
-     * because the end of the stream has been reached, the value
-     * {@code -1} is returned. This method blocks until input data
-     * is available, the end of the stream is detected, or an exception
-     * is thrown.
-     *
+     * {@inheritDoc}
      * @implSpec
      * This method simply performs {@code in.read()} and returns the result.
      *
-     * @return     the next byte of data, or {@code -1} if the end of the
-     *             stream is reached.
-     * @throws     IOException  if an I/O error occurs.
+     * @return     {@inheritDoc}
+     * @throws     IOException  {@inheritDoc}
      * @see        java.io.FilterInputStream#in
      */
     @Override
@@ -93,10 +85,8 @@ public int read() throws IOException {
      * depend on the implementation strategy actually
      * used.
      *
-     * @param      b   the buffer into which the data is read.
-     * @return     the total number of bytes read into the buffer, or
-     *             {@code -1} if there is no more data because the end of
-     *             the stream has been reached.
+     * @param      b   {@inheritDoc}
+     * @return     {@inheritDoc}
      * @throws     IOException  if an I/O error occurs.
      * @see        java.io.FilterInputStream#read(byte[], int, int)
      */
@@ -115,16 +105,12 @@ public int read(byte[] b) throws IOException {
      * This method simply performs {@code in.read(b, off, len)}
      * and returns the result.
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
      * @throws     IOException  if an I/O error occurs.
      * @see        java.io.FilterInputStream#in
      */
@@ -143,7 +129,7 @@ public int read(byte[] b, int off, int len) throws IOException {
      * @implSpec
      * This method simply performs {@code in.skip(n)} and returns the result.
      *
-     * @param      n   the number of bytes to be skipped.
+     * @param      n   {@inheritDoc}
      * @return     the actual number of bytes skipped.
      * @throws     IOException  if {@code in.skip(n)} throws an IOException.
      */
@@ -164,21 +150,19 @@ public long skip(long n) throws IOException {
      *
      * @return     an estimate of the number of bytes that can be read (or
      *             skipped over) from this input stream without blocking.
-     * @throws     IOException  if an I/O error occurs.
+     * @throws     IOException  {@inheritDoc}
      */
     @Override
     public int available() throws IOException {
         return in.available();
     }
 
     /**
-     * Closes this input stream and releases any system resources
-     * associated with the stream.
-     *
+     * {@inheritDoc}
      * @implSpec
      * This method simply performs {@code in.close()}.
      *
-     * @throws     IOException  if an I/O error occurs.
+     * @throws     IOException  {@inheritDoc}
      * @see        java.io.FilterInputStream#in
      */
     @Override
@@ -198,8 +182,7 @@ public void close() throws IOException {
      * @implSpec
      * This method simply performs {@code in.mark(readlimit)}.
      *
-     * @param   readlimit   the maximum limit of bytes that can be read before
-     *                      the mark position becomes invalid.
+     * @param   readlimit   {@inheritDoc}
      * @see     java.io.FilterInputStream#in
      * @see     java.io.FilterInputStream#reset()
      */
@@ -224,8 +207,7 @@ public void mark(int readlimit) {
      * @implSpec
      * This method simply performs {@code in.reset()}.
      *
-     * @throws     IOException  if the stream has not been marked or if the
-     *               mark has been invalidated.
+     * @throws     IOException  {@inheritDoc}
      * @see        java.io.FilterInputStream#in
      * @see        java.io.FilterInputStream#mark(int)
      */