import java.util.*;
import java.awt.geom.*;

public class MyJVMTest_1403 {

    static float[] src = { Float.NEGATIVE_INFINITY, 0.6374436f, Float.POSITIVE_INFINITY, 0f, 0.7676542f, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, 0f };

    static int srcoff = 0;

    static float[] left = { Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0.15122509f, Float.NaN, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static int leftoff = 4;

    static float[] right = { Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, 0f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, Float.NaN };

    static int rightoff = 0;

    static float squareflat = Float.POSITIVE_INFINITY;

    static int limit = 1144285373;

    static float[] hold = new float[14];

    static int holdEnd = 7;

    static int holdIndex = 7;

    static int[] levels = {1,7,5,0,0,8,1,8,7,-1423197424};

    static int levelIndex = 0;

    float[] subdivide(float[] src, int srcoff, float[] left, int leftoff, float[] right, int rightoff) {
        float x1 = src[srcoff + 0];
        float y1 = src[srcoff + 1];
        float ctrlx = src[srcoff + 2];
        float ctrly = src[srcoff + 3];
        float x2 = src[srcoff + 4];
        float y2 = src[srcoff + 5];
        if (left != null) {
            left[leftoff + 0] = x1;
            left[leftoff + 1] = y1;
        }
        if (right != null) {
            right[rightoff + 4] = x2;
            right[rightoff + 5] = y2;
        }
        x1 = (x1 + ctrlx) / 2f;
        y1 = (y1 + ctrly) / 2f;
        x2 = (x2 + ctrlx) / 2f;
        y2 = (y2 + ctrly) / 2f;
        ctrlx = (x1 + x2) / 2f;
        ctrly = (y1 + y2) / 2f;
        if (left != null) {
            left[leftoff + 2] = x1;
            left[leftoff + 3] = y1;
            left[leftoff + 4] = ctrlx;
            left[leftoff + 5] = ctrly;
        }
        if (right != null) {
            right[rightoff + 0] = ctrlx;
            right[rightoff + 1] = ctrly;
            right[rightoff + 2] = x2;
            right[rightoff + 3] = y2;
        }
        return right;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1403().subdivide(src, srcoff, left, leftoff, right, rightoff);
    }
}
