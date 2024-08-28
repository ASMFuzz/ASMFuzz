public class MyJVMTest_17928 {

    static double a = Double.NaN;

    static double b = Double.POSITIVE_INFINITY;

    boolean test_isLt(double a, double b) {
        return a < b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17928().test_isLt(a, b));
    }
}
