public class MyJVMTest_13015 {

    static double val1 = Double.MAX_VALUE;

    static double val2 = Double.MIN_VALUE;

    double ulps(double val1, double val2) {
        double diff = Math.abs(val1 - val2);
        double ulpmax = Math.min(Math.ulp(val1), Math.ulp(val2));
        return (diff / ulpmax);
    }

    static double maxulps = 0.0;

    static Tester prev = null;

    static Tester next = null;

    boolean compare(double val1, double val2, double maxulps) {
        if (Math.abs(val1 - val2) < 1E-15)
            return true;
        return (ulps(val1, val2) <= maxulps);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13015().compare(val1, val2, maxulps));
    }
}
