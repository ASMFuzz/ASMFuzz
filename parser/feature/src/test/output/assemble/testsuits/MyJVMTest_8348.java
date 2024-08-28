public class MyJVMTest_8348 {

    static double a = Double.MIN_VALUE;

    static double b = Double.MIN_VALUE;

    boolean test_isLt(double a, double b) {
        return a < b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8348().test_isLt(a, b));
    }
}
