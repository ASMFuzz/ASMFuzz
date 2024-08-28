public class MyJVMTest_4594 {

    static double a = 0d;

    boolean test_isGeC(double a) {
        return a >= 7.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4594().test_isGeC(a));
    }
}
