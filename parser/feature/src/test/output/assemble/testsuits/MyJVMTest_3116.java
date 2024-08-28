public class MyJVMTest_3116 {

    static double a = 0.8877639124014417;

    boolean test_isGtC(double a) {
        return a > 7.;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3116().test_isGtC(a));
    }
}
