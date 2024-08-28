public class MyJVMTest_9032 {

    static double a = Double.MAX_VALUE;

    static double b = Double.MIN_VALUE;

    double max_opt_double(double a, double b) {
        return Math.max(Math.max(a, b), Math.min(a, b));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9032().max_opt_double(a, b));
    }
}
