public class MyJVMTest_2661 {

    static double[] p = { Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, 0.9493816251920992, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    String getPolinomTXT(final double[] p) {
        final StringBuilder buf = new StringBuilder();
        buf.append("order=" + (p.length - 1) + "\t");
        for (int k = 0; k < p.length; k++) {
            buf.append("p[" + k + "]=" + p[k] + ";");
        }
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2661().getPolinomTXT(p));
    }
}
