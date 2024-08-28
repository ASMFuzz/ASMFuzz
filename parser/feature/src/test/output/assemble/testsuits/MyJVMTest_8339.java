public class MyJVMTest_8339 {

    static char[] a0 = { 'q', 'l', '?', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', '|', '0' };

    static char[] a1 = { '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, 'R', Character.MAX_VALUE, '=', '0', Character.MAX_VALUE };

    static int VALUE = 7;

    char[] test_srac(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8339().test_srac(a0, a1);
    }
}
