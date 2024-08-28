public class MyJVMTest_13397 {

    static double a = Double.MAX_VALUE;

    static double b = Double.NaN;

    double test_div(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13397().test_div(a, b));
    }
}
