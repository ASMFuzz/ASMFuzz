public class MyJVMTest_15211 {

    static char[] a0 = { Character.MIN_VALUE, Character.MIN_VALUE, '0', '0', 'b', 'V', '#', '0', Character.MAX_VALUE, '0' };

    static char[] a1 = { '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, 'M', Character.MIN_VALUE, '&', Character.MAX_VALUE };

    static int b = 2;

    char[] test_divv(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] / b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15211().test_divv(a0, a1, b);
    }
}
