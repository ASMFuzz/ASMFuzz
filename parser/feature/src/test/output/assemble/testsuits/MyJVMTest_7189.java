public class MyJVMTest_7189 {

    static long[] a = { -9223372036854775808L, -9223372036854775808L, 0, 9223372036854775807L, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    static int myKey = 0;

    static int myValue = 1;

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
        new MyJVMTest_7189().sortByInsertionSort(a);
    }
}
