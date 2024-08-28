public class MyJVMTest_6513 {

    static double[] a = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0.6849771090608398, Double.NaN, Double.NaN, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0.962448431342795 };

    static Double ibc = new Double(1.);

    double sumc2(double[] a) {
        Double result1 = 1.;
        Double result2 = ibc;
        for (Double i : a) {
            result1 += i;
            result2 += i + ibc;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6513().sumc2(a));
    }
}
