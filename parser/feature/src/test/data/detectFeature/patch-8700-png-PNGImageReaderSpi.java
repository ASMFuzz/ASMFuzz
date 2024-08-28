@@ -27,12 +27,10 @@
 
 import java.io.IOException;
 import java.util.Locale;
-import java.util.Iterator;
 import javax.imageio.ImageReader;
 import javax.imageio.spi.ImageReaderSpi;
-import javax.imageio.metadata.IIOMetadataFormat;
-import javax.imageio.metadata.IIOMetadataFormatImpl;
 import javax.imageio.stream.ImageInputStream;
+import com.sun.imageio.plugins.common.ReaderUtil;
 
 public class PNGImageReaderSpi extends ImageReaderSpi {
 
@@ -84,10 +82,11 @@ public boolean canDecodeInput(Object input) throws IOException {
         ImageInputStream stream = (ImageInputStream)input;
         byte[] b = new byte[8];
         stream.mark();
-        stream.readFully(b);
+        boolean full = ReaderUtil.tryReadFully(stream, b);
         stream.reset();
 
-        return (b[0] == (byte)137 &&
+        return full &&
+               (b[0] == (byte)137 &&
                 b[1] == (byte)80 &&
                 b[2] == (byte)78 &&
                 b[3] == (byte)71 &&