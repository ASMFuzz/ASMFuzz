public class MyJVMTest_14947 {

    static int[] a = { 0, 4, 1114163970, -1253813365, 7, 5, 0, 0, -375300820, 0 };

    static int m = 1;

    static int myKey = 4;

    static int myValue = 0;

    static long mySeed = 0;

    int[] build(int[] a, int m) {
        int period = a.length / m;
        int v = -1, i = 0;
        for (int k = 0; k < m; k++) {
            v = -1;
            for (int p = 0; p < period; p++) {
                a[i++] = v--;
            }
        }
        for (int j = i; j < a.length - 1; j++) {
            a[j] = v--;
        }
        a[a.length - 1] = 0;
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14947().build(a, m);
    }
}
