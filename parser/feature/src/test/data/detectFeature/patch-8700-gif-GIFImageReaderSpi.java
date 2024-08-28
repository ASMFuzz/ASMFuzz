@@ -27,12 +27,10 @@
 
 import java.io.IOException;
 import java.util.Locale;
-import java.util.Iterator;
 import javax.imageio.ImageReader;
-import javax.imageio.metadata.IIOMetadataFormat;
-import javax.imageio.metadata.IIOMetadataFormatImpl;
 import javax.imageio.spi.ImageReaderSpi;
 import javax.imageio.stream.ImageInputStream;
+import com.sun.imageio.plugins.common.ReaderUtil;
 
 public class GIFImageReaderSpi extends ImageReaderSpi {
 
@@ -85,10 +83,11 @@ public boolean canDecodeInput(Object input) throws IOException {
         ImageInputStream stream = (ImageInputStream)input;
         byte[] b = new byte[6];
         stream.mark();
-        stream.readFully(b);
+        boolean full = ReaderUtil.tryReadFully(stream, b);
         stream.reset();
 
-        return b[0] == 'G' && b[1] == 'I' && b[2] == 'F' && b[3] == '8' &&
+        return full &&
+            b[0] == 'G' && b[1] == 'I' && b[2] == 'F' && b[3] == '8' &&
             (b[4] == '7' || b[4] == '9') && b[5] == 'a';
     }
 