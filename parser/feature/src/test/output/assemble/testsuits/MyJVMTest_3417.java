public class MyJVMTest_3417 {

    static double a = 0.12523588569038047;

    static double[] sums = {Double.MAX_VALUE,Double.POSITIVE_INFINITY,0d,Double.POSITIVE_INFINITY,Double.NaN,Double.MAX_VALUE,Double.NaN,0d,Double.NaN,Double.NEGATIVE_INFINITY};

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
        new MyJVMTest_3417().add(a);
    }
}
