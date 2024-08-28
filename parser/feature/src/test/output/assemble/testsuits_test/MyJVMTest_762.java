public class MyJVMTest_762 {

    static double a = Double.POSITIVE_INFINITY;

    static double b = Double.MIN_VALUE;

    double test_rem(double a, double b) {
        return a % b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_762().test_rem(a, b));
    }
}
