@@ -139,9 +139,9 @@ public ByteArrayInputStream(byte[] buf, int offset, int length) {
      * This {@code read} method
      * cannot block.
      *
-     * @return  the next byte of data, or {@code -1} if the end of the
-     *          stream has been reached.
+     * @return  {@inheritDoc}
      */
+    @Override
     public synchronized int read() {
         return (pos < count) ? (buf[pos++] & 0xff) : -1;
     }
@@ -162,17 +162,14 @@ public synchronized int read() {
      * <p>
      * This {@code read} method cannot block.
      *
-     * @param   b     the buffer into which the data is read.
-     * @param   off   the start offset in the destination array {@code b}
-     * @param   len   the maximum number of bytes read.
-     * @return  the total number of bytes read into the buffer, or
-     *          {@code -1} if there is no more data because the end of
-     *          the stream has been reached.
-     * @throws  NullPointerException If {@code b} is {@code null}.
-     * @throws  IndexOutOfBoundsException If {@code off} is negative,
-     * {@code len} is negative, or {@code len} is greater than
-     * {@code b.length - off}
+     * @param   b     {@inheritDoc}
+     * @param   off   {@inheritDoc}
+     * @param   len   {@inheritDoc}
+     * @return  {@inheritDoc}
+     * @throws  NullPointerException {@inheritDoc}
+     * @throws  IndexOutOfBoundsException {@inheritDoc}
      */
+    @Override
     public synchronized int read(byte[] b, int off, int len) {
         Objects.checkFromIndexSize(off, len, b.length);
 
@@ -192,17 +189,20 @@ public synchronized int read(byte[] b, int off, int len) {
         return len;
     }
 
+    @Override
     public synchronized byte[] readAllBytes() {
         byte[] result = Arrays.copyOfRange(buf, pos, count);
         pos = count;
         return result;
     }
 
+    @Override
     public int readNBytes(byte[] b, int off, int len) {
         int n = read(b, off, len);
         return n == -1 ? 0 : n;
     }
 
+    @Override
     public synchronized long transferTo(OutputStream out) throws IOException {
         int len = count - pos;
         out.write(buf, pos, len);
@@ -219,9 +219,10 @@ public synchronized long transferTo(OutputStream out) throws IOException {
      * The value {@code k} is added into {@code pos}
      * and {@code k} is returned.
      *
-     * @param   n   the number of bytes to be skipped.
+     * @param   n   {@inheritDoc}
      * @return  the actual number of bytes skipped.
      */
+    @Override
     public synchronized long skip(long n) {
         long k = count - pos;
         if (n < k) {
@@ -242,17 +243,20 @@ public synchronized long skip(long n) {
      * @return  the number of remaining bytes that can be read (or skipped
      *          over) from this input stream without blocking.
      */
+    @Override
     public synchronized int available() {
         return count - pos;
     }
 
     /**
-     * Tests if this {@code InputStream} supports mark/reset. The
-     * {@code markSupported} method of {@code ByteArrayInputStream}
+     * Tests if this {@code InputStream} supports mark/reset.
+     * @implSpec
+     * The {@code markSupported} method of {@code ByteArrayInputStream}
      * always returns {@code true}.
-     *
+     * @return true
      * @since   1.1
      */
+    @Override
     public boolean markSupported() {
         return true;
     }
@@ -272,6 +276,7 @@ public boolean markSupported() {
      *
      * @since   1.1
      */
+    @Override
     public void mark(int readAheadLimit) {
         mark = pos;
     }
@@ -281,6 +286,7 @@ public void mark(int readAheadLimit) {
      * is 0 unless another position was marked or an offset was specified
      * in the constructor.
      */
+    @Override
     public synchronized void reset() {
         pos = mark;
     }
@@ -290,7 +296,7 @@ public synchronized void reset() {
      * this class can be called after the stream has been closed without
      * generating an {@code IOException}.
      */
+    @Override
     public void close() throws IOException {
     }
-
 }