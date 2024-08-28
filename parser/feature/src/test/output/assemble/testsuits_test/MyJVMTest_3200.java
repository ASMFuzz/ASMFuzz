import java.awt.image.*;
import java.awt.color.*;

public class MyJVMTest_3200 {

    static String[] opsName = { "Threshold", "RescaleOp", "Invert", "Yellow Invert", "3x3 Blur", "3x3 Sharpen", "3x3 Edge", "5x5 Edge", "Color Convert", "Rotate" };

    static BufferedImageOp[] biop = new BufferedImageOp[opsName.length];

    static RasterOp[] rop = new RasterOp[opsName.length];

    static int SIZE = 100;

    void runTest() {
        int exceptions = 0;
        for (int i = 0; i < opsName.length; i++) {
            for (int j = BufferedImage.TYPE_INT_RGB; j <= BufferedImage.TYPE_INT_RGB; j++) {
                BufferedImage srcImage = new BufferedImage(SIZE, SIZE, j);
                BufferedImage dstImage = new BufferedImage(SIZE, SIZE, j);
                System.err.println("bi type=" + j);
                System.err.println("  biop =" + opsName[i]);
                try {
                    biop[i].filter(srcImage, dstImage);
                } catch (Exception e) {
                    e.printStackTrace();
                    exceptions++;
                }
                try {
                    biop[i].filter(srcImage, null);
                } catch (Exception e) {
                    e.printStackTrace();
                    exceptions++;
                }
                if (!(rop[i] instanceof LookupOp)) {
                    System.err.println("  rop  =" + opsName[i]);
                    try {
                        rop[i].filter(srcImage.getRaster(), (WritableRaster) dstImage.getRaster());
                    } catch (Exception e) {
                        e.printStackTrace();
                        exceptions++;
                    }
                }
            }
        }
        if (exceptions > 0) {
            throw new RuntimeException("Test Failed, " + exceptions + " exceptions were thrown");
        }
        System.err.println("Test Passed, no exceptions were thrown.");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3200().runTest();
    }
}
