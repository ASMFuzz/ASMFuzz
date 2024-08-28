import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

public class MyJVMTest_3232 {

    void testGetReaderFormatNames() {
        String[] names = ImageIO.getReaderFormatNames();
        for (String n : names) {
            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(n);
            if (!it.hasNext()) {
                throw new RuntimeException("getReaderFormatNames returned " + "an unknown name: " + n);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3232().testGetReaderFormatNames();
    }
}
