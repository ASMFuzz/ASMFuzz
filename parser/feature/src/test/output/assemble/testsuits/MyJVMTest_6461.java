import java.awt.Image;
import java.awt.image.BufferedImage;

public class MyJVMTest_6461 {

    static int biParam1 = 298;

    static int biParam2 = 373;

    static int biParam3 = 918;

    static BufferedImage bi = new BufferedImage(biParam1, biParam2, biParam3);

    static int expected = 477608905;

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
        new MyJVMTest_6461().validate(bi, expected);
    }
}
