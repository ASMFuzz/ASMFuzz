public class MyJVMTest_12136 {

    static double v1 = Double.POSITIVE_INFINITY;

    static double v2 = 0.6153692773390607;

    static double t = Double.POSITIVE_INFINITY;

    double interp(double v1, double v2, double t) {
        return (v1 * (1 - t) + v2 * t);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12136().interp(v1, v2, t));
    }
}
