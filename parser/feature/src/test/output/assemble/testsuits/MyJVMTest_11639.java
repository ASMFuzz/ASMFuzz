public class MyJVMTest_11639 {

    static short[] a0 = { -32768, 32767, -32768, -32768, 0, 15644, 32767, 0, 32767, 0 };

    static short[] a1 = { 0, 32767, -26400, 32767, -32768, 32767, 0, -28760, -18845, 32767 };

    short[] test_addi(short[] a0, short[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (short) (a1[i] + (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11639().test_addi(a0, a1);
    }
}
