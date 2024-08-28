public class MyJVMTest_12472 {

    static int i = -991490878;

    static int a = 6;

    static int b = 3;

    static boolean flag = false;

    static boolean test3_taken = true;

    int helper3(int i, int a, int b, boolean flag) {
        if (flag) {
            if (i < a || i > b - 1) {
                test3_taken = true;
            }
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12472().helper3(i, a, b, flag);
    }
}
