public class MyJVMTest_4845 {

    static short[] a0 = { 32767, 32767, 12694, 32767, 0, 13584, 0, 32767, 32767, 0 };

    static short[] a1 = { 0, -7319, 15838, -30472, -32768, 8542, 19437, 32767, -32768, -32768 };

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
        new MyJVMTest_4845().verify_lshift(a0, a1);
    }
}
