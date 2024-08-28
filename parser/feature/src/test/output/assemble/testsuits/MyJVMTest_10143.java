import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_10143 {

    static int c1Param1 = 794;

    static boolean c1Param2 = true;

    static Color c1 = new Color(c1Param1, c1Param2);

    static int c2Param1 = 219;

    static Color c2 = new Color(c2Param1);

    static int e = 0;

    static RescaleOp rescale1band = null, rescale3band = null, rescale4band = null;

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
        System.out.println(new MyJVMTest_10143().isSameColor(c1, c2, e));
    }
}
