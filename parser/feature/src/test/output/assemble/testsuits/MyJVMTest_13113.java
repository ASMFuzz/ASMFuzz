public class MyJVMTest_13113 {

    static int i = 5;

    static int a = 1680518949;

    static int b = 0;

    static boolean flag = false;

    static boolean test1_taken = false;

    int helper1(int i, int a, int b, boolean flag) {
        if (flag) {
            if (i <= a || i > b) {
                test1_taken = true;
            }
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13113().helper1(i, a, b, flag);
    }
}
