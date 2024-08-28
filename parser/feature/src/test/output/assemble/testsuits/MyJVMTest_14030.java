public class MyJVMTest_14030 {

    static double a = Double.NEGATIVE_INFINITY;

    static double b = Double.POSITIVE_INFINITY;

    boolean test_isEq(double a, double b) {
        return a == b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14030().test_isEq(a, b));
    }
}
