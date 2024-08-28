public class MyJVMTest_10092 {

    static double a = 0.05962141019904943;

    static double b = 0.4089542087541429;

    double mul_opt_double(double a, double b) {
        return Math.max(a, b) * Math.min(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10092().mul_opt_double(a, b));
    }
}
