@@ -28,12 +28,10 @@
 import java.util.Locale;
 import javax.imageio.spi.ImageReaderSpi;
 import javax.imageio.stream.ImageInputStream;
-import javax.imageio.spi.IIORegistry;
 import javax.imageio.spi.ServiceRegistry;
 import java.io.IOException;
 import javax.imageio.ImageReader;
 import javax.imageio.IIOException;
-import com.sun.imageio.plugins.common.ReaderUtil;
 
 public class WBMPImageReaderSpi extends ImageReaderSpi {
 
@@ -86,16 +84,16 @@ public boolean canDecodeInput(Object source) throws IOException {
 
         stream.mark();
         try {
-            int type = stream.readByte();   // TypeField
-            int fixHeaderField = stream.readByte();
+            int type = stream.read();   // TypeField, or -1 if EOF
+            int fixHeaderField = stream.read();
             // check WBMP "header"
             if (type != 0 || fixHeaderField != 0) {
                 // while WBMP reader does not support ext WBMP headers
                 return false;
             }
 
-            int width = ReaderUtil.readMultiByteInteger(stream);
-            int height = ReaderUtil.readMultiByteInteger(stream);
+            int width = tryReadMultiByteInteger(stream);
+            int height = tryReadMultiByteInteger(stream);
             // check image dimension
             if (width <= 0 || height <= 0) {
                 return false;
@@ -123,6 +121,34 @@ public boolean canDecodeInput(Object source) throws IOException {
         }
     }
 
+    /**
+     * Reads a positive integer value encoded on a variable number of bytes,
+     * but stops the reading on end-of-file (EOF) or on integer overflow.
+     *
+     * @param  stream  the image input stream to read.
+     * @return the integer value, or -1 if EOF or integer overflow.
+     */
+    private static int tryReadMultiByteInteger(ImageInputStream stream)
+        throws IOException {
+        int value = stream.read();
+        if (value < 0) {
+            return -1;          // EOF
+        }
+        int result = value & 0x7f;
+        while ((value & 0x80) == 0x80) {
+            if ((result & 0xfe000000) != 0) {
+                return -1;      // 7 highest bits already used
+            }
+            result <<= 7;
+            value = stream.read();
+            if (value < 0) {
+                return -1;      // EOF
+            }
+            result |= (value & 0x7f);
+        }
+        return result;
+    }
+
     public ImageReader createReaderInstance(Object extension)
         throws IIOException {
         return new WBMPImageReader(this);