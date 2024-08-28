public class MyJVMTest_5848 {

    static int[] a = { 5, 0, 6, -1450734277, -1504274087, 2, 1, 2, 0, 0 };

    static int m = 0;

    static int myKey = 6;

    static int myValue = -1906311605;

    static long mySeed = 0;

    int build(int[] a, int m) {
        int i = 0;
        int k = m;
        while (true) {
            for (int t = 1; t <= m; t++) {
                if (i >= a.length) {
                    return;
                }
                a[i++] = k;
            }
        }
        return m;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5848().build(a, m);
    }
}
