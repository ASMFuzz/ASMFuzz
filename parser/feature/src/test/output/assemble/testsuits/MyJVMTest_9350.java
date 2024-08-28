public class MyJVMTest_9350 {

    static short[] a = { 32767, -22818, -1787, -14416, 0, 0, -31080, 32767, 0, 0 };

    static short[] b = { 32767, 32767, 32767, 0, -16021, -32768, -32768, -1912, -32768, -32768 };

    static int ALIGN_OFF = 8;

    short[] test_2ci_aln(short[] a, short[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9350().test_2ci_aln(a, b);
    }
}
