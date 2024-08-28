public class MyJVMTest_3156 {

    static int i = 6;

    static int a = 1425858248;

    static int b = 0;

    static boolean flag = true;

    static boolean test3_taken = false;

    int helper3(int i, int a, int b, boolean flag) {
        if (flag) {
            if (i < a || i > b - 1) {
                test3_taken = true;
            }
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3156().helper3(i, a, b, flag);
    }
}
