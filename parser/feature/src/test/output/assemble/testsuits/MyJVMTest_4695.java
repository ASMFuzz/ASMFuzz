public class MyJVMTest_4695 {

    static double a = Double.NaN;

    boolean test_isLeC(double a) {
        return a <= 7.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4695().test_isLeC(a));
    }
}
