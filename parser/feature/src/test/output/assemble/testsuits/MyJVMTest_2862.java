public class MyJVMTest_2862 {

    static double a = Double.POSITIVE_INFINITY;

    static double b = Double.POSITIVE_INFINITY;

    double min_opt_double(double a, double b) {
        return Math.min(Math.max(a, b), Math.min(a, b));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2862().min_opt_double(a, b));
    }
}
