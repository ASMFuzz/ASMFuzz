public class MyJVMTest_7975 {

    static int[] src = { -28857554, 8, -1721021211, 6, 8, 0, -34091290, 8, 0, 0 };

    static int[] dst = { 0, 0, 0, 6, 5, 1201897028, 4, 5, 0, 2 };

    static int[] ref = { 0, 8, -1031076781, 9, 0, 0, 3, 0, 8, 9 };

    int[] init(int[] src, int[] dst, int[] ref) {
        for (int i = 0; i < src.length; i++) {
            src[i] = i;
            dst[i] = 2;
            ref[i] = src[i];
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7975().init(src, dst, ref);
    }
}
