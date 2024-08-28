public class MyJVMTest_15408 {

    static double x = 0d;

    static double x0 = 0.645692177717347;

    static double x1 = Double.MIN_VALUE;

    static double y0 = Double.MIN_VALUE;

    static double y1 = 0.37314244857545564;

    static T value = null;

    double interpolate(double x, double x0, double x1, double y0, double y1) {
        return y0 + (x - x0) * (y1 - y0) / (x1 - x0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15408().interpolate(x, x0, x1, y0, y1));
    }
}
