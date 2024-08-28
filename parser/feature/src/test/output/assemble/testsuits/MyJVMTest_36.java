public class MyJVMTest_36 {

    static double a = Double.NaN;

    boolean test_isEqC(double a) {
        return a == 7.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_36().test_isEqC(a));
    }
}
