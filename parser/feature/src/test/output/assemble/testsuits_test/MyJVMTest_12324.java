public class MyJVMTest_12324 {

    static double a = Double.NaN;

    static double b = Double.MIN_VALUE;

    static double dmin = 0d;

    static double dmax = Double.POSITIVE_INFINITY;

    static double dadd = Double.MAX_VALUE;

    static double dmul = Double.MIN_VALUE;

    static double edmin = Double.NaN;

    static double edmax = Double.POSITIVE_INFINITY;

    static double edadd = Double.NaN;

    static double edmul = Double.NaN;

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
        new MyJVMTest_12324().dCheck(a, b, dmin, dmax, dadd, dmul, edmin, edmax, edadd, edmul);
    }
}
