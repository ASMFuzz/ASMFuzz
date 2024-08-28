public class MyJVMTest_6982 {

    static char[] a0 = { 'E', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '/', Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] a1 = { '0', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 's', Character.MAX_VALUE, Character.MIN_VALUE, '0', '0' };

    static int BIT_MASK = 0xB731;

    char[] test_xorc(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] ^ BIT_MASK);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6982().test_xorc(a0, a1);
    }
}
