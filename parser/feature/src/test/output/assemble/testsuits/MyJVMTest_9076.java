import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;

public class MyJVMTest_9076 {

    static ICC_Profile csParam1 = null;

    static ColorSpace cs = new ICC_ColorSpace(csParam1);

    ColorSpace test(ColorSpace cs) {
        try {
            cs.getName(cs.getNumComponents());
            throw new RuntimeException("Method ColorSpace.getName(int) should" + " throw exception for incorrect input");
        } catch (IllegalArgumentException ignored) {
        }
        return cs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9076().test(cs);
    }
}
