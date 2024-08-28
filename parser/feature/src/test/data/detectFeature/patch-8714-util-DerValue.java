@@ -299,7 +299,7 @@ public DerValue(byte tag, byte[] buffer) {
      *
      * @param tag the tag
      * @param out the DerOutputStream
-     * @returns a new DerValue using out as its content
+     * @return a new DerValue using out as its content
      */
     public static DerValue wrap(byte tag, DerOutputStream out) {
         return new DerValue(tag, out.buf(), 0, out.size(), false);
@@ -311,7 +311,7 @@ public static DerValue wrap(byte tag, DerOutputStream out) {
      * Attention: no cloning is made.
      *
      * @param buf the byte array containing the DER-encoded datum
-     * @returns a new DerValue
+     * @return a new DerValue
      */
     public static DerValue wrap(byte[] buf)
             throws IOException {
@@ -326,7 +326,7 @@ public static DerValue wrap(byte[] buf)
      * @param buf the byte array containing the DER-encoded datum
      * @param offset where the encoded datum starts inside {@code buf}
      * @param len length of bytes to parse inside {@code buf}
-     * @returns a new DerValue
+     * @return a new DerValue
      */
     public static DerValue wrap(byte[] buf, int offset, int len)
             throws IOException {