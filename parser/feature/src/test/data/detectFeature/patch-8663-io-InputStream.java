@@ -173,8 +173,6 @@ public void close() throws IOException {
      * blocks until input data is available, the end of the stream is detected,
      * or an exception is thrown.
      *
-     * <p> A subclass must provide an implementation of this method.
-     *
      * @return     the next byte of data, or {@code -1} if the end of the
      *             stream is reached.
      * @throws     IOException  if an I/O error occurs.
@@ -201,7 +199,8 @@ public void close() throws IOException {
      * leaving elements {@code b[}<i>k</i>{@code ]} through
      * {@code b[b.length-1]} unaffected.
      *
-     * <p> The {@code read(b)} method for class {@code InputStream}
+     * @implSpec
+     * The {@code read(b)} method for class {@code InputStream}
      * has the same effect as: <pre>{@code  read(b, 0, b.length) }</pre>
      *
      * @param      b   the buffer into which the data is read.
@@ -245,7 +244,8 @@ public int read(byte[] b) throws IOException {
      * {@code b[off-1]} and elements {@code b[off+len]} through
      * {@code b[b.length-1]} are unaffected.
      *
-     * <p> The {@code read(b, off, len)} method
+     * @implSpec
+     * The {@code read(b, off, len)} method
      * for class {@code InputStream} simply calls the method
      * {@code read()} repeatedly. If the first such call results in an
      * {@code IOException}, that exception is returned from the call to
@@ -522,7 +522,8 @@ public int readNBytes(byte[] b, int off, int len) throws IOException {
      * returns 0, and no bytes are skipped. Subclasses may handle the negative
      * value differently.
      *
-     * <p> The {@code skip} method implementation of this class creates a
+     * @implSpec
+     * The {@code skip} method implementation of this class creates a
      * byte array and then repeatedly reads into it until {@code n} bytes
      * have been read or the end of the stream has been reached. Subclasses are
      * encouraged to provide a more efficient implementation of this method.
@@ -632,10 +633,12 @@ public void skipNBytes(long n) throws IOException {
      * {@link IOException} if this input stream has been closed by invoking the
      * {@link #close()} method.
      *
-     * <p> The {@code available} method of {@code InputStream} always returns
+     * @implSpec
+     * The {@code available} method of {@code InputStream} always returns
      * {@code 0}.
      *
-     * <p> This method should be overridden by subclasses.
+     * @apiNote
+     * This method should be overridden by subclasses.
      *
      * @return     an estimate of the number of bytes that can be read (or
      *             skipped over) from this input stream without blocking or
@@ -650,7 +653,8 @@ public int available() throws IOException {
      * Closes this input stream and releases any system resources associated
      * with the stream.
      *
-     * <p> The {@code close} method of {@code InputStream} does
+     * @implSpec
+     * The {@code close} method of {@code InputStream} does
      * nothing.
      *
      * @throws     IOException  if an I/O error occurs.
@@ -676,8 +680,8 @@ public void close() throws IOException {}
      *
      * <p> Marking a closed stream should not have any effect on the stream.
      *
-     * <p> The {@code mark} method of {@code InputStream} does
-     * nothing.
+     * @implSpec
+     * The {@code mark} method of {@code InputStream} does nothing.
      *
      * @param   readlimit   the maximum limit of bytes that can be read before
      *                      the mark position becomes invalid.
@@ -721,7 +725,8 @@ public void mark(int readlimit) {}
      *     to subsequent callers of the {@code read} method depend on the
      *     particular type of the input stream. </ul></ul>
      *
-     * <p>The method {@code reset} for class {@code InputStream}
+     * @implSpec
+     * The method {@code reset} for class {@code InputStream}
      * does nothing except throw an {@code IOException}.
      *
      * @throws  IOException  if this stream has not been marked or if the