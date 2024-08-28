public class MyJVMTest_17108 {

    static short[] a = { -22389, -32768, 32767, -32768, 32767, -4953, -27693, 32767, 0, 26372 };

    static short[] b = { 17623, 0, 32767, 5061, -11830, 20031, 32767, -4371, 0, -14849 };

    static short c = 32767;

    static short d = -11056;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_2vi_unaln(short[] a, short[] b, short c, short d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17108().test_2vi_unaln(a, b, c, d);
    }
}
