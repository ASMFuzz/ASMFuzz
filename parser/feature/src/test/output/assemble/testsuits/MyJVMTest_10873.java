public class MyJVMTest_10873 {

    static int[] src = { 0, 8, 1144428231, 0, 0, 0, 0, 2082385125, 8, 5 };

    static int len = 9;

    static boolean flag = true;

    boolean test_helper() {
        i++;
        if ((i % 10) == 0) {
            return false;
        }
        return true;
    }

    static long i = 0;

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
        System.out.println(new MyJVMTest_10873().test(src, len, flag));
    }
}
