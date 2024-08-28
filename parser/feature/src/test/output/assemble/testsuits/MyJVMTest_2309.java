import java.awt.Rectangle;
import java.awt.geom.Area;

public class MyJVMTest_2309 {

    static int lox = 4;

    static int loy = 0;

    static int hix = 0;

    static int hiy = -542664264;

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
        new MyJVMTest_2309().addRect(lox, loy, hix, hiy);
    }
}
