import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;

public class MyJVMTest_15847 {

    static int imageParam1 = 964;

    static int imageParam2 = 528;

    static int imageParam3 = 412;

    static int imageParam4Param1 = 632;

    static int imageParam4Param2 = 102;

    static byte[] imageParam4Param3 = { -125, -26, 60, -37, 112, 26, 92, -16, -103, 81 };

    static byte[] imageParam4Param4 = { 29, 84, -83, -93, -11, 53, -91, -116, 124, -93 };

    static byte[] imageParam4Param5 = { -70, -33, 10, 46, 28, 110, 90, 73, -10, -40 };

    static int imageParam4Param6 = 189;

    static IndexColorModel imageParam4 = new IndexColorModel(imageParam4Param1, imageParam4Param2, imageParam4Param3, imageParam4Param4, imageParam4Param5, imageParam4Param6);

    static BufferedImage image = new BufferedImage(imageParam1, imageParam2, imageParam3, imageParam4);

    int validate(final BufferedImage image) {
        final int tileGridXOffset = image.getTileGridXOffset();
        final int tileGridYOffset = image.getTileGridYOffset();
        if (tileGridXOffset != 0) {
            throw new RuntimeException("BufferedImage.getTileGridXOffset()" + " shall be zero. Got " + tileGridXOffset);
        }
        if (tileGridYOffset != 0) {
            throw new RuntimeException("BufferedImage.getTileGridTOffset()" + " shall be zero. Got " + tileGridYOffset);
        }
        return tileGridXOffset;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15847().validate(image);
    }
}
