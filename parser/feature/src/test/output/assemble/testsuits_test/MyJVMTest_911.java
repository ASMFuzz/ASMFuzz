public class MyJVMTest_911 {

    static double a = 0.7419218238016404;

    static double b = 0d;

    double mul_opt_double(double a, double b) {
        return Math.max(a, b) * Math.min(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_911().mul_opt_double(a, b));
    }
}
