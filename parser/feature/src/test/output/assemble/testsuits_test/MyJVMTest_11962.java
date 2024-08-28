public class MyJVMTest_11962 {

    static int i = 5;

    static int a = 0;

    static int b = 3;

    static boolean flag = false;

    static boolean test4_taken = true;

    int helper4(int i, int a, int b, boolean flag) {
        if (flag) {
            if (i > b - 1 || i < a) {
                test4_taken = true;
            }
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11962().helper4(i, a, b, flag);
    }
}
