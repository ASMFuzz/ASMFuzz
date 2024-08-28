public class MyJVMTest_14174 {

    static short[] a0 = { 22462, 32767, 17036, 32767, 0, 0, 0, 32767, -14608, 9185 };

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
        new MyJVMTest_14174().test_unrl_init(a0);
    }
}
