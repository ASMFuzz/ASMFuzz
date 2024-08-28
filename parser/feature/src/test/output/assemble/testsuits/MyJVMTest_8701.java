public class MyJVMTest_8701 {

    static double a = Double.MIN_VALUE;

    double test(double a) {
        double r1 = a * a;
        double r2 = Math.pow(a, 2.0);
        if (r1 != r2) {
            throw new RuntimeException("pow(" + a + ", 2.0), expected: " + r1 + ", actual: " + r2);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8701().test(a);
    }
}
