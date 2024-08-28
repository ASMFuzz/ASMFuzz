@@ -742,7 +742,10 @@ public void reset() throws IOException {
      * Tests if this input stream supports the {@code mark} and
      * {@code reset} methods. Whether or not {@code mark} and
      * {@code reset} are supported is an invariant property of a
-     * particular input stream instance. The {@code markSupported} method
+     * particular input stream instance.
+     *
+     * @implSpec
+     * The {@code markSupported} method
      * of {@code InputStream} returns {@code false}.
      *
      * @return  {@code true} if this stream instance supports the mark