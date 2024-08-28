public class MyJVMTest_9324 {

    static int[] a0 = { 0, 2, -2072775617, 4, 3, -1198007314, 4, 4, 0, 0 };

    static int[] a1 = { -4087698, 0, 1924373575, 0, -184708129, 8, 7, 8, 8, 5 };

    static int[] a2 = { 3, 1602429743, 1, -747642217, 5, 2, 1740481598, 0, -914251432, 5 };

    int[] test_ora(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] | a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9324().test_ora(a0, a1, a2);
    }
}
