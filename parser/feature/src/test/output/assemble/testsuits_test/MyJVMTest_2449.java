public class MyJVMTest_2449 {

    static Integer[] a = { 9, 0, 0, 8, 0, 0, 4, 0, 245087156, 5 };

    static int myKey = 4;

    static int myValue = 1;

    static long mySeed = -9223372036854775808L;

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
        new MyJVMTest_2449().sortByInsertionSort(a);
    }
}
