public class MyJVMTest_1400 {

    static byte[] a = { -123, 108, 89, -22, -62, 106, -67, -112, -104, -1 };

    static int myKey = 39853757;

    static int myValue = 0;

    static long mySeed = 0;

    byte[] sortByInsertionSort(byte[] a) {
        for (int j, i = 1; i < a.length; i++) {
            byte ai = a[i];
            for (j = i - 1; j >= 0 && ai < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = ai;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1400().sortByInsertionSort(a);
    }
}
