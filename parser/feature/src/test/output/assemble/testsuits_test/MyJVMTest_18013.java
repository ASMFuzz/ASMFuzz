import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_18013 {

    static int testSize = 4, scaleFactor = 20, tolerance = 3;

    static Image testImage = null;

    Image createTestImage() {
        BufferedImage bi = new BufferedImage(testSize, testSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, testSize, testSize);
        for (int i = 0; i < testSize; i++) {
            bi.setRGB(i, i, Color.WHITE.getRGB());
        }
        return bi;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18013().createTestImage());
    }
}
