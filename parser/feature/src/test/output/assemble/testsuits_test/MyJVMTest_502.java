import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_502 {

    static Object hint = 0;

    static Image testImage = null;

    String getHintName(Object hint) {
        if (hint == RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR) {
            return "nearest";
        } else if (hint == RenderingHints.VALUE_INTERPOLATION_BILINEAR) {
            return "bilinear";
        } else if (hint == RenderingHints.VALUE_INTERPOLATION_BICUBIC) {
            return "bicubic";
        } else {
            return "null";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_502().getHintName(hint));
    }
}
