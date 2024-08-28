public class MyJVMTest_5484 {

    static double a = Double.POSITIVE_INFINITY;

    static double b = 0.7392698621650438;

    double test_add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5484().test_add(a, b));
    }
}
