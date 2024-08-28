public class MyJVMTest_17918 {

    static int[] dst = { 5, 2, 3, 4, -1751288610, 2, 2115793196, 1, 1329753262, 0 };

    static int[] src = { 9, 0, 858905335, 0, 8, 7, 926547788, 1, -1084175920, 0 };

    int[] test_copy_ints_reversed(int[] dst, int[] src) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = 1 + Integer.reverseBytes(src[i]);
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17918().test_copy_ints_reversed(dst, src);
    }
}
