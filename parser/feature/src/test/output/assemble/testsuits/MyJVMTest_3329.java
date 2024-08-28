public class MyJVMTest_3329 {

    static short[] a = { -18964, 0, -32768, -32768, 13031, 0, -32768, 0, 0, 32767 };

    static long[] b = { 0, -9223372036854775808L, 4095242798733002262L, -9223372036854775808L, 9223372036854775807L, 527804810596694359L, 0, -1447287303734206536L, 1434587416940359325L, 9223372036854775807L };

    static short c = 32767;

    static long d = 9223372036854775807L;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_vi_unaln(short[] a, long[] b, short c, long d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3329().test_vi_unaln(a, b, c, d);
    }
}
