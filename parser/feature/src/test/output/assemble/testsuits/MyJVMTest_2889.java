public class MyJVMTest_2889 {

    static double[] p = { 0.18801352906632096, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN };

    static double[] re_root = { Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, 0d };

    static double[] im_root = { Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, 0.4233324875851019, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN };

    static double EPS = 0;

    int root2(final double[] p, final double[] re_root, final double[] im_root) {
        if (!(Math.abs(p[2]) > EPS)) {
            re_root[0] = re_root[1] = im_root[0] = im_root[1] = Double.NaN;
            return -1;
        }
        final double b2 = 0.5 * (p[1] / p[2]), c = p[0] / p[2], d = b2 * b2 - c;
        if (d >= 0) {
            final double sq = Math.sqrt(d);
            if (b2 < 0) {
                re_root[1] = -b2 + sq;
                re_root[0] = c / re_root[1];
            } else if (b2 > 0) {
                re_root[0] = -b2 - sq;
                re_root[1] = c / re_root[0];
            } else {
                re_root[0] = -b2 - sq;
                re_root[1] = -b2 + sq;
            }
            im_root[0] = im_root[1] = 0;
        } else {
            final double sq = Math.sqrt(-d);
            re_root[0] = re_root[1] = -b2;
            im_root[0] = sq;
            im_root[1] = -sq;
        }
        return 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2889().root2(p, re_root, im_root));
    }
}
