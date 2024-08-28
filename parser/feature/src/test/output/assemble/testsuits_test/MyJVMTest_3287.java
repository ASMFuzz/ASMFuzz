public class MyJVMTest_3287 {

    static int[] a = { 0, 0, 0, 1300062710, 527302951, 9, 8, 0, 3, 5 };

    static int m = 3;

    static int myKey = 0;

    static int myValue = 0;

    static long mySeed = -8207471958167416130L;

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
        new MyJVMTest_3287().build(a, m);
    }
}
