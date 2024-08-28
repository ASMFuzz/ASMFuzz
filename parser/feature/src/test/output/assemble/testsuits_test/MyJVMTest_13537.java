public class MyJVMTest_13537 {

    static double v = Double.MIN_VALUE;

    static double x = Double.POSITIVE_INFINITY;

    double setX(double v) {
        x = -v;
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13537().setX(v);
    }
}
