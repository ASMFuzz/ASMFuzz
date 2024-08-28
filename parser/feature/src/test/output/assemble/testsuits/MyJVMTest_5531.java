public class MyJVMTest_5531 {

    static char[] a = { Character.MIN_VALUE, 'F', '0', '(', ']', 'V', 'I', 'n', Character.MIN_VALUE, '0' };

    static int myKey = 0;

    static int myValue = 1165946211;

    static long mySeed = 8545483814900187205L;

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
        new MyJVMTest_5531().sortByInsertionSort(a);
    }
}
