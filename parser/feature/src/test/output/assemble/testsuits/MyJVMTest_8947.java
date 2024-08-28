public class MyJVMTest_8947 {

    static double a = Double.MIN_VALUE;

    static double b = Double.MIN_VALUE;

    double min_opt_double(double a, double b) {
        return Math.min(Math.max(a, b), Math.min(a, b));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8947().min_opt_double(a, b));
    }
}
