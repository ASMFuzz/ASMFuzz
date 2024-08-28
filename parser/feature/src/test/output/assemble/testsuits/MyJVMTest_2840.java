public class MyJVMTest_2840 {

    static double v1 = Double.MIN_VALUE;

    static double v2 = Double.NaN;

    static double t = Double.NaN;

    double interp(double v1, double v2, double t) {
        return (v1 * (1 - t) + v2 * t);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2840().interp(v1, v2, t));
    }
}
