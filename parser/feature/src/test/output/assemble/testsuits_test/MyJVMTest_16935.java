public class MyJVMTest_16935 {

    static double xmin = 0.5568990030562434;

    static double xmax = 0d;

    static double ymin = Double.MIN_VALUE;

    static double ymax = 0.34952924261124196;

    double log10(double x) {
        return Math.log(x) / Math.log(10);
    }

    static double m = Double.NEGATIVE_INFINITY;

    static double b = Double.NEGATIVE_INFINITY;

    double calcMapping(double xmin, double xmax, double ymin, double ymax) {
        m = (ymax - ymin) / (log10(xmax) - log10(xmin));
        b = (log10(xmin) * ymax - log10(xmax) * ymin);
        return xmax;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16935().calcMapping(xmin, xmax, ymin, ymax);
    }
}
