public class MyJVMTest_10611 {

    static byte[] a = { -128, 42, -34, 63, -34, 60, -32, 85, 81, -91 };

    static int myKey = 6;

    static int myValue = 1659214691;

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
        new MyJVMTest_10611().sortByInsertionSort(a);
    }
}
