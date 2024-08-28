public class MyJVMTest_16854 {

    static char[] a0 = { '\\', 'z', Character.MIN_VALUE, '2', '0', Character.MAX_VALUE, 'l', '0', '0', Character.MAX_VALUE };

    static char[] a1 = { '0', '0', Character.MIN_VALUE, 'M', '0', '0', 'q', '0', '%', Character.MAX_VALUE };

    static int SHIFT = 16;

    char[] test_srac_on(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >> (-SHIFT));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16854().test_srac_on(a0, a1);
    }
}
