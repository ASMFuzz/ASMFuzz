public class MyJVMTest_16831 {

    static double a = Double.POSITIVE_INFINITY;

    boolean test_isNeC(double a) {
        return a != 7.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16831().test_isNeC(a));
    }
}
