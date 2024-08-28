public class MyJVMTest_14685 {

    static double a = 0d;

    static double b = Double.NEGATIVE_INFINITY;

    boolean test_isGe(double a, double b) {
        return a >= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14685().test_isGe(a, b));
    }
}
