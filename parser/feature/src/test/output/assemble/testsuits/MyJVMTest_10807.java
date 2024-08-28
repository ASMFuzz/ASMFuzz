public class MyJVMTest_10807 {

    static short[] a0 = { -20825, 32767, 32767, 32767, -32768, 32767, 0, 0, -32768, 32767 };

    static short[] a1 = { 32767, 0, -32768, -31180, 0, -32768, 0, 0, 32767, -26237 };

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
        new MyJVMTest_10807().verify_urshift(a0, a1);
    }
}
