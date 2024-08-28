public class MyJVMTest_7293 {

    static char[] a0 = { '0', Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'X', Character.MIN_VALUE };

    static char[] a1 = { 'D', Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MIN_VALUE, '0' };

    static int VALUE = 7;

    char[] test_mulc_n(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] * (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7293().test_mulc_n(a0, a1);
    }
}
