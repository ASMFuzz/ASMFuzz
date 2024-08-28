public class MyJVMTest_7998 {

    static short[] a = { 30389, 3713, 32767, -32768, 32767, -15506, -23756, -32768, 0, -32768 };

    static short[] b = { -32768, 32767, 0, 0, -32768, 32767, 6751, -32768, -32768, -32768 };

    static short c = 7999;

    static short d = 0;

    static int ALIGN_OFF = 8;

    short[] test_2vi_aln(short[] a, short[] b, short c, short d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7998().test_2vi_aln(a, b, c, d);
    }
}
