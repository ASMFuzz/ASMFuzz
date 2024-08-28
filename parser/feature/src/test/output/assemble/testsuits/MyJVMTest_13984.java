public class MyJVMTest_13984 {

    static double a = 0.08711429483629396;

    boolean test_isGeC(double a) {
        return a >= 7.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13984().test_isGeC(a));
    }
}
