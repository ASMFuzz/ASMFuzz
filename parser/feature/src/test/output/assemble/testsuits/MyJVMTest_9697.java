public class MyJVMTest_9697 {

    static byte[] a = { -28, 122, 65, 57, 99, 102, 126, 62, 100, -42 };

    static short[] b = { -32768, 32767, 32767, 32767, 32767, 32767, 32767, 32767, 7522, 0 };

    static byte c = 0;

    static short d = -32768;

    static int ALIGN_OFF = 8;

    byte[] test_vi_aln(byte[] a, short[] b, byte c, short d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9697().test_vi_aln(a, b, c, d);
    }
}
