public class MyJVMTest_7540 {

    static double a = Double.MAX_VALUE;

    static double b = Double.NEGATIVE_INFINITY;

    double test_mul(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7540().test_mul(a, b));
    }
}
