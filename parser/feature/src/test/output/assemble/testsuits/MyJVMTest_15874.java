public class MyJVMTest_15874 {

    static double a = Double.MIN_VALUE;

    double test_neg(double a) {
        return -a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15874().test_neg(a));
    }
}
