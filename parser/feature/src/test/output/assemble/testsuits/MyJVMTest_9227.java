public class MyJVMTest_9227 {

    static double[] p = { Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, 0.29585126193119704, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN };

    static double[] re_root = { Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, 0d, 0d, Double.NaN, 0.8263979956830559, 0d, 0.3653938141939347, 0d };

    static double[] im_root = { Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, 0.14342968790324717, 0.6080022164672255, 0.5551049660250095, Double.MIN_VALUE };

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
        System.out.println(new MyJVMTest_9227().root1(p, re_root, im_root));
    }
}
