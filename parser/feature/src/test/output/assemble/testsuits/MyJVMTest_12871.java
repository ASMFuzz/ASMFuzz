public class MyJVMTest_12871 {

    static short[] a0 = { 0, -32768, 32767, 0, 0, -32768, -32768, -32768, 0, 3934 };

    static short[] a1 = { -32768, -25560, 0, 5034, 32767, 32767, -32768, -32768, 0, 0 };

    static int ARRLEN = 1000;

    short[] test_init(short[] a0, short[] a1) {
        for (int i = 0; i < ARRLEN; i++) {
            a0[i] = (short) (i & 3);
            a1[i] = (short) i;
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12871().test_init(a0, a1);
    }
}
