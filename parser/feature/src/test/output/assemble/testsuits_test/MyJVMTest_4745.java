public class MyJVMTest_4745 {

    static short[] a0 = { -32768, -32768, 0, 8069, 0, 32767, -5026, 32767, 20012, 32767 };

    short[] test_init(short[] a0) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (short) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4745().test_init(a0);
    }
}
