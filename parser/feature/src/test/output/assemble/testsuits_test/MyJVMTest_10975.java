public class MyJVMTest_10975 {

    static double[] a = { 0d, Double.POSITIVE_INFINITY, 0d, 0.6577242408173614, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.9963604069342697, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static double value = Double.POSITIVE_INFINITY;

    static int fromIndex = 6;

    static int count = 1;

    static int myKey = 1127841228;

    static int myValue = 382820668;

    static long mySeed = 9223372036854775807L;

    int writeValue(double[] a, double value, int fromIndex, int count) {
        for (int i = fromIndex; i < fromIndex + count; i++) {
            a[i] = value;
        }
        return fromIndex;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10975().writeValue(a, value, fromIndex, count);
    }
}
