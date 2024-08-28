public class MyJVMTest_16733 {

    static boolean flag1 = false;

    static boolean flag2 = true;

    static boolean flag3 = true;

    static boolean flag4 = true;

    int not_inlined() {
        return 0;
    }

    static int f = 0;

    int test(boolean flag1, boolean flag2, boolean flag3, boolean flag4) {
        int v3 = 0;
        if (flag4) {
            for (int i = 0; i < 10; i++) {
                int v1 = 0;
                if (flag1) {
                    v1 = not_inlined();
                }
                int v2 = v1;
                if (flag2) {
                    v2 = f + v1;
                }
                if (flag3) {
                    v3 = v2 * 2;
                    break;
                }
            }
        }
        return v3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16733().test(flag1, flag2, flag3, flag4));
    }
}
