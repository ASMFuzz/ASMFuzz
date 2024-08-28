public class MyJVMTest_569 {

    static double a = Double.MAX_VALUE;

    boolean test_isLtC(double a) {
        return a < 7.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_569().test_isLtC(a));
    }
}
