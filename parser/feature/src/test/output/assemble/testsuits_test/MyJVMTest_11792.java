public class MyJVMTest_11792 {

    static char[] a0 = { '0', 'X', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, '[', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE };

    static char[] a1 = { '0', Character.MAX_VALUE, '|', 'U', '0', 'a', 'Q', Character.MIN_VALUE, '1', Character.MAX_VALUE };

    static int VALUE = 7;

    char[] test_sllc_n(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] << (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11792().test_sllc_n(a0, a1);
    }
}
