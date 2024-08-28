public class MyJVMTest_2570 {

    static char[] a0 = { 'B', 'G', '0', '0', '0', '0', '6', Character.MIN_VALUE, '0', '7' };

    static char[] a1 = { 'Y', '0', Character.MAX_VALUE, '\'', '-', '0', '8', 'v', Character.MIN_VALUE, Character.MAX_VALUE };

    static int SHIFT = 16;

    char[] test_sllc_o(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] << SHIFT);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2570().test_sllc_o(a0, a1);
    }
}
