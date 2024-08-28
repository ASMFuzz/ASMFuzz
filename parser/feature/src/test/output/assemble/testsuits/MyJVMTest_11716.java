public class MyJVMTest_11716 {

    static Integer[] a = { 8, 2079627958, 0, 2, 4, 0, 1, 1548418041, 0, 5 };

    static int myKey = 8;

    static int myValue = -73266981;

    static long mySeed = 0;

    Integer[] sortByInsertionSort(Integer[] a) {
        for (int j, i = 1; i < a.length; i++) {
            Integer ai = a[i];
            for (j = i - 1; j >= 0 && ai < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = ai;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11716().sortByInsertionSort(a);
    }
}
