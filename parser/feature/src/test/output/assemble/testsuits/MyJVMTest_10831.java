public class MyJVMTest_10831 {

    static double[] a = { 0.7789530352677333, Double.NaN, Double.NEGATIVE_INFINITY, 0d, 0d, 0d, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static int myKey = 1342084298;

    static int myValue = 9;

    static long mySeed = 0;

    double[] sortByInsertionSort(double[] a) {
        for (int j, i = 1; i < a.length; i++) {
            double ai = a[i];
            for (j = i - 1; j >= 0 && ai < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = ai;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10831().sortByInsertionSort(a);
    }
}
