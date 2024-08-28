public class MyJVMTest_16355 {

    static int[] src = { 7, 9, 3, -973423179, 3, 0, 0, 0, 7, 0 };

    static boolean flag = true;

    boolean m3(int[] src, boolean flag) {
        int[] dst = new int[10];
        System.arraycopy(src, 0, dst, 0, 10);
        if (flag) {
            for (int i = 0; i < dst.length; i++) {
                if (dst[i] != src[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16355().m3(src, flag));
    }
}
