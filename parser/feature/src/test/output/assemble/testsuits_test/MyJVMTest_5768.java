public class MyJVMTest_5768 {

    static char[] a0 = { Character.MAX_VALUE, 'p', Character.MAX_VALUE, 'Q', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'n', '0', 'q' };

    static char[] a1 = { Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE };

    static int b = 6;

    char[] test_divv(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] / b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5768().test_divv(a0, a1, b);
    }
}
