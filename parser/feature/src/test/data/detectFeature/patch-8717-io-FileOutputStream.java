@@ -314,6 +314,7 @@ private void open(String name, boolean append) throws FileNotFoundException {
      * @param      b   the byte to be written.
      * @throws     IOException  if an I/O error occurs.
      */
+    @Override
     public void write(int b) throws IOException {
         boolean append = fdAccess.getAppend(fd);
         long comp = Blocker.begin();
@@ -340,9 +341,10 @@ private native void writeBytes(byte[] b, int off, int len, boolean append)
      * Writes {@code b.length} bytes from the specified byte array
      * to this file output stream.
      *
-     * @param      b   the data.
-     * @throws     IOException  if an I/O error occurs.
+     * @param      b   {@inheritDoc}
+     * @throws     IOException  {@inheritDoc}
      */
+    @Override
     public void write(byte[] b) throws IOException {
         boolean append = fdAccess.getAppend(fd);
         long comp = Blocker.begin();
@@ -357,11 +359,12 @@ public void write(byte[] b) throws IOException {
      * Writes {@code len} bytes from the specified byte array
      * starting at offset {@code off} to this file output stream.
      *
-     * @param      b     the data.
-     * @param      off   the start offset in the data.
-     * @param      len   the number of bytes to write.
+     * @param      b     {@inheritDoc}
+     * @param      off   {@inheritDoc}
+     * @param      len   {@inheritDoc}
      * @throws     IOException  if an I/O error occurs.
      */
+    @Override
     public void write(byte[] b, int off, int len) throws IOException {
         boolean append = fdAccess.getAppend(fd);
         long comp = Blocker.begin();
@@ -392,6 +395,7 @@ public void write(byte[] b, int off, int len) throws IOException {
      *
      * @revised 1.4
      */
+    @Override
     public void close() throws IOException {
         if (closed) {
             return;