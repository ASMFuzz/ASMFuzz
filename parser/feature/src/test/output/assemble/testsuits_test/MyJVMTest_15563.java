public class MyJVMTest_15563 {

    static double[] a = { Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE, 0d, Double.POSITIVE_INFINITY, 0d, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE };

    double summ2(double[] a) {
        Double result1 = 1.;
        Double result2 = new Double(1.);
        for (Double i : a) {
            result1 += i;
            result2 += new Double(i + 1.);
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15563().summ2(a));
    }
}
