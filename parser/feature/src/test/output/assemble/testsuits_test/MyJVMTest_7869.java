public class MyJVMTest_7869 {

    static char[] a = { Character.MIN_VALUE, Character.MAX_VALUE, '0', '(', '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] b = { '0', 'k', '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', '0', '0', '0' };

    static short[] c = { 32767, 32767, -32768, -32267, -32768, 0, -32188, 32767, 21596, 32767 };

    static short[] d = { 22187, 27215, 0, -32768, 0, 32767, 3617, 0, 3658, 32767 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    char[] test_cp_unalnsrc(char[] a, char[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7869().test_cp_unalnsrc(a, b, c, d);
    }
}
