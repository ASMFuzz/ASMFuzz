public class MyJVMTest_10745 {

    static int[] src = { 773401768, 4, 1, 0, 289852154, 0, 5, -684613246, 4, 4 };

    static boolean flag1 = false;

    static boolean flag2 = false;

    static int stop = 1773168307;

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
        System.out.println(new MyJVMTest_10745().test(src, flag1, flag2, stop));
    }
}
