public class MyJVMTest_84 {

    static double[] p = { Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN, 0.40977631656827695, Double.MAX_VALUE, 0d, Double.NaN, Double.MIN_VALUE };

    static double[] re_root = { Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static double[] im_root = { 0d, Double.NEGATIVE_INFINITY, 0d, Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NaN, 0.5138406025722261 };

    static double EPS = 0;

    int root1(final double[] p, final double[] re_root, final double[] im_root) {
        if (!(Math.abs(p[1]) > EPS)) {
            re_root[0] = im_root[0] = Double.NaN;
            return -1;
        }
        re_root[0] = -p[0] / p[1];
        im_root[0] = 0;
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_84().root1(p, re_root, im_root));
    }
}
