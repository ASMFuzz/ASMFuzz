public class MyJVMTest_5043 {

    static char[] a = { '|', Character.MIN_VALUE, Character.MAX_VALUE, 's', Character.MAX_VALUE, '0', '$', 'd', Character.MAX_VALUE, Character.MIN_VALUE };

    static short[] b = { 3375, 26948, 18840, 0, 32767, 19423, 32767, 0, 32767, 32767 };

    static char c = Character.MIN_VALUE;

    static short d = 0;

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
        new MyJVMTest_5043().test_vi_unaln(a, b, c, d);
    }
}
