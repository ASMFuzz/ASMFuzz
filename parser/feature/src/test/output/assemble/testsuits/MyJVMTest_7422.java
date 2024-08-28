public class MyJVMTest_7422 {

    static short[] a = { 32767, -32768, 0, 32767, 23685, -9006, -32768, 0, 32767, -32768 };

    static short[] b = { -32768, -32768, 0, 0, 0, -32768, 32767, 0, -13098, 32767 };

    static int ALIGN_OFF = 8;

    short[] test_cp_alnsrc(short[] a, short[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7422().test_cp_alnsrc(a, b);
    }
}
