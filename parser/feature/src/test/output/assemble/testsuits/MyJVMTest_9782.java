public class MyJVMTest_9782 {

    static char[] a0 = { '0', Character.MIN_VALUE, Character.MAX_VALUE, '+', 'h', '0', '0', Character.MIN_VALUE, '[', Character.MAX_VALUE };

    static char[] a1 = { '2', ':', '0', '\'', Character.MIN_VALUE, 'K', '0', '0', 'x', '0' };

    static int VALUE = 7;

    char[] test_srlc_n(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >>> (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9782().test_srlc_n(a0, a1);
    }
}
