public class MyJVMTest_15294 {

    static int[] a = { 7, 0, 6, -1187431448, 3, 7, 366774680, 6, -1430477840, 0 };

    static int m = 0;

    static int myKey = -1721809186;

    static int myValue = -1069158951;

    static long mySeed = 1170369522969438837L;

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
        new MyJVMTest_15294().build(a, m);
    }
}
