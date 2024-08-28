@@ -228,8 +228,9 @@ private void open(String name) throws FileNotFoundException {
      *
      * @return     the next byte of data, or {@code -1} if the end of the
      *             file is reached.
-     * @throws     IOException  if an I/O error occurs.
+     * @throws     IOException {@inheritDoc}
      */
+    @Override
     public int read() throws IOException {
         long comp = Blocker.begin();
         try {
@@ -255,12 +256,13 @@ public int read() throws IOException {
      * stream into an array of bytes. This method blocks until some input
      * is available.
      *
-     * @param      b   the buffer into which the data is read.
+     * @param      b   {@inheritDoc}
      * @return     the total number of bytes read into the buffer, or
      *             {@code -1} if there is no more data because the end of
      *             the file has been reached.
      * @throws     IOException  if an I/O error occurs.
      */
+    @Override
     public int read(byte[] b) throws IOException {
         long comp = Blocker.begin();
         try {
@@ -276,18 +278,15 @@ public int read(byte[] b) throws IOException {
      * blocks until some input is available; otherwise, no
      * bytes are read and {@code 0} is returned.
      *
-     * @param      b     the buffer into which the data is read.
-     * @param      off   the start offset in the destination array {@code b}
-     * @param      len   the maximum number of bytes read.
-     * @return     the total number of bytes read into the buffer, or
-     *             {@code -1} if there is no more data because the end of
-     *             the file has been reached.
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
      */
+    @Override
     public int read(byte[] b, int off, int len) throws IOException {
         long comp = Blocker.begin();
         try {
@@ -297,6 +296,7 @@ public int read(byte[] b, int off, int len) throws IOException {
         }
     }
 
+    @Override
     public byte[] readAllBytes() throws IOException {
         long length = length();
         long position = position();
@@ -339,6 +339,7 @@ public byte[] readAllBytes() throws IOException {
         return (capacity == nread) ? buf : Arrays.copyOf(buf, nread);
     }
 
+    @Override
     public byte[] readNBytes(int len) throws IOException {
         if (len < 0)
             throw new IllegalArgumentException("len < 0");
@@ -378,6 +379,7 @@ public byte[] readNBytes(int len) throws IOException {
     /**
      * {@inheritDoc}
      */
+    @Override
     public long transferTo(OutputStream out) throws IOException {
         long transferred = 0L;
         if (out instanceof FileOutputStream fos) {
@@ -432,11 +434,12 @@ private long position() throws IOException {
      * backing file. Attempting to read from the stream after skipping past
      * the end will result in -1 indicating the end of the file.
      *
-     * @param      n   the number of bytes to be skipped.
+     * @param      n   {@inheritDoc}
      * @return     the actual number of bytes skipped.
      * @throws     IOException  if n is negative, if the stream does not
      *             support seek, or if an I/O error occurs.
      */
+    @Override
     public long skip(long n) throws IOException {
         long comp = Blocker.begin();
         try {
@@ -465,6 +468,7 @@ public long skip(long n) throws IOException {
      * @throws     IOException  if this file input stream has been closed by calling
      *             {@code close} or an I/O error occurs.
      */
+    @Override
     public int available() throws IOException {
         long comp = Blocker.begin();
         try {
@@ -491,10 +495,11 @@ public int available() throws IOException {
      * If cleanup of native resources is needed, other mechanisms such as
      * {@linkplain java.lang.ref.Cleaner} should be used.
      *
-     * @throws     IOException  if an I/O error occurs.
+     * @throws     IOException  {@inheritDoc}
      *
      * @revised 1.4
      */
+    @Override
     public void close() throws IOException {
         if (closed) {
             return;