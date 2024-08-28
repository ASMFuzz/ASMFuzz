public class MyJVMTest_4613 {

    static int[] a = { 2, 1383459978, 8, 0, -2128907279, 0, 0, 3, 0, 2 };

    static int myKey = -1501293121;

    static int myValue = 0;

    static long mySeed = -9223372036854775808L;

    int[] sortByInsertionSort(int[] a) {
        for (int j, i = 1; i < a.length; i++) {
            int ai = a[i];
            for (j = i - 1; j >= 0 && ai < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = ai;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4613().sortByInsertionSort(a);
    }
}
