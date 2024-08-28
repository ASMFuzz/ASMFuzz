public class MyJVMTest_16701 {

    static int nr = 0;

    static double[] re = { Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE };

    static double[] im = { 0d, Double.NaN, 0.48232655339935615, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN };

    String getRootsTXT(int nr, final double[] re, final double[] im) {
        final StringBuilder buf = new StringBuilder();
        for (int k = 0; k < nr; k++) {
            buf.append("x." + k + "(" + re[k] + "," + im[k] + ")\n");
        }
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16701().getRootsTXT(nr, re, im));
    }
}
