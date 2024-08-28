public class MyJVMTest_14914 {

    static double a = 0.509654537639499;

    static double b = Double.MIN_VALUE;

    double test_add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14914().test_add(a, b));
    }
}
