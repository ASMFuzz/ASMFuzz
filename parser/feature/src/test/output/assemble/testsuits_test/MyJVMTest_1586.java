public class MyJVMTest_1586 {

    static short[] a0 = { -32768, -32768, 0, 32767, 32767, 0, -32768, -32768, 0, 27626 };

    static short[] a1 = { 32767, -32768, 0, 14598, 32767, -5629, 32767, 0, 0, -19558 };

    static int ARRLEN = 1000;

    short[] verify_urshift(short[] a0, short[] a1) {
        for (int i = 0; i < ARRLEN; i++) {
            if (a0[i] != (short) (a1[i] >>> 10)) {
                throw new RuntimeException("URshift test failed.");
            }
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1586().verify_urshift(a0, a1);
    }
}
