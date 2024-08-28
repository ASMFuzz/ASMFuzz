public class MyJVMTest_12796 {

    static double val1 = Double.MAX_VALUE;

    static double val2 = Double.MIN_VALUE;

    double ulps(double val1, double val2) {
        double diff = Math.abs(val1 - val2);
        double ulpmax = Math.min(Math.ulp(val1), Math.ulp(val2));
        return (diff / ulpmax);
    }

    static double maxulps = 0.0;

    boolean compare(double val1, double val2, double maxulps) {
        return (ulps(val1, val2) <= maxulps);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12796().compare(val1, val2, maxulps));
    }
}
