public class MyJVMTest_16954 {

    static short[] a = { -32768, 0, 0, 32767, -7274, 0, -32768, 21811, 0, -32768 };

    static short[] b = { 0, -32768, -32768, 14368, 0, -32768, -32768, 32767, 0, 27322 };

    static int ALIGN_OFF = 8;

    short[] test_cp_alnsrc(short[] a, short[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16954().test_cp_alnsrc(a, b);
    }
}
