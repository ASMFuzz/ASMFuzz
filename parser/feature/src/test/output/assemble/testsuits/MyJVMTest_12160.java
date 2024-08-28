public class MyJVMTest_12160 {

    static double a = Double.NaN;

    static double b = 0d;

    double min_opt_double(double a, double b) {
        return Math.min(Math.max(a, b), Math.min(a, b));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12160().min_opt_double(a, b));
    }
}
