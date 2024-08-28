public class MyJVMTest_17903 {

    static double a = 0.11039556411344409;

    static double b = Double.NEGATIVE_INFINITY;

    double test_sub(double a, double b) {
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17903().test_sub(a, b));
    }
}
