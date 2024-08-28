public class MyJVMTest_15853 {

    static int[] dst = { 4, 6, 2, 0, 0, 0, 7, -1856756711, 0, -1913632868 };

    static int[] src = { 0, 0, 1, 4, 0, -151108895, 8, 8, 4, 0 };

    int[] test_copy_ints(int[] dst, int[] src) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = Integer.reverseBytes(src[i]);
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15853().test_copy_ints(dst, src);
    }
}
