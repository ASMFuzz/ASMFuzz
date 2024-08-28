public class MyJVMTest_8338 {

    static int[] dst = { 0, 5, -984575860, 4, -795668532, 5, 0, -253497226, 0, 0 };

    static int[] src = { 7, 3, 0, -999351132, -714351338, 7, 9, 9, 1477319426, 5 };

    int[] test_copy_ints_reversed(int[] dst, int[] src) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = 1 + Integer.reverseBytes(src[i]);
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8338().test_copy_ints_reversed(dst, src);
    }
}
