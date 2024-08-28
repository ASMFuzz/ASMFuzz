@@ -79,34 +79,34 @@ public StringBufferInputStream(String s) {
      * {@code 0} to {@code 255}. If no byte is available
      * because the end of the stream has been reached, the value
      * {@code -1} is returned.
-     * <p>
+     *
+     * @implSpec
      * The {@code read} method of
      * {@code StringBufferInputStream} cannot block. It returns the
      * low eight bits of the next character in this input stream's buffer.
      *
-     * @return     the next byte of data, or {@code -1} if the end of the
-     *             stream is reached.
+     * @return     {@inheritDoc}
      */
+    @Override
     public synchronized int read() {
         return (pos < count) ? (buffer.charAt(pos++) & 0xFF) : -1;
     }
 
     /**
      * Reads up to {@code len} bytes of data from this input stream
      * into an array of bytes.
-     * <p>
+     * @implSpec
      * The {@code read} method of
      * {@code StringBufferInputStream} cannot block. It copies the
      * low eight bits from the characters in this input stream's buffer into
      * the byte array argument.
      *
-     * @param      b     the buffer into which the data is read.
-     * @param      off   the start offset of the data.
-     * @param      len   the maximum number of bytes read.
-     * @return     the total number of bytes read into the buffer, or
-     *             {@code -1} if there is no more data because the end of
-     *             the stream has been reached.
+     * @param      b     {@inheritDoc}
+     * @param      off   {@inheritDoc}
+     * @param      len   {@inheritDoc}
+     * @return     {@inheritDoc}
      */
+    @Override
     @SuppressWarnings("deprecation")
     public synchronized int read(byte[] b, int off, int len) {
         if (b == null) {
@@ -135,9 +135,10 @@ public synchronized int read(byte[] b, int off, int len) {
      * Skips {@code n} bytes of input from this input stream. Fewer
      * bytes might be skipped if the end of the input stream is reached.
      *
-     * @param      n   the number of bytes to be skipped.
+     * @param      n   {@inheritDoc}
      * @return     the actual number of bytes skipped.
      */
+    @Override
     public synchronized long skip(long n) {
         if (n < 0) {
             return 0;
@@ -156,6 +157,7 @@ public synchronized long skip(long n) {
      * @return     the value of {@code count - pos}, which is the
      *             number of bytes remaining to be read from the input buffer.
      */
+    @Override
     public synchronized int available() {
         return count - pos;
     }
@@ -164,6 +166,7 @@ public synchronized int available() {
      * Resets the input stream to begin reading from the first character
      * of this input stream's underlying buffer.
      */
+    @Override
     public synchronized void reset() {
         pos = 0;
     }