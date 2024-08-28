public class MyJVMTest_9105 {

    static double a = Double.MIN_VALUE;

    static double b = Double.POSITIVE_INFINITY;

    double mul_opt_double(double a, double b) {
        return Math.max(a, b) * Math.min(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9105().mul_opt_double(a, b));
    }
}
