public class MyJVMTest_945 {

    static int[] a0 = { 8, -687641409, 9, 0, 6, 0, 0, -1453336764, 1, 0 };

    static int[] a1 = { 5, 2, 0, 3, 988900360, 0, 1, 5, 0, 1542004976 };

    static int b = 3;

    int[] test_addv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] + b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_945().test_addv(a0, a1, b);
    }
}
