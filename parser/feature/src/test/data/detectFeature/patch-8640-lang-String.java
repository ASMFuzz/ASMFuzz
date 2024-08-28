@@ -658,8 +658,6 @@ public String(byte[] bytes, int offset, int length, Charset charset) {
 
             // decode using CharsetDecoder
             int en = scale(length, cd.maxCharsPerByte());
-            cd.onMalformedInput(CodingErrorAction.REPLACE)
-                    .onUnmappableCharacter(CodingErrorAction.REPLACE);
             char[] ca = new char[en];
             if (charset.getClass().getClassLoader0() != null &&
                     System.getSecurityManager() != null) {
@@ -1207,6 +1205,8 @@ private static int decodeUTF8_UTF16(byte[] src, int sp, int sl, byte[] dst, int
     private static int decodeWithDecoder(CharsetDecoder cd, char[] dst, byte[] src, int offset, int length) {
         ByteBuffer bb = ByteBuffer.wrap(src, offset, length);
         CharBuffer cb = CharBuffer.wrap(dst, 0, dst.length);
+        cd.onMalformedInput(CodingErrorAction.REPLACE)
+            .onUnmappableCharacter(CodingErrorAction.REPLACE);
         try {
             CoderResult cr = cd.decode(bb, cb, true);
             if (!cr.isUnderflow())