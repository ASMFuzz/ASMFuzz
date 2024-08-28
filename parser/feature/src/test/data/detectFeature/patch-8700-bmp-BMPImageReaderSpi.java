@@ -28,11 +28,11 @@
 import java.util.Locale;
 import javax.imageio.spi.ImageReaderSpi;
 import javax.imageio.stream.ImageInputStream;
-import javax.imageio.spi.IIORegistry;
 import javax.imageio.spi.ServiceRegistry;
 import java.io.IOException;
 import javax.imageio.ImageReader;
 import javax.imageio.IIOException;
+import com.sun.imageio.plugins.common.ReaderUtil;
 
 public class BMPImageReaderSpi extends ImageReaderSpi {
 
@@ -81,10 +81,10 @@ public boolean canDecodeInput(Object source) throws IOException {
         ImageInputStream stream = (ImageInputStream)source;
         byte[] b = new byte[2];
         stream.mark();
-        stream.readFully(b);
+        boolean full = ReaderUtil.tryReadFully(stream, b);
         stream.reset();
 
-        return (b[0] == 0x42) && (b[1] == 0x4d);
+        return full && (b[0] == 0x42) && (b[1] == 0x4d);
     }
 
     public ImageReader createReaderInstance(Object extension)