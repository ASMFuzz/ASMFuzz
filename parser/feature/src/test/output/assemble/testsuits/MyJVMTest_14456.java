public class MyJVMTest_14456 {

    static double[] p = { Double.MIN_VALUE, 0d, Double.MAX_VALUE, Double.NaN, Double.NaN, 0d, 0d, Double.NaN, 0.46466494438084827, 0.7727583829291917 };

    static double[] re_root = { 0.7246317296654536, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, 0.017504658524368333, 0.9127380877770446, Double.NEGATIVE_INFINITY };

    static double[] im_root = { Double.NaN, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN, Double.POSITIVE_INFINITY, 0.7241155061504104, 0.9535020314579559, Double.MAX_VALUE, Double.MIN_VALUE };

    static double SQRT3 = Math.sqrt(3.0), SQRT2 = Math.sqrt(2.0);

    static double EPS = 0;

    double[] root3a(final double[] p, final double[] re_root, final double[] im_root) {
        if (Math.abs(p[3]) > EPS) {
            final double v = p[3], a = p[2] / v, b = p[1] / v, c = p[0] / v, a3 = a / 3, a3a = a3 * a, pd3 = (b - a3a) / 3, qd2 = a3 * (a3a / 3 - 0.5 * b) + 0.5 * c, Q = pd3 * pd3 * pd3 + qd2 * qd2;
            if (Q < 0) {
                final double SQ = Math.sqrt(-Q);
                final double th = Math.atan2(SQ, -qd2);
                im_root[0] = im_root[1] = im_root[2] = 0;
                final double f = 2 * Math.sqrt(-pd3);
                re_root[0] = f * Math.cos(th / 3) - a3;
                re_root[1] = f * Math.cos((th + 2 * Math.PI) / 3) - a3;
                re_root[2] = f * Math.cos((th + 4 * Math.PI) / 3) - a3;
            } else {
                final double SQ = Math.sqrt(Q);
                final double r1 = -qd2 + SQ, r2 = -qd2 - SQ;
                final double v1 = Math.signum(r1) * Math.pow(Math.abs(r1), 1.0 / 3), v2 = Math.signum(r2) * Math.pow(Math.abs(r2), 1.0 / 3), sv = v1 + v2;
                re_root[0] = sv - a3;
                im_root[0] = 0;
                re_root[1] = re_root[2] = -0.5 * sv - a3;
                im_root[1] = (v1 - v2) * (SQRT3 * 0.5);
                im_root[2] = -im_root[1];
            }
        } else {
            re_root[0] = re_root[1] = re_root[2] = im_root[0] = im_root[1] = im_root[2] = Double.NaN;
        }
        return im_root;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14456().root3a(p, re_root, im_root);
    }
}
