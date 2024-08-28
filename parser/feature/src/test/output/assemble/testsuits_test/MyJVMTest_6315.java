public class MyJVMTest_6315 {

    static double a = Double.MIN_VALUE;

    static double b = Double.POSITIVE_INFINITY;

    boolean test_isLe(double a, double b) {
        return a <= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6315().test_isLe(a, b));
    }
}
