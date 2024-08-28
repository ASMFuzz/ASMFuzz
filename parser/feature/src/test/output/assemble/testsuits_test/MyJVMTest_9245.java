public class MyJVMTest_9245 {

    static double[] a = { 0d, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0.6004248917612659 };

    static int i = 0;

    static int j = 0;

    static int myKey = -1291305786;

    static int myValue = 0;

    static long mySeed = 9223372036854775807L;

    double[] swap(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9245().swap(a, i, j);
    }
}
