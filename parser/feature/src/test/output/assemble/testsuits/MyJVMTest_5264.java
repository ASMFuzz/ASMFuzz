public class MyJVMTest_5264 {

    static double a = Double.NaN;

    static double b = 0d;

    boolean test_isGe(double a, double b) {
        return a >= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5264().test_isGe(a, b));
    }
}
