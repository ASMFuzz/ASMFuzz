public class MyJVMTest_8520 {

    static int i = 267834223;

    static int a = -328338522;

    static int b = 2;

    static boolean flag = false;

    static boolean test2_taken = true;

    int helper2(int i, int a, int b, boolean flag) {
        if (flag) {
            if (i > b || i <= a) {
                test2_taken = true;
            }
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8520().helper2(i, a, b, flag);
    }
}
