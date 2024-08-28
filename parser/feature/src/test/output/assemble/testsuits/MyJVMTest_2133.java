public class MyJVMTest_2133 {

    static short[] a0 = { -32768, -32768, -32768, 32767, 0, 0, 32767, -9731, 17633, -32768 };

    static short[] a1 = { 32767, 11788, 25633, 0, 17466, -32768, -32768, 459, 0, 32767 };

    static int ARRLEN = 1000;

    short[] test_lshift(short[] a0, short[] a1) {
        for (int i = 0; i < ARRLEN; i++) {
            a0[i] = (short) (a1[i] << 10);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2133().test_lshift(a0, a1);
    }
}
