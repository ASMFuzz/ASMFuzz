import java.util.*;
import java.awt.geom.*;

public class MyJVMTest_16213 {

    static float[] coords = { Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.NaN, 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0f, Float.NEGATIVE_INFINITY };

    static int offset = 5;

    static float squareflat = 0f;

    static int limit = 0;

    static float[] hold = new float[14];

    static int holdEnd = 1403591102;

    static int holdIndex = 0;

    static int[] levels = {-1090790588,673628366,6,7,1478916305,7,0,0,0,3};

    static int levelIndex = 8;

    double getFlatnessSq(float[] coords, int offset) {
        return Line2D.ptSegDistSq(coords[offset + 0], coords[offset + 1], coords[offset + 4], coords[offset + 5], coords[offset + 2], coords[offset + 3]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16213().getFlatnessSq(coords, offset));
    }
}
