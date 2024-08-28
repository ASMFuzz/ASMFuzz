public class MyJVMTest_1469 {

    static char[] a0 = { 'j', Character.MIN_VALUE, Character.MIN_VALUE, 'i', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '1', Character.MAX_VALUE, '0' };

    static char[] a1 = { '\\', Character.MIN_VALUE, Character.MAX_VALUE, '#', '0', '0', '0', '1', Character.MAX_VALUE, 'B' };

    static short[] a2 = { -32768, 32767, 0, -10262, 0, 22207, -32768, -7337, -32768, -13657 };

    char[] test_xora(char[] a0, char[] a1, short[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] ^ a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1469().test_xora(a0, a1, a2);
    }
}
