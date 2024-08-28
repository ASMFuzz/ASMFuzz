public class MyJVMTest_9175 {

    static double a = Double.NEGATIVE_INFINITY;

    boolean test_isEqC(double a) {
        return a == 7.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9175().test_isEqC(a));
    }
}
