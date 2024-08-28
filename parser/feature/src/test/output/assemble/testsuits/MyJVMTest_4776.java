public class MyJVMTest_4776 {

    static short[] a0 = { -22000, 0, 0, 0, -32768, -32768, -31993, 0, -17511, 0 };

    short[] test_unrl_init(short[] a0) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = 0;
            a0[i + 1] = 1;
            a0[i + 2] = 2;
            a0[i + 3] = 3;
        }
        for (; i < a0.length; i++) {
            a0[i] = (short) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4776().test_unrl_init(a0);
    }
}
