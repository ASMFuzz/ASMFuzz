public class MyJVMTest_14964 {

    static char[] a = { '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'k', 'y', '5', Character.MIN_VALUE, '0' };

    static int myKey = 0;

    static int myValue = 0;

    static long mySeed = -9223372036854775808L;

    char[] sortByInsertionSort(char[] a) {
        for (int j, i = 1; i < a.length; i++) {
            char ai = a[i];
            for (j = i - 1; j >= 0 && ai < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = ai;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14964().sortByInsertionSort(a);
    }
}
