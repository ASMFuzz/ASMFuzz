@@ -1017,8 +1017,9 @@ protected ObjectStreamClass readClassDescriptor()
      * Reads a byte of data. This method will block if no input is available.
      *
      * @return  the byte read, or -1 if the end of the stream is reached.
-     * @throws  IOException If an I/O error has occurred.
+     * @throws  IOException {@inheritDoc}
      */
+    @Override
     public int read() throws IOException {
         return bin.read();
     }
@@ -1041,6 +1042,7 @@ public int read() throws IOException {
      * @throws  IOException If an I/O error has occurred.
      * @see java.io.DataInputStream#readFully(byte[],int,int)
      */
+    @Override
     public int read(byte[] buf, int off, int len) throws IOException {
         if (buf == null) {
             throw new NullPointerException();
@@ -1056,16 +1058,17 @@ public int read(byte[] buf, int off, int len) throws IOException {
      * @throws  IOException if there are I/O errors while reading from the
      *          underlying {@code InputStream}
      */
+    @Override
     public int available() throws IOException {
         return bin.available();
     }
 
     /**
-     * Closes the input stream. Must be called to release any resources
-     * associated with the stream.
+     * {@inheritDoc}
      *
-     * @throws  IOException If an I/O error has occurred.
+     * @throws  IOException {@inheritDoc}
      */
+    @Override
     public void close() throws IOException {
         /*
          * Even if stream already closed, propagate redundant close to
@@ -1225,6 +1228,7 @@ public void readFully(byte[] buf, int off, int len) throws IOException {
      * @return  the actual number of bytes skipped.
      * @throws  IOException If an I/O error has occurred.
      */
+    @Override
     public int skipBytes(int len) throws IOException {
         return bin.skipBytes(len);
     }