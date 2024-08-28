public class MyJVMTest_9941 {

    static double a = Double.MAX_VALUE;

    static double b = 0d;

    double test_rem(double a, double b) {
        return a % b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9941().test_rem(a, b));
    }
}
