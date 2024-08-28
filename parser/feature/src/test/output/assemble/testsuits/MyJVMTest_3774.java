public class MyJVMTest_3774 {

    static int i = 5;

    static int a = 8;

    static int b = 7;

    static boolean flag = true;

    static boolean test1_taken = true;

    int helper1(int i, int a, int b, boolean flag) {
        if (flag) {
            if (i <= a || i > b) {
                test1_taken = true;
            }
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3774().helper1(i, a, b, flag);
    }
}
