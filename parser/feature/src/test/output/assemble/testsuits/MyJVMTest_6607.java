public class MyJVMTest_6607 {

    static char[] a0 = { Character.MAX_VALUE, 'T', '\\', '0', 'G', '%', '0', '0', '0', '>' };

    static char[] a1 = { '0', 'l', Character.MAX_VALUE, '$', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE };

    static int VALUE = 7;

    char[] test_divc_n(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] / (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6607().test_divc_n(a0, a1);
    }
}
