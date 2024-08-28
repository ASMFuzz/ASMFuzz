public class MyJVMTest_12466 {

    static int[] a = { 6, 1, 0, 7, 9, 1269919196, -1161564713, 0, 2, 6 };

    static int m = 1;

    static int myKey = 7;

    static int myValue = 1846017770;

    static long mySeed = 4911065758178249181L;

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
        new MyJVMTest_12466().build(a, m);
    }
}
