public class MyJVMTest_2313 {

    static char[] a0 = { '&', '0', Character.MIN_VALUE, Character.MAX_VALUE, 'V', '0', 'j', Character.MAX_VALUE, '.', 'B' };

    static char[] a1 = { 'G', '&', Character.MIN_VALUE, ':', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '+', '0' };

    static int VALUE = 7;

    char[] test_sllc(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] << VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2313().test_sllc(a0, a1);
    }
}
