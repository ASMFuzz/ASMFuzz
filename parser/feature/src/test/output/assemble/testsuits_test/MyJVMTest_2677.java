public class MyJVMTest_2677 {

    static int i = 4;

    static int a = 0;

    static int b = 8;

    static boolean flag = true;

    static boolean test4_taken = false;

    int helper4(int i, int a, int b, boolean flag) {
        if (flag) {
            if (i > b - 1 || i < a) {
                test4_taken = true;
            }
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2677().helper4(i, a, b, flag);
    }
}
