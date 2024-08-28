public class MyJVMTest_17069 {

    static short[] a = { 32767, 0, 32767, 32767, -4517, 32767, 32767, -32768, 32767, -6631 };

    static short[] b = { 32767, 24551, -32768, -32768, -32768, 0, -32768, -5940, 0, -32768 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalndst(short[] a, short[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17069().test_cp_unalndst(a, b);
    }
}
