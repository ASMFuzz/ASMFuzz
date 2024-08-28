public class MyJVMTest_18099 {

    static short[] a = { 32767, -32768, -32768, 32767, 32767, 0, 32767, 24486, 32767, 32767 };

    static int myKey = 0;

    static int myValue = 6;

    static long mySeed = -1677047284037721601L;

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
        new MyJVMTest_18099().sortByInsertionSort(a);
    }
}
