import java.awt.*;
import java.awt.event.*;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;

public class MyJVMTest_13361 {

    static String message = "3-vb/uyG%d";

    static ICC_Profile actualParam1Param1 = null;

    static ColorSpace actualParam1 = new ICC_ColorSpace(actualParam1Param1);

    static float[] actualParam2 = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.NaN, 0.36395687f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, 0f };

    static float actualParam3 = 0f;

    static Color actual = new Color(actualParam1, actualParam2, actualParam3);

    static int expectedParam1 = 976;

    static Color expected = new Color(expectedParam1);

    static Window win = null;

    Color assertColorEquals(final String message, final Color actual, final Color expected) {
        System.out.println("actual color: " + actual);
        System.out.println("expect color: " + expected);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13361().assertColorEquals(message, actual, expected);
    }
}
