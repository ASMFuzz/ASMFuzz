public class MyJVMTest_8080 {

    static int[] src = { 4, 1615843766, -1468848523, 820630827, 4, 1347273201, 0, 2, 9, 6 };

    static boolean flag1 = true;

    static boolean flag2 = true;

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
        System.out.println(new MyJVMTest_8080().m5(src, flag1, flag2));
    }
}
