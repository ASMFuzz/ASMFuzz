public class MyJVMTest_6225 {

    static double a = 0d;

    static double b = Double.MIN_VALUE;

    boolean test_isGt(double a, double b) {
        return a > b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6225().test_isGt(a, b));
    }
}
