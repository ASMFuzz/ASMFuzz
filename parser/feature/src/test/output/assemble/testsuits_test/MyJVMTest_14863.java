public class MyJVMTest_14863 {

    static int[] dst = { 6, -2023700456, 6, 7, -569298716, 3, 44432989, 660321396, 3, 9 };

    static int[] src = { 447221618, -73182820, 1206583327, 1, 0, 8, 0, 2, 0, 0 };

    int[] test_copy_ints_store_reversed(int[] dst, int[] src) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = Integer.reverseBytes(1 + src[i]);
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14863().test_copy_ints_store_reversed(dst, src);
    }
}
