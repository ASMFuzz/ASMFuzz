import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_10824 {

    static float c1Param1 = Float.MAX_VALUE;

    static float c1Param2 = 0.17292649f;

    static float c1Param3 = Float.MIN_VALUE;

    static float c1Param4 = 0f;

    static Color c1 = new Color(c1Param1, c1Param2, c1Param3, c1Param4);

    static float c2Param1 = Float.NEGATIVE_INFINITY;

    static float c2Param2 = Float.MIN_VALUE;

    static float c2Param3 = Float.NaN;

    static float c2Param4 = 0.5013777f;

    static Color c2 = new Color(c2Param1, c2Param2, c2Param3, c2Param4);

    static int e = 0;

    boolean isSameColor(Color c1, Color c2, int e) {
        int r1 = c1.getRed();
        int g1 = c1.getGreen();
        int b1 = c1.getBlue();
        int r2 = c2.getRed();
        int g2 = c2.getGreen();
        int b2 = c2.getBlue();
        int rmin = Math.max(r2 - e, 0);
        int gmin = Math.max(g2 - e, 0);
        int bmin = Math.max(b2 - e, 0);
        int rmax = Math.min(r2 + e, 255);
        int gmax = Math.min(g2 + e, 255);
        int bmax = Math.min(b2 + e, 255);
        if (r1 >= rmin && r1 <= rmax && g1 >= gmin && g1 <= gmax && b1 >= bmin && b1 <= bmax) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10824().isSameColor(c1, c2, e));
    }
}
