import java.awt.Rectangle;
import java.awt.geom.Area;

public class MyJVMTest_11569 {

    static int lox = 8;

    static int loy = 0;

    static int hix = 9;

    static int hiy = 1;

    static Area theArea = null;

    int addRect(int lox, int loy, int hix, int hiy) {
        Area a2 = new Area(new Rectangle(lox, loy, hix - lox, hiy - loy));
        if (theArea == null) {
            theArea = a2;
        } else {
            theArea.add(a2);
        }
        return loy;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11569().addRect(lox, loy, hix, hiy);
    }
}
