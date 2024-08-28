public class MyJVMTest_1526 {

    static int[] src = { 1293005267, 1, 0, 552400121, 1354886335, 1848262693, 9, -1831930690, 2, 3 };

    static boolean flag1 = true;

    static boolean flag2 = false;

    static int stop = 0;

    int test(int[] src, boolean flag1, boolean flag2, int stop) {
        int v = 0;
        int j = 1;
        for (; j < 10; j++) {
            for (int i = 0; i < 2; i++) {
            }
        }
        int[] dst = new int[10];
        for (int i = 0; i < stop; i++) {
            if (flag1) {
                System.arraycopy(src, 0, dst, 0, j);
                v = dst[9];
                if (flag2) {
                    src[9] = 0x42;
                }
            }
        }
        return v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1526().test(src, flag1, flag2, stop));
    }
}
