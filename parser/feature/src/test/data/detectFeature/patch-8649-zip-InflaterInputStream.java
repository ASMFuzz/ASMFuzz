@@ -264,29 +264,31 @@ public boolean markSupported() {
     /**
      * Marks the current position in this input stream.
      *
-     * <p> The {@code mark} method of {@code InflaterInputStream}
+     * @implSpec The {@code mark} method of {@code InflaterInputStream}
      * does nothing.
      *
      * @param   readlimit   the maximum limit of bytes that can be read before
      *                      the mark position becomes invalid.
      * @see     java.io.InputStream#reset()
      */
-    public synchronized void mark(int readlimit) {
+    @Override
+    public void mark(int readlimit) {
     }
 
     /**
      * Repositions this stream to the position at the time the
      * {@code mark} method was last called on this input stream.
      *
-     * <p> The method {@code reset} for class
+     * @implSpec The method {@code reset} for class
      * {@code InflaterInputStream} does nothing except throw an
      * {@code IOException}.
      *
      * @throws     IOException  if this method is invoked.
      * @see     java.io.InputStream#mark(int)
      * @see     java.io.IOException
      */
-    public synchronized void reset() throws IOException {
+    @Override
+    public void reset() throws IOException {
         throw new IOException("mark/reset not supported");
     }
 }