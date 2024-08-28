public class MyJVMTest_17554 {

    static short[] a = { 32767, 0, 0, 0, 32767, 32767, 15641, 0, -32768, 32767 };

    static short[] b = { 0, 0, 0, 32767, 0, 0, -32768, 0, -32768, -1733 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_2ci_unaln(short[] a, short[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17554().test_2ci_unaln(a, b);
    }
}
