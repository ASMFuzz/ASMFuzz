public class MyJVMTest_12612 {

    static int[] a = { 2, 0, 0, 8, 3, 0, 6, 0, 0, 5 };

    static int m = 2;

    static int myKey = -808982792;

    static int myValue = 6;

    static long mySeed = 9223372036854775807L;

    int[] build(int[] a, int m) {
        int period = a.length / m;
        int i = 0;
        int k = 0;
        while (true) {
            for (int t = 1; t <= period; t++) {
                if (i >= a.length) {
                    return;
                }
                a[i++] = k;
            }
            if (i >= a.length) {
                return;
            }
            k++;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12612().build(a, m);
    }
}
