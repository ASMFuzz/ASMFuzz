public class MyJVMTest_12747 {

    static double a = 0.5320371930895728;

    static double[] sums = {0d,Double.NaN,0d,Double.POSITIVE_INFINITY,0d,Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE,0d,Double.MIN_VALUE};

    double add(double a) {
        try {
            sums[sums.length] = -1;
        } catch (final IndexOutOfBoundsException e) {
            final double[] oldSums = sums;
            sums = new double[oldSums.length + 1];
            System.arraycopy(oldSums, 0, sums, 0, oldSums.length);
            sums[oldSums.length] = a;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12747().add(a);
    }
}
