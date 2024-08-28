public class MyJVMTest_5434 {

    static int[] dst = { 0, 0, -1144721837, 2, -730855619, 2, 1430368125, 2, 7, 0 };

    static int[] src = { 1187315282, -1211333033, 3, 0, 0, 1, 0, 0, 5, 1418495398 };

    int[] test_copy_ints_store_reversed(int[] dst, int[] src) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = Integer.reverseBytes(1 + src[i]);
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5434().test_copy_ints_store_reversed(dst, src);
    }
}
