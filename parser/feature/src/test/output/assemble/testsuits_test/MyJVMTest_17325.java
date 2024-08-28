import java.awt.*;
import javax.swing.*;

public class MyJVMTest_17325 {

    static int cParam1 = 560;

    static Color c = new Color(cParam1);

    static Color expected = new Color();

    static int TD = 10;

    static Robot robot = null;

    boolean validateColor(Color c, Color expected) {
        return Math.abs(c.getRed() - expected.getRed()) <= TD && Math.abs(c.getGreen() - expected.getGreen()) <= TD && Math.abs(c.getBlue() - expected.getBlue()) <= TD;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17325().validateColor(c, expected));
    }
}
