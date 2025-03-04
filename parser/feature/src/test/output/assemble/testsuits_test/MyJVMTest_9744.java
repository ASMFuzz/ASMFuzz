public class MyJVMTest_9744 {

    static double a = Double.NaN;

    double test(double a) throws Exception {
        if (a < 0.0)
            return;
        double r1 = Math.sqrt(a);
        double r2 = Math.pow(a, 0.5);
        if (r1 != r2) {
            throw new RuntimeException("pow(" + a + ", 0.5), expected: " + r1 + ", actual: " + r2);
        }
        double r = Math.pow(+0.0, 0.5);
        if (Double.doubleToRawLongBits(r) != Double.doubleToRawLongBits(0.0)) {
            throw new RuntimeException("pow(+0.0, 0.5), expected: 0.0, actual: " + r);
        }
        r = Math.pow(-0.0, 0.5);
        if (Double.doubleToRawLongBits(r) != Double.doubleToRawLongBits(0.0)) {
            throw new RuntimeException("pow(-0.0, 0.5), expected: 0.0, actual: " + r);
        }
        r = Math.pow(Double.POSITIVE_INFINITY, 0.5);
        if (!(r > 0 && Double.isInfinite(r))) {
            throw new RuntimeException("pow(+Infinity, 0.5), expected: Infinity, actual: " + r);
        }
        r = Math.pow(Double.NEGATIVE_INFINITY, 0.5);
        if (!(r > 0 && Double.isInfinite(r))) {
            throw new RuntimeException("pow(-Infinity, 0.5), expected: Infinity, actual: " + r);
        }
        r = Math.pow(Double.NaN, 0.5);
        if (!Double.isNaN(r)) {
            throw new RuntimeException("pow(NaN, 0.5), expected: NaN, actual: " + r);
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9744().test(a);
    }
}
