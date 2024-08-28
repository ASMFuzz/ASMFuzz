public class MyJVMTest_7611 {

    static short[] a = { -32768, -32768, 4045, -32768, 32767, 0, -32768, 17342, 7997, -26629 };

    static long[] b = { 6791075212240800636L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 0, 1280584076547546966L, 0, -9223372036854775808L, -9223372036854775808L };

    static short c = 32767;

    static long d = 1852365627152610073L;

    static int ALIGN_OFF = 8;

    short[] test_vi_aln(short[] a, long[] b, short c, long d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7611().test_vi_aln(a, b, c, d);
    }
}
