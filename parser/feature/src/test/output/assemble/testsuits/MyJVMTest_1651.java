public class MyJVMTest_1651 {

    static int[] src = { 1794773849, 8, 5, 1626706970, 6, 0, 0, 7, 0, 0 };

    static int len = 4;

    static boolean flag = true;

    boolean test_helper() {
        i++;
        if ((i % 10) == 0) {
            return false;
        }
        return true;
    }

    static long i = 7821239450944822926L;

    int test(int[] src, int len, boolean flag) {
        int[] dest = new int[10];
        int res = 0;
        while (test_helper()) {
            System.arraycopy(src, 0, dest, 0, len);
            if (flag) {
            }
            res = dest[0];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1651().test(src, len, flag));
    }
}
