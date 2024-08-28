import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

public class MyJVMTest_2178 {

    void testGetReaderMIMETypes() {
        String[] types = ImageIO.getReaderMIMETypes();
        for (String t : types) {
            Iterator<ImageReader> it = ImageIO.getImageReadersByMIMEType(t);
            if (!it.hasNext()) {
                throw new RuntimeException("getReaderMIMETypes returned " + "an unknown type: " + t);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2178().testGetReaderMIMETypes();
    }
}
