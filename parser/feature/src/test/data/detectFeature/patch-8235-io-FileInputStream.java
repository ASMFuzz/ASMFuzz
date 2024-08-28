@@ -27,6 +27,7 @@
 
 import java.nio.channels.FileChannel;
 import java.util.Arrays;
+import java.util.Objects;
 import jdk.internal.misc.Blocker;
 import jdk.internal.util.ArraysSupport;
 import sun.nio.ch.FileChannelImpl;
@@ -243,13 +244,25 @@ public int read() throws IOException {
     private native int read0() throws IOException;
 
     /**
-     * Reads a subarray as a sequence of bytes.
-     * @param     b the data to be written
-     * @param     off the start offset in the data
-     * @param     len the number of bytes that are written
+     * Reads a sub-array as a sequence of bytes.
+     * @param     b the buffer into which the data is read.
+     * @param     off the start offset of the data.
+     * @param     len the number of bytes to read.
      * @throws    IOException If an I/O error has occurred.
      */
-    private native int readBytes(byte[] b, int off, int len) throws IOException;
+    private int readBytes(byte[] b, int off, int len) throws IOException {
+        Objects.checkFromIndexSize(off, len, b.length);
+        if (len == 0)
+            return 0;
+        long comp = Blocker.begin();
+        try {
+            return readBytes0(b, off, len);
+        } finally {
+            Blocker.end(comp);
+        }
+    }
+
+    private native int readBytes0(byte[] b, int off, int len) throws IOException;
 
     /**
      * Reads up to {@code b.length} bytes of data from this input
@@ -264,12 +277,7 @@ public int read() throws IOException {
      */
     @Override
     public int read(byte[] b) throws IOException {
-        long comp = Blocker.begin();
-        try {
-            return readBytes(b, 0, b.length);
-        } finally {
-            Blocker.end(comp);
-        }
+        return readBytes(b, 0, b.length);
     }
 
     /**
@@ -288,12 +296,7 @@ public int read(byte[] b) throws IOException {
      */
     @Override
     public int read(byte[] b, int off, int len) throws IOException {
-        long comp = Blocker.begin();
-        try {
-            return readBytes(b, off, len);
-        } finally {
-            Blocker.end(comp);
-        }
+        return readBytes(b, off, len);
     }
 
     @Override