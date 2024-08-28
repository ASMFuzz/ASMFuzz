@@ -673,6 +673,9 @@ public abstract SSLEngineResult wrap(ByteBuffer [] srcs, int offset,
      * @throws  IllegalStateException if the client/server mode
      *          has not yet been set.
      * @see     #unwrap(ByteBuffer, ByteBuffer[], int, int)
+     *
+     * @implNote The data in {@code src} may be modified during the decryption
+     * process.
      */
     public SSLEngineResult unwrap(ByteBuffer src,
             ByteBuffer dst) throws SSLException {
@@ -710,6 +713,9 @@ public SSLEngineResult unwrap(ByteBuffer src,
      * @throws  IllegalStateException if the client/server mode
      *          has not yet been set.
      * @see     #unwrap(ByteBuffer, ByteBuffer[], int, int)
+     *
+     * @implNote The data in {@code src} may be modified during the decryption
+     * process
      */
     public SSLEngineResult unwrap(ByteBuffer src,
             ByteBuffer [] dsts) throws SSLException {
@@ -798,6 +804,9 @@ public SSLEngineResult unwrap(ByteBuffer src,
      * @see     java.nio.channels.ScatteringByteChannel
      * @see     java.nio.channels.ScatteringByteChannel#read(
      *              ByteBuffer[], int, int)
+     *
+     * @implNote The data in {@code src} may be modified during the decryption
+     * process
      */
     public abstract SSLEngineResult unwrap(ByteBuffer src,
             ByteBuffer [] dsts, int offset, int length) throws SSLException;