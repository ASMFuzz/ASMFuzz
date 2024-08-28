public class MyJVMTest_14431 {

    static int seed = 0;

    static int a = 6;

    int init(int[] a, int seed) {
        for (int j = 0; j < a.length; j++) {
            a[j] = (j % 2 == 0) ? seed + j : seed - j;
        }
        return seed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14431().init(a, seed);
    }
}
