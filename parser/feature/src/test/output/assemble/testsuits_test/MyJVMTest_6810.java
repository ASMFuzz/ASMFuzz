public class MyJVMTest_6810 {

    static Object[] src = { 1, 377073495, 9, 1, -990884477, 0, 0, 8, 7, 1 };

    static boolean[] dst = { true, false, true, false, true, false, false, false, true, true };

    Object[] init(Object[] src, boolean[] dst) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i] != null ? false : true;
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6810().init(src, dst);
    }
}
