public class MyJVMTest_7305 {

    static double a = 0.14248614651261626;

    boolean test_isNeC(double a) {
        return a != 7.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7305().test_isNeC(a));
    }
}
