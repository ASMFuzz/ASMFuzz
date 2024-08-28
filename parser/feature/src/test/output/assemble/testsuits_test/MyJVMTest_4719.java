public class MyJVMTest_4719 {

    static int[] a = { 0, 1005959784, 0, 0, 2, 0, 0, 8, 0, 0 };

    static int seed = -1426612522;

    int init(int[] a, int seed) {
        for (int j = 0; j < a.length; j++) {
            a[j] = (j % 2 == 0) ? seed + j : seed - j;
        }
        return seed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4719().init(a, seed);
    }
}
