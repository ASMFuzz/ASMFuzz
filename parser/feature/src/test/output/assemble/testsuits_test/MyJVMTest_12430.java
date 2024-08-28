public class MyJVMTest_12430 {

    static double a = Double.NaN;

    boolean test_isGtC(double a) {
        return a > 7.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12430().test_isGtC(a));
    }
}
