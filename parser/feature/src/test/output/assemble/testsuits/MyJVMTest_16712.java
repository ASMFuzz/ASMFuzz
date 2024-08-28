public class MyJVMTest_16712 {

    static long[] a = { -9223372036854775808L, 3406701716530587508L, -5686224815859463382L, 0, -3660019495876201580L, 9223372036854775807L, 0, -5537836316581626366L, 0, -5915629682523140551L };

    static int myKey = 0;

    static int myValue = 8;

    static long mySeed = 9223372036854775807L;

    long[] sortByInsertionSort(long[] a) {
        for (int j, i = 1; i < a.length; i++) {
            long ai = a[i];
            for (j = i - 1; j >= 0 && ai < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = ai;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16712().sortByInsertionSort(a);
    }
}
