import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

public class MyJVMTest_4282 {

    void testGetReaderFileSuffixes() {
        String[] suffixes = ImageIO.getReaderFileSuffixes();
        for (String s : suffixes) {
            Iterator<ImageReader> it = ImageIO.getImageReadersBySuffix(s);
            if (!it.hasNext()) {
                throw new RuntimeException("getReaderFileSuffixes returned " + "an unknown suffix: " + s);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4282().testGetReaderFileSuffixes();
    }
}
