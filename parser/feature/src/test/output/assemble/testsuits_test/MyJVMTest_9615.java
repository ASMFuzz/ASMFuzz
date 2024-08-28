public class MyJVMTest_9615 {

    static char[] a = { '0', Character.MAX_VALUE, '0', Character.MIN_VALUE, 'I', '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static short[] b = { 32767, -32768, 32767, 32767, 28559, -32768, -32768, 32767, -10174, -26105 };

    static char c = 'J';

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
        new MyJVMTest_9615().test_vi_aln(a, b, c, d);
    }
}
