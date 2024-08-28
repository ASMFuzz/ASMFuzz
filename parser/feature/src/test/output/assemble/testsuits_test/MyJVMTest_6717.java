import java.util.*;
import java.awt.geom.*;

public class MyJVMTest_6717 {

    static float[] coords = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN };

    static int offset = 0;

    static float squareflat = 0f;

    static int limit = 8;

    static float[] hold = new float[14];

    static int holdEnd = 0;

    static int holdIndex = 8;

    static int[] levels = {5,7,0,0,3,0,1,4,1,0};

    static int levelIndex = 0;

    double getFlatnessSq(float[] coords, int offset) {
        return Line2D.ptSegDistSq(coords[offset + 0], coords[offset + 1], coords[offset + 4], coords[offset + 5], coords[offset + 2], coords[offset + 3]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6717().getFlatnessSq(coords, offset));
    }
}
