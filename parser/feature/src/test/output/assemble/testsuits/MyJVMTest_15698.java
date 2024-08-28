public class MyJVMTest_15698 {

    static double a = 0.6980441344258947;

    static double b = 0.6198137120335768;

    boolean test_isGt(double a, double b) {
        return a > b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15698().test_isGt(a, b));
    }
}
