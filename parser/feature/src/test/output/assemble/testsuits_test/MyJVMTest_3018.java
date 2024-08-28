public class MyJVMTest_3018 {

    static double a = Double.NEGATIVE_INFINITY;

    static double b = 0.0569100203425571;

    static double dmin = Double.NaN;

    static double dmax = Double.MAX_VALUE;

    static double dadd = Double.MIN_VALUE;

    static double dmul = 0d;

    static double edmin = Double.NaN;

    static double edmax = Double.NaN;

    static double edadd = Double.POSITIVE_INFINITY;

    static double edmul = Double.NEGATIVE_INFINITY;

    double dCheck(double a, double b, double dmin, double dmax, double dadd, double dmul, double edmin, double edmax, double edadd, double edmul) {
        long min = Double.doubleToRawLongBits(dmin);
        long max = Double.doubleToRawLongBits(dmax);
        long add = Double.doubleToRawLongBits(dadd);
        long mul = Double.doubleToRawLongBits(dmul);
        long emin = Double.doubleToRawLongBits(edmin);
        long emax = Double.doubleToRawLongBits(edmax);
        long eadd = Double.doubleToRawLongBits(edadd);
        long emul = Double.doubleToRawLongBits(edmul);
        if (min != emin || max != emax || add != eadd || mul != emul) {
            throw new AssertionError("Unexpected result of double test: " + "a = " + a + ", b = " + b + ", " + "result = (" + dmin + ", " + dmax + ", " + dadd + ", " + dmul + "), " + "expected = (" + edmin + ", " + edmax + ", " + edadd + ", " + edmul + ")");
        }
        return edadd;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3018().dCheck(a, b, dmin, dmax, dadd, dmul, edmin, edmax, edadd, edmul);
    }
}
