public class MyJVMTest_13771 {

    static double d = Double.NEGATIVE_INFINITY;

    static int result = 0;

    static int i1 = 1;

    static int i2 = 3;

    double test(double d) {
        result = (d <= 0.0D) ? i1 : i2;
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13771().test(d);
    }
}
