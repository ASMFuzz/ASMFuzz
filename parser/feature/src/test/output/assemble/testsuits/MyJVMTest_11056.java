import java.util.Random;

public class MyJVMTest_11056 {

    static double[] p = { 0.430307771207872, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE };

    static int n = 3;

    static Random r = new Random();

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
        new MyJVMTest_11056().setRandomP(p, n, r);
    }
}
