public class MyJVMTest_11383 {

    static short[] a0 = { -32768, 10417, -32768, 32767, 32767, -32768, 32767, -2835, -32768, -32768 };

    static short[] a1 = { 0, 32767, 23222, 32767, 32767, 32767, 0, 4244, -32768, -30686 };

    static int ARRLEN = 1000;

    short[] test_lshift(short[] a0, short[] a1) {
        for (int i = 0; i < ARRLEN; i++) {
            a0[i] = (short) (a1[i] << 10);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11383().test_lshift(a0, a1);
    }
}
