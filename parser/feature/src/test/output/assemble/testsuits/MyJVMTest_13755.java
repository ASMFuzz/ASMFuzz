public class MyJVMTest_13755 {

    static Object src = 8;

    static int l = 203595380;

    static boolean flag = false;

    int test5(Object src, int l, boolean flag) {
        int[] dst = new int[10];
        if (flag) {
            dst[0] = 0x42;
            System.arraycopy(src, 0, dst, 0, l);
            return dst[0];
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13755().test5(src, l, flag));
    }
}
