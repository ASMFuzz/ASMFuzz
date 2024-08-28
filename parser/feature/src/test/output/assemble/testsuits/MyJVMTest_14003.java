public class MyJVMTest_14003 {

    static int[] a = { 7, 5, 3, 9, 0, 610207372, 4, 0, 457394364, 4 };

    static int myKey = 1093958128;

    static int myValue = 5;

    static long mySeed = 0;

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
        new MyJVMTest_14003().sortByInsertionSort(a);
    }
}
