public class MyJVMTest_5955 {

    static double x = Double.NaN;

    static double x0 = 0d;

    static double x1 = Double.NaN;

    static double y0 = 0d;

    static double y1 = 0d;

    static T value = null;

    double interpolate(double x, double x0, double x1, double y0, double y1) {
        return y0 + (x - x0) * (y1 - y0) / (x1 - x0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5955().interpolate(x, x0, x1, y0, y1));
    }
}
