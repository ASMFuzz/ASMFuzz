public class MyJVMTest_2316 {

    static double a = Double.NaN;

    static double b = 0d;

    double add_opt_double(double a, double b) {
        return Math.max(a, b) + Math.min(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2316().add_opt_double(a, b));
    }
}
