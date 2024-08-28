public class MyJVMTest_9945 {

    static double[] p = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, 0d, 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE };

    static double[] re_root = { Double.POSITIVE_INFINITY, 0d, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN };

    static double[] im_root = { 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, 0.5350615373794415 };

    static double SQRT3 = Math.sqrt(3.0), SQRT2 = Math.sqrt(2.0);

    static double EPS = 0;

    int root3(final double[] p, final double[] re_root, final double[] im_root) {
        final double vs = p[3];
        if (!(Math.abs(vs) > EPS)) {
            re_root[0] = re_root[1] = re_root[2] = im_root[0] = im_root[1] = im_root[2] = Double.NaN;
            return -1;
        }
        final double a = p[2] / vs, b = p[1] / vs, c = p[0] / vs;
        final double q = (a * a - 3 * b);
        final double r = (a * (2 * a * a - 9 * b) + 27 * c);
        final double Q = q / 9;
        final double R = r / 54;
        final double Q3 = Q * Q * Q;
        final double R2 = R * R;
        final double CR2 = 729 * r * r;
        final double CQ3 = 2916 * q * q * q;
        final double a3 = a / 3;
        if (R == 0 && Q == 0) {
            re_root[0] = re_root[1] = re_root[2] = -a3;
            im_root[0] = im_root[1] = im_root[2] = 0;
            return 3;
        } else if (CR2 == CQ3) {
            final double sqrtQ = Math.sqrt(Q);
            if (R > 0) {
                re_root[0] = -2 * sqrtQ - a3;
                re_root[1] = re_root[2] = sqrtQ - a3;
                im_root[0] = im_root[1] = im_root[2] = 0;
            } else {
                re_root[0] = re_root[1] = -sqrtQ - a3;
                re_root[2] = 2 * sqrtQ - a3;
                im_root[0] = im_root[1] = im_root[2] = 0;
            }
            return 3;
        } else if (R2 < Q3) {
            final double sgnR = (R >= 0 ? 1 : -1);
            final double ratio = sgnR * Math.sqrt(R2 / Q3);
            final double theta = Math.acos(ratio);
            final double norm = -2 * Math.sqrt(Q);
            final double r0 = norm * Math.cos(theta / 3) - a3;
            final double r1 = norm * Math.cos((theta + 2.0 * Math.PI) / 3) - a3;
            final double r2 = norm * Math.cos((theta - 2.0 * Math.PI) / 3) - a3;
            re_root[0] = r0;
            re_root[1] = r1;
            re_root[2] = r2;
            im_root[0] = im_root[1] = im_root[2] = 0;
            return 3;
        } else {
            final double sgnR = (R >= 0 ? 1 : -1);
            final double A = -sgnR * Math.pow(Math.abs(R) + Math.sqrt(R2 - Q3), 1.0 / 3.0);
            final double B = Q / A;
            re_root[0] = A + B - a3;
            im_root[0] = 0;
            re_root[1] = -0.5 * (A + B) - a3;
            im_root[1] = -(SQRT3 * 0.5) * Math.abs(A - B);
            re_root[2] = re_root[1];
            im_root[2] = -im_root[1];
            return 3;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9945().root3(p, re_root, im_root));
    }
}
