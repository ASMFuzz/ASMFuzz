public class MyJVMTest_14454 {

    static char[] a = { Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '<', Character.MIN_VALUE, '!', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static short[] b = { -32768, 32767, 25025, 32767, 32767, 17261, 32767, -32768, 8602, 0 };

    static char c = '0';

    static short d = -32768;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    char[] test_vi_unaln(char[] a, short[] b, char c, short d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14454().test_vi_unaln(a, b, c, d);
    }
}
