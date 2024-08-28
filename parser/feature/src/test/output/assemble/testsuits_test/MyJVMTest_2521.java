public class MyJVMTest_2521 {

    static char[] a0 = { 'b', '0', 'k', 'b', Character.MAX_VALUE, '0', '0', Character.MAX_VALUE, Character.MAX_VALUE, '0' };

    static char[] a1 = { Character.MIN_VALUE, Character.MIN_VALUE, '?', '0', '0', '0', '0', '0', 'k', Character.MAX_VALUE };

    static int VALUE = 7;

    char[] test_sllc_n(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] << (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2521().test_sllc_n(a0, a1);
    }
}
