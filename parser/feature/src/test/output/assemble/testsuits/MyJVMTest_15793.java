public class MyJVMTest_15793 {

    static double a = 0d;

    static double b = 0d;

    boolean test_isLe(double a, double b) {
        return a <= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15793().test_isLe(a, b));
    }
}
