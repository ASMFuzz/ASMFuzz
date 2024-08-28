public class MyJVMTest_7053 {

    static int[] a = { 9, 1, 7, 9, 3, 4, 4, 5, 8, 0 };

    static int i = 8;

    static int j = 8;

    static int myKey = 8;

    static int myValue = 8;

    static long mySeed = 9223372036854775807L;

    int[] swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7053().swap(a, i, j);
    }
}
