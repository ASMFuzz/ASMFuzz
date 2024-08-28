@@ -1031,8 +1031,9 @@ public int read() throws IOException {
      * @param   buf the buffer into which the data is read
      * @param   off the start offset in the destination array {@code buf}
      * @param   len the maximum number of bytes read
-     * @return  the actual number of bytes read, -1 is returned when the end of
-     *          the stream is reached.
+     * @return  the total number of bytes read into the buffer, or
+     *          {@code -1} if there is no more data because the end of
+     *          the stream has been reached.
      * @throws  NullPointerException if {@code buf} is {@code null}.
      * @throws  IndexOutOfBoundsException if {@code off} is negative,
      *          {@code len} is negative, or {@code len} is greater than