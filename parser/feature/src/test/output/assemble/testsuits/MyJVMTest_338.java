public class MyJVMTest_338 {

    static double a = Double.MIN_VALUE;

    static double b = Double.POSITIVE_INFINITY;

    double max_opt_double(double a, double b) {
        return Math.max(Math.max(a, b), Math.min(a, b));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_338().max_opt_double(a, b));
    }
}
