public class MyJVMTest_17649 {

    static int[] src = { 442398788, 0, 0, 1441521613, 8, 0, 6, 1454494921, 6, -1926483322 };

    static boolean flag1 = false;

    static boolean flag2 = false;

    boolean m5(int[] src, boolean flag1, boolean flag2) {
        int[] dst = new int[10];
        if (flag1) {
            System.arraycopy(src, 0, dst, 0, 10);
        }
        if (flag2) {
            for (int i = 0; i < dst.length; i++) {
                if (dst[i] != src[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17649().m5(src, flag1, flag2));
    }
}
