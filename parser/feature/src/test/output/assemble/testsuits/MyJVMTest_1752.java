public class MyJVMTest_1752 {

    static double[] a = { 0d, Double.MAX_VALUE, 0.9653521446266274, Double.MAX_VALUE, 0.1280450830302211, Double.NaN, 0d, Double.MIN_VALUE, 0.2763604778211737, Double.POSITIVE_INFINITY };

    static double value = Double.MAX_VALUE;

    static int fromIndex = 1375634282;

    static int count = -2002494888;

    static int myKey = 4;

    static int myValue = -952253267;

    static long mySeed = -6319040648581481405L;

    int writeValue(double[] a, double value, int fromIndex, int count) {
        for (int i = fromIndex; i < fromIndex + count; i++) {
            a[i] = value;
        }
        return fromIndex;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1752().writeValue(a, value, fromIndex, count);
    }
}
