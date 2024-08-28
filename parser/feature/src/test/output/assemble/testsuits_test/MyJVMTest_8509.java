public class MyJVMTest_8509 {

    static short[] a = { 32767, 7807, 10904, 32767, -32768, 0, -32768, 0, -3943, 9248 };

    static int myKey = 9;

    static int myValue = 1;

    static long mySeed = 0;

    short[] sortByInsertionSort(short[] a) {
        for (int j, i = 1; i < a.length; i++) {
            short ai = a[i];
            for (j = i - 1; j >= 0 && ai < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = ai;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8509().sortByInsertionSort(a);
    }
}
