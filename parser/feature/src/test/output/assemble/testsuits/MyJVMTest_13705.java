import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Point;
import java.awt.Dimension;

public class MyJVMTest_13705 {

    static Shape t = null;

    static int rParam1Param1 = 350;

    static int rParam1Param2 = 758;

    static Point rParam1 = new Point(rParam1Param1, rParam1Param2);

    static int rParam2Param1 = 65;

    static int rParam2Param2 = 936;

    static Dimension rParam2 = new Dimension(rParam2Param1, rParam2Param2);

    static Rectangle r = new Rectangle(rParam1, rParam2);

    static String type = "[bi.e8}p%j";

    static boolean res = false;

    static int numerrors = 299816509;

    String error(Shape t, Rectangle r, String type, boolean res) {
        numerrors++;
        System.err.println(t + type + "(" + r + ") == " + res);
        return type;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13705().error(t, r, type, res);
    }
}
