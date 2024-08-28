import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.imageio.stream.*;
import java.awt.Image;

public class MyJVMTest_71 {

    File createImageFile() throws Exception {
        BufferedImage im = new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_GRAY);
        File f = File.createTempFile("BogusSecondImage", "tif", new File("."));
        f.deleteOnExit();
        if (!ImageIO.write(im, "TIFF", f)) {
            throw new RuntimeException("Failed to write " + f);
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_71().createImageFile());
    }
}
