public class MyJVMTest_615 {

    static char[] a0 = { '0', 'T', Character.MIN_VALUE, Character.MIN_VALUE, '0', 'o', 'z', Character.MIN_VALUE, 'H', '0' };

    static char[] a1 = { '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, 't', Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE, '/' };

    static int VALUE = 7;

    char[] test_srlc_n(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >>> (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_615().test_srlc_n(a0, a1);
    }
}
