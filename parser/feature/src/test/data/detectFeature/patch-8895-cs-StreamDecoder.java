@@ -215,7 +215,13 @@ private int lockedRead(char[] cbuf, int offset, int length) throws IOException {
             return n + 1;
         }
 
-        return n + implRead(cbuf, off, off + len);
+        // Read remaining characters
+        int nr = implRead(cbuf, off, off + len);
+
+        // At this point, n is either 1 if a leftover character was read,
+        // or 0 if no leftover character was read. If n is 1 and nr is -1,
+        // indicating EOF, then we don't return their sum as this loses data.
+        return (nr < 0) ? (n == 1 ? 1 : nr) : (n + nr);
     }
 
     public boolean ready() throws IOException {