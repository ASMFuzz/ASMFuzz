import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Point;
import java.awt.Dimension;

public class MyJVMTest_4331 {

    static Shape t = null;

    static int rParam1Param1 = 35;

    static int rParam1Param2 = 876;

    static Point rParam1 = new Point(rParam1Param1, rParam1Param2);

    static Dimension rParam2Param1 = new Dimension();

    static Dimension rParam2 = new Dimension(rParam2Param1);

    static Rectangle r = new Rectangle(rParam1, rParam2);

    static String type = "f-IafK![{m";

    static boolean res = false;

    static int numerrors = 185536552;

    String error(Shape t, Rectangle r, String type, boolean res) {
        numerrors++;
        System.err.println(t + type + "(" + r + ") == " + res);
        return type;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4331().error(t, r, type, res);
    }
}
