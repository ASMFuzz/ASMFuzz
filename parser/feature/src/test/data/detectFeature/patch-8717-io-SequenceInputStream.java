@@ -121,10 +121,11 @@ private void peekNextStream() {
      *           skipped over) from the current underlying input stream
      *           without blocking or {@code 0} if this input stream
      *           has been closed by invoking its {@link #close()} method
-     * @throws   IOException  if an I/O error occurs.
+     * @throws   IOException {@inheritDoc}
      *
      * @since    1.1
      */
+    @Override
     public int available() throws IOException {
         if (in == null) {
             return 0; // no way to signal EOF from available()
@@ -133,23 +134,18 @@ public int available() throws IOException {
     }
 
     /**
-     * Reads the next byte of data from this input stream. The byte is
-     * returned as an {@code int} in the range {@code 0} to
-     * {@code 255}. If no byte is available because the end of the
-     * stream has been reached, the value {@code -1} is returned.
-     * This method blocks until input data is available, the end of the
-     * stream is detected, or an exception is thrown.
+     * {@inheritDoc}
      * <p>
      * This method
      * tries to read one character from the current substream. If it
      * reaches the end of the stream, it calls the {@code close}
      * method of the current substream and begins reading from the next
      * substream.
      *
-     * @return     the next byte of data, or {@code -1} if the end of the
-     *             stream is reached.
+     * @return     {@inheritDoc}
      * @throws     IOException  if an I/O error occurs.
      */
+    @Override
     public int read() throws IOException {
         while (in != null) {
             int c = in.read();
@@ -189,6 +185,7 @@ public int read() throws IOException {
      *             greater than {@code b.length - off}
      * @throws     IOException  if an I/O error occurs.
      */
+    @Override
     public int read(byte[] b, int off, int len) throws IOException {
         if (in == null) {
             return -1;
@@ -210,8 +207,7 @@ public int read(byte[] b, int off, int len) throws IOException {
     }
 
     /**
-     * Closes this input stream and releases any system resources
-     * associated with the stream.
+     * {@inheritDoc}
      * A closed {@code SequenceInputStream}
      * cannot  perform input operations and cannot
      * be reopened.
@@ -221,8 +217,9 @@ public int read(byte[] b, int off, int len) throws IOException {
      * are requested from the enumeration and closed
      * before the {@code close} method returns.
      *
-     * @throws     IOException  if an I/O error occurs.
+     * @throws     IOException {@inheritDoc}
      */
+    @Override
     public void close() throws IOException {
         IOException ioe = null;
         while (in != null) {