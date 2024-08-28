import java.awt.image.BufferedImage;

public class MyJVMTest_6367 {

    static int imageParam1 = 694;

    static int imageParam2 = 928;

    static int imageParam3 = 826;

    static BufferedImage image = new BufferedImage(imageParam1, imageParam2, imageParam3);

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
        new MyJVMTest_6367().validate(image);
    }
}
