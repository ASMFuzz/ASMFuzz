public class MyJVMTest_7178 {

    static int nr = -1893984461;

    static double[] re = { Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, Double.MIN_VALUE, 0d, 0.8283414858519932, Double.POSITIVE_INFINITY, 0.35927414810287817, 0d, Double.NEGATIVE_INFINITY };

    static double[] im = { Double.NEGATIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.6700797170062355, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, 0.24742417194961686, 0d };

    String getRootsTXT(int nr, final double[] re, final double[] im) {
        final StringBuilder buf = new StringBuilder();
        for (int k = 0; k < nr; k++) {
            buf.append("x." + k + "(" + re[k] + "," + im[k] + ")\n");
        }
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7178().getRootsTXT(nr, re, im));
    }
}
