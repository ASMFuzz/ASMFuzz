@@ -689,6 +689,7 @@ protected void writeClassDescriptor(ObjectStreamClass desc)
      * @param   val the byte to be written to the stream
      * @throws  IOException If an I/O error has occurred.
      */
+    @Override
     public void write(int val) throws IOException {
         bout.write(val);
     }
@@ -700,6 +701,7 @@ public void write(int val) throws IOException {
      * @param   buf the data to be written
      * @throws  IOException If an I/O error has occurred.
      */
+    @Override
     public void write(byte[] buf) throws IOException {
         bout.write(buf, 0, buf.length, false);
     }
@@ -710,8 +712,9 @@ public void write(byte[] buf) throws IOException {
      * @param   buf the data to be written
      * @param   off the start offset in the data
      * @param   len the number of bytes that are written
-     * @throws  IOException If an I/O error has occurred.
+     * @throws  IOException {@inheritDoc}
      */
+    @Override
     public void write(byte[] buf, int off, int len) throws IOException {
         if (buf == null) {
             throw new NullPointerException();
@@ -724,8 +727,9 @@ public void write(byte[] buf, int off, int len) throws IOException {
      * Flushes the stream. This will write any buffered output bytes and flush
      * through to the underlying stream.
      *
-     * @throws  IOException If an I/O error has occurred.
+     * @throws  IOException {@inheritDoc}
      */
+    @Override
     public void flush() throws IOException {
         bout.flush();
     }
@@ -747,6 +751,7 @@ protected void drain() throws IOException {
      *
      * @throws  IOException If an I/O error has occurred.
      */
+    @Override
     public void close() throws IOException {
         flush();
         clear();