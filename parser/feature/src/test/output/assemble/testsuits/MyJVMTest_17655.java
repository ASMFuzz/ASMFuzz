public class MyJVMTest_17655 {

    static short[] a0 = { 2204, 0, 0, 0, -8767, 30589, -32166, -32768, -6769, 0 };

    static short[] a1 = { 10614, 32767, 20224, 26542, -32768, -23253, -32768, 32767, 32767, -32768 };

    short[] test_unrl_addi(short[] a0, short[] a1) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = (short) (a1[i + 0] + 0);
            a0[i + 1] = (short) (a1[i + 1] + 1);
            a0[i + 2] = (short) (a1[i + 2] + 2);
            a0[i + 3] = (short) (a1[i + 3] + 3);
        }
        for (; i < a0.length; i++) {
            a0[i] = (short) (a1[i] + (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17655().test_unrl_addi(a0, a1);
    }
}
