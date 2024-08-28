public class MyJVMTest_455 {

    static char[] a = { Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, 'X', Character.MIN_VALUE };

    static short[] b = { 0, 32767, 0, 0, 17094, 32767, 0, 26314, 16422, -32768 };

    static char c = Character.MAX_VALUE;

    static short d = 32767;

    static int ALIGN_OFF = 8;

    char[] test_vi_aln(char[] a, short[] b, char c, short d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_455().test_vi_aln(a, b, c, d);
    }
}
