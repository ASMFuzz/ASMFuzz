public class MyJVMTest_7403 {

    static double xmin = Double.MIN_VALUE;

    static double xmax = Double.MAX_VALUE;

    static double ymin = Double.NEGATIVE_INFINITY;

    static double ymax = 0d;

    double log10(double x) {
        return Math.log(x) / Math.log(10);
    }

    static double m = Double.MAX_VALUE;

    static double b = Double.POSITIVE_INFINITY;

    double calcMapping(double xmin, double xmax, double ymin, double ymax) {
        m = (ymax - ymin) / (log10(xmax) - log10(xmin));
        b = (log10(xmin) * ymax - log10(xmax) * ymin);
        return xmax;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7403().calcMapping(xmin, xmax, ymin, ymax);
    }
}
