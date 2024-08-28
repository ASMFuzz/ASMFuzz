import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;

public class MyJVMTest_15949 {

    static int biParam1 = 900;

    static int biParam2 = 772;

    static int biParam3 = 498;

    static int biParam4Param1 = 642;

    static int biParam4Param2 = 214;

    static byte[] biParam4Param3 = { -79, 77, -67, -89, -10, -29, -2, -43, -34, -82 };

    static byte[] biParam4Param4 = { 63, -100, -49, 101, 114, -52, -123, 90, -13, -28 };

    static byte[] biParam4Param5 = { -77, -107, 14, -51, -100, -48, 122, 64, -109, -28 };

    static IndexColorModel biParam4 = new IndexColorModel(biParam4Param1, biParam4Param2, biParam4Param3, biParam4Param4, biParam4Param5);

    static BufferedImage bi = new BufferedImage(biParam1, biParam2, biParam3, biParam4);

    static int expected = 2101952183;

    Object validate(final BufferedImage bi, final int expected) {
        final String[] names = bi.getPropertyNames();
        if (names.length != expected) {
            throw new RuntimeException("Wrong number of names");
        }
        for (final String name : names) {
            final Object property = bi.getProperty(name);
            if (property == Image.UndefinedProperty || property == null) {
                throw new RuntimeException("Unexpected property");
            }
        }
        return property;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15949().validate(bi, expected);
    }
}
