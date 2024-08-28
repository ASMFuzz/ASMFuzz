public class MyJVMTest_1724 {

    static double val1 = Double.MIN_VALUE;

    static double val2 = 0.2850816638965359;

    static Tester prev = null;

    static Tester next = null;

    double ulps(double val1, double val2) {
        double diff = Math.abs(val1 - val2);
        double ulpmax = Math.min(Math.ulp(val1), Math.ulp(val2));
        return (diff / ulpmax);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1724().ulps(val1, val2));
    }
}
