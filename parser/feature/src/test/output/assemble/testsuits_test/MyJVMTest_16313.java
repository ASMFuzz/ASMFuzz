public class MyJVMTest_16313 {

    static Object[] src = { -1379769943, 3, 4, 1745528170, 0, 2, 4, 0, 7, 1419045154 };

    static boolean[] dst = { true, false, false, true, false, true, true, false, true, false };

    Object[] init(Object[] src, boolean[] dst) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i] != null ? false : true;
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16313().init(src, dst);
    }
}
