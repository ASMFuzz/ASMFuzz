public class MyJVMTest_4639 {

    static double a = Double.NEGATIVE_INFINITY;

    static double b = Double.MIN_VALUE;

    boolean test_isEq(double a, double b) {
        return a == b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4639().test_isEq(a, b));
    }
}
