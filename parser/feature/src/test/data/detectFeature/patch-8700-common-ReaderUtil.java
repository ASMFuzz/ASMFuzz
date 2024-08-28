@@ -258,4 +258,28 @@ public static byte[] staggeredReadByteStream(ImageInputStream iis,
         }
         return decodedData;
     }
+
+    /**
+     * Tries to read {@code b.length} bytes from the stream,
+     * and stores them into {@code b} starting at index 0.
+     * If the end of the stream is reached, a {@code false}
+     * will be returned.
+     *
+     * @param  iis  the stream to read.
+     * @param  b    an array where to store the {@code byte}s.
+     * @return {@code true} on success, or {@code false} on EOF.
+     */
+    public static boolean tryReadFully(ImageInputStream iis, byte[] b)
+        throws IOException
+    {
+        int offset = 0;
+        do {
+            int n = iis.read(b, offset, b.length - offset);
+            if (n < 0) {
+                return false;       // EOF
+            }
+            offset += n;
+        } while (offset < b.length);
+        return true;
+    }
 }