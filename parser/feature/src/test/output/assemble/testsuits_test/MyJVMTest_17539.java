public class MyJVMTest_17539 {

    static int[] src = { 3, 6, 9, -889802455, 0, 1, 5, 9, 0, 1 };

    static int[] dst = { 718015527, 0, 6, 1856596599, 8, 7, 6, 4, 5, -1057362843 };

    static int[] ref = { 0, 6, 7, -1196882555, 8, -1223101121, 4, -1172947086, 9, 9 };

    int[] init(int[] src, int[] dst, int[] ref) {
        for (int i = 0; i < src.length; i++) {
            src[i] = i;
            dst[i] = 2;
            ref[i] = src[i];
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17539().init(src, dst, ref);
    }
}
