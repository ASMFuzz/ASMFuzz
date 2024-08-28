public class MyJVMTest_9735 {

    static double a = Double.NaN;

    boolean test_isLtC(double a) {
        return a < 7.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9735().test_isLtC(a));
    }
}
