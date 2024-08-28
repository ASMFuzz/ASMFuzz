public class MyJVMTest_11944 {

    static double[] p = { 0d, Double.NEGATIVE_INFINITY, Double.NaN, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, 0d, Double.NaN, 0d, Double.NaN };

    String getPolinomTXT(final double[] p) {
        final StringBuilder buf = new StringBuilder();
        buf.append("order=" + (p.length - 1) + "\t");
        for (int k = 0; k < p.length; k++) {
            buf.append("p[" + k + "]=" + p[k] + ";");
        }
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11944().getPolinomTXT(p));
    }
}
