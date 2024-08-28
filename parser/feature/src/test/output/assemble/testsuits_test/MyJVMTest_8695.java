public class MyJVMTest_8695 {

    static int[] a = { 0, 1, 0, 8, 9, 3, 0, -2098722271, 0, 0 };

    static int seed = 0;

    int init(int[] a, int seed) {
        for (int j = 0; j < a.length; j++) {
            a[j] = (j % 2 == 0) ? seed + j : seed - j;
        }
        return seed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8695().init(a, seed);
    }
}
