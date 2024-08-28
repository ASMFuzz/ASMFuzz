public class MyJVMTest_4396 {

    static double d = Double.MIN_VALUE;

    static int result = 0;

    static int i1 = 1;

    static int i2 = 0;

    double test(double d) {
        result = (d <= 0.0D) ? i1 : i2;
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4396().test(d);
    }
}
