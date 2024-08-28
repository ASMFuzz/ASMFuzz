public class MyJVMTest_121 {

    static short[] a0 = { -32768, 32767, -32768, -27073, 7244, 0, 32767, 32767, 0, 32767 };

    static short[] a1 = { 0, 0, 0, -32768, 0, 32767, -3523, 0, 32767, 0 };

    short[] test_unrl_lsai(short[] a0, short[] a1) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = (short) (a1[i + 0] << 0);
            a0[i + 1] = (short) (a1[i + 1] << 1);
            a0[i + 2] = (short) (a1[i + 2] << 2);
            a0[i + 3] = (short) (a1[i + 3] << 3);
        }
        for (; i < a0.length; i++) {
            a0[i] = (short) (a1[i] << (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_121().test_unrl_lsai(a0, a1);
    }
}
