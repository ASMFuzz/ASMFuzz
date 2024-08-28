import java.awt.BasicStroke;

public class MyJVMTest_3988 {

    static float width = Float.NaN;

    static boolean useDashes = false;

    static float dashMinLen = Float.POSITIVE_INFINITY;

    static boolean USE_ROUND_CAPS_AND_JOINS = true;

    BasicStroke createStroke(final float width, final boolean useDashes, final float dashMinLen) {
        final float[] dashes;
        if (useDashes) {
            dashes = new float[512];
            float cur = dashMinLen;
            float step = 0.01f;
            for (int i = 0; i < dashes.length; i += 2) {
                dashes[i] = cur;
                dashes[i + 1] = cur;
                cur += step;
            }
        } else {
            dashes = null;
        }
        if (USE_ROUND_CAPS_AND_JOINS) {
            return new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 100.0f, dashes, 0.0f);
        }
        return new BasicStroke(width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 100.0f, dashes, 0.0f);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3988().createStroke(width, useDashes, dashMinLen));
    }
}
