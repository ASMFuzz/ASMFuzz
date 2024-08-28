public class MyJVMTest_3150 {

    static int[] a = { 1, 1391062529, 0, 0, -1615983155, 7, 0, 0, 0, 0 };

    static int m = -1840242856;

    static int myKey = 7;

    static int myValue = 4;

    static long mySeed = -9223372036854775808L;

    int[] build(int[] a, int m) {
        int period = a.length / m;
        int v = 1, i = 0;
        for (int k = 0; k < m; k++) {
            v = 1;
            for (int p = 0; p < period; p++) {
                a[i++] = v++;
            }
        }
        for (int j = i; j < a.length - 1; j++) {
            a[j] = v++;
        }
        a[a.length - 1] = 0;
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3150().build(a, m);
    }
}
