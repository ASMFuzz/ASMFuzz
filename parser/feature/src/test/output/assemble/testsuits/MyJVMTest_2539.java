public class MyJVMTest_2539 {

    static char[] a0 = { '0', Character.MIN_VALUE, '3', '0', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', '0' };

    static char[] a1 = { 'D', '0', Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, 'I', Character.MIN_VALUE, '6', Character.MIN_VALUE };

    static int SHIFT = 16;

    char[] test_sllc_on(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] << (-SHIFT));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2539().test_sllc_on(a0, a1);
    }
}
