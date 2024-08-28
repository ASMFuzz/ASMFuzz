public class MyJVMTest_666 {

    static short[] a0 = { 32767, -32768, -32768, -32768, 0, 0, 4631, 32767, -32768, -32768 };

    static short[] a1 = { 0, 0, 32767, 0, -32768, 32767, 10557, 0, 24102, 0 };

    short[] test_lsai(short[] a0, short[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (short) (a1[i] << (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_666().test_lsai(a0, a1);
    }
}
