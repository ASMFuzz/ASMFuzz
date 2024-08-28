public class MyJVMTest_410 {

    static double a = 0d;

    static double b = Double.MIN_VALUE;

    double check(double a, double b) {
        if (a != b)
            throw new Error(a + " != " + b);
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_410().check(a, b);
    }
}
