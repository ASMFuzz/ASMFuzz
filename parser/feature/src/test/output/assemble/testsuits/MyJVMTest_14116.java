public class MyJVMTest_14116 {

    static int[] a = { 0, 0, 2, 0, 0, 2, 1609386261, 0, 0, 1844136156 };

    static int seed = 9;

    int init(int[] a, int seed) {
        for (int j = 0; j < a.length; j++) {
            a[j] = (j % 2 == 0) ? seed + j : seed - j;
        }
        return seed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14116().init(a, seed);
    }
}
