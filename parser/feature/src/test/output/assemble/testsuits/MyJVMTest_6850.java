public class MyJVMTest_6850 {

    static int[] src = { 0, 0, -979570684, 1279264678, 0, 5, 0, 0, 7, -1452003536 };

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
        System.out.println(new MyJVMTest_6850().m3(src, flag));
    }
}
