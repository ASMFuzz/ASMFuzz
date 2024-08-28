public class MyJVMTest_16160 {

    static double a = Double.MAX_VALUE;

    static double b = Double.MIN_VALUE;

    boolean test_isNe(double a, double b) {
        return a != b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16160().test_isNe(a, b));
    }
}
