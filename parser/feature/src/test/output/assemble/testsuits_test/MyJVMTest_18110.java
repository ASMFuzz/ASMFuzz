public class MyJVMTest_18110 {

    static int i = 3;

    static int a = -862740251;

    static int b = -2144034118;

    static boolean flag = true;

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
        new MyJVMTest_18110().helper2(i, a, b, flag);
    }
}
