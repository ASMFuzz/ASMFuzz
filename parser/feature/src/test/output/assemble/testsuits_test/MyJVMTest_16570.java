public class MyJVMTest_16570 {

    static int[] a = { 0, 7, 0, -1478113970, 0, 3, 0, 7, 0, 5 };

    static int i = 0;

    static int j = 8;

    static int myKey = -1174242169;

    static int myValue = 7;

    static long mySeed = 9223372036854775807L;

    int[] swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16570().swap(a, i, j);
    }
}
