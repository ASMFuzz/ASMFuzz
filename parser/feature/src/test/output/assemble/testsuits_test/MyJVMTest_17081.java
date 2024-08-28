public class MyJVMTest_17081 {

    static double a = Double.MAX_VALUE;

    static double b = Double.MAX_VALUE;

    double test_mul(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17081().test_mul(a, b));
    }
}
