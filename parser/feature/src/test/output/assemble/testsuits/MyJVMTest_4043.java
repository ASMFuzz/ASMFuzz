public class MyJVMTest_4043 {

    static double a = 0d;

    static double b = Double.MIN_VALUE;

    double test_div(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4043().test_div(a, b));
    }
}
