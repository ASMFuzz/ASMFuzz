public class MyJVMTest_2711 {

    static char[] a = { 'c', Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', 'C', Character.MIN_VALUE };

    static short[] b = { 32767, -736, 32767, -32768, 32767, 32767, 32767, 32767, 0, -20017 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    char[] test_ci_unaln(char[] a, short[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = (char) -123;
            b[i] = (short) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2711().test_ci_unaln(a, b);
    }
}
