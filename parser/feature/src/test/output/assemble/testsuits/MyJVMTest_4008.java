import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4008 {

    static String message = "B'5x4,TkA^";

    static int actualParam1 = 407;

    static boolean actualParam2 = true;

    static Color actual = new Color(actualParam1, actualParam2);

    static int expectedParam1 = 24;

    static Color expected = new Color(expectedParam1);

    static Window win = null;

    Color assertColorEquals(final String message, final Color actual, final Color expected) {
        System.out.println("actual color: " + actual);
        System.out.println("expect color: " + expected);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4008().assertColorEquals(message, actual, expected);
    }
}
