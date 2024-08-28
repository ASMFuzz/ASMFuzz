public class MyJVMTest_3751 {

    static char[] a0 = { '0', '0', 'M', Character.MIN_VALUE, 'n', Character.MIN_VALUE, 'G', Character.MAX_VALUE, 'y', Character.MAX_VALUE };

    static char[] a1 = { '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, 'h', Character.MIN_VALUE, '0' };

    static short[] a2 = { 32767, 3904, 0, 27876, 32767, 0, 0, 0, -26644, -23999 };

    char[] test_anda(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] & a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3751().test_anda(a0, a1, a2);
    }
}
