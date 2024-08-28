public class MyJVMTest_9837 {

    static short[] a0 = { -9336, 32767, 0, -32768, 0, -32768, -32768, 0, -32768, 28494 };

    static short[] a1 = { -17615, -32768, -32768, 32767, 27444, 0, 32767, 32767, 0, 32767 };

    short[] test_lsai(short[] a0, short[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (short) (a1[i] << (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9837().test_lsai(a0, a1);
    }
}
