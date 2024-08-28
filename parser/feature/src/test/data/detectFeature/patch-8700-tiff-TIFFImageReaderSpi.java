@@ -30,6 +30,7 @@
 import javax.imageio.spi.ImageReaderSpi;
 import javax.imageio.spi.ServiceRegistry;
 import javax.imageio.stream.ImageInputStream;
+import com.sun.imageio.plugins.common.ReaderUtil;
 
 public class TIFFImageReaderSpi extends ImageReaderSpi {
 
@@ -67,10 +68,11 @@ public boolean canDecodeInput(Object input) throws IOException {
         ImageInputStream stream = (ImageInputStream)input;
         byte[] b = new byte[4];
         stream.mark();
-        stream.readFully(b);
+        boolean full = ReaderUtil.tryReadFully(stream, b);
         stream.reset();
 
-        return ((b[0] == (byte)0x49 && b[1] == (byte)0x49 &&
+        return full &&
+               ((b[0] == (byte)0x49 && b[1] == (byte)0x49 &&
                  b[2] == (byte)0x2a && b[3] == (byte)0x00) ||
                 (b[0] == (byte)0x4d && b[1] == (byte)0x4d &&
                  b[2] == (byte)0x00 && b[3] == (byte)0x2a));