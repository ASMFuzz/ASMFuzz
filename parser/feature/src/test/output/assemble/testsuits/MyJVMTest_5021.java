public class MyJVMTest_5021 {

    static int seed = -1880698582;

    static int a = 0;

    int init(int[] a, int seed) {
        for (int j = 0; j < a.length; j++) {
            a[j] = (j % 2 == 0) ? seed + j : seed - j;
        }
        return seed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5021().init(a, seed);
    }
}
