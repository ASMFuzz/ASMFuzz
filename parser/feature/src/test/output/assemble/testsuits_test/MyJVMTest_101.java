public class MyJVMTest_101 {

    static double[] a = { Double.NaN, Double.MIN_VALUE, 0.30859982236376826, 0.3583678785106249, Double.NEGATIVE_INFINITY, 0d, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0d };

    static int i = 0;

    static int j = -1665092726;

    static int myKey = 0;

    static int myValue = 0;

    static long mySeed = 0;

    double[] swap(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_101().swap(a, i, j);
    }
}
