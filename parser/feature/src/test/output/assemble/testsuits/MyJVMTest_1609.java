public class MyJVMTest_1609 {

    static double[] a = { Double.NEGATIVE_INFINITY, 0d, 0.0976360379323048, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY };

    static int myKey = 1;

    static int myValue = 3;

    static long mySeed = 9223372036854775807L;

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
        new MyJVMTest_1609().sortByInsertionSort(a);
    }
}
