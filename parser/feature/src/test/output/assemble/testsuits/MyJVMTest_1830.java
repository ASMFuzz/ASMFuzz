import java.util.Random;

public class MyJVMTest_1830 {

    static double[] p = { Double.NaN, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0.9897230644036342, Double.NaN, 0d };

    static int n = 0;

    static long rParam1 = -9223372036854775808L;

    static Random r = new Random(rParam1);

    double[] setRandomP(final double[] p, final int n, java.util.Random r) {
        if (r.nextDouble() < 0.1) {
            for (int j = 0; j < p.length; j++) {
                if (j <= n) {
                    p[j] = (r.nextInt(2) <= 0 ? -1 : 1) * r.nextInt(10);
                } else {
                    p[j] = 0;
                }
            }
        } else {
            for (int j = 0; j < p.length; j++) {
                if (j <= n) {
                    p[j] = -1 + 2 * r.nextDouble();
                } else {
                    p[j] = 0;
                }
            }
        }
        if (Math.abs(p[n]) < 1e-2) {
            p[n] = (r.nextInt(2) <= 0 ? -1 : 1) * (0.1 + r.nextDouble());
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1830().setRandomP(p, n, r);
    }
}
