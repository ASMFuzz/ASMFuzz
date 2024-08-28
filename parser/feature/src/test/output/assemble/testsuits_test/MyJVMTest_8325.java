public class MyJVMTest_8325 {

    static double a = Double.POSITIVE_INFINITY;

    static double b = Double.NaN;

    double test_sub(double a, double b) {
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8325().test_sub(a, b));
    }
}
