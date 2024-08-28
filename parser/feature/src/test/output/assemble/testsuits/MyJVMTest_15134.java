public class MyJVMTest_15134 {

    static int[] src = { -933463064, -411589332, 0, 0, 0, 1, 0, 8, 9, 7 };

    static boolean flag = true;

    boolean m4(int[] src, boolean flag) {
        int[] dst = new int[10];
        dst[0] = 0x42;
        dst[1] = 0x42 - 1;
        dst[2] = 0x42 - 2;
        dst[8] = 0x42 - 8;
        dst[9] = 0x42 - 9;
        int src_off = 2;
        int dst_off = 3;
        int len = 5;
        System.arraycopy(src, src_off, dst, dst_off, len);
        if (flag) {
            for (int i = 0; i < dst.length; i++) {
                if (i >= dst_off && i < dst_off + len) {
                    if (dst[i] != src[i - dst_off + src_off]) {
                        return false;
                    }
                } else {
                    if (dst[i] != 0x42 - i) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15134().m4(src, flag));
    }
}
