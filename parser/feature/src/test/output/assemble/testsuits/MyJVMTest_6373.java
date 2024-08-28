public class MyJVMTest_6373 {

    static int[] dst = { 9, 0, 8, 1355253492, 339795307, 1741409429, 9, 2, 0, -344984384 };

    static int[] src = { 0, -531428775, 6, 0, 0, 0, 2, 974911944, 606426442, -472428590 };

    int[] test_copy_ints(int[] dst, int[] src) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = Integer.reverseBytes(src[i]);
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6373().test_copy_ints(dst, src);
    }
}
