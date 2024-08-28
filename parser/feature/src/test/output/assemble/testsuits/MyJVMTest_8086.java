public class MyJVMTest_8086 {

    static short[] a0 = { -32768, 0, -32149, -9923, 0, 20042, 0, 7471, 0, 31658 };

    static short[] a1 = { -32768, 32767, 32767, 27552, 32767, -26904, 32767, 0, -16504, 0 };

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
        new MyJVMTest_8086().test_unrl_addi(a0, a1);
    }
}
