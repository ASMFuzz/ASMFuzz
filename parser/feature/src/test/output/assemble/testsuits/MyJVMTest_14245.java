public class MyJVMTest_14245 {

    static short[] a0 = { -5807, 0, -32768, 32767, -32768, 15491, 0, 0, 0, -32768 };

    static short[] a1 = { 4185, 0, -32768, 32767, -32768, 0, 31193, 32767, 32767, -11781 };

    static int ARRLEN = 1000;

    short[] verify_lshift(short[] a0, short[] a1) {
        for (int i = 0; i < ARRLEN; i++) {
            if (a0[i] != (short) (a1[i] << 10)) {
                throw new RuntimeException("LShift test failed.");
            }
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14245().verify_lshift(a0, a1);
    }
}
