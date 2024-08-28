public class MyJVMTest_14143 {

    static short[] a0 = { 32767, 11520, 0, -32768, 0, -21057, 32767, -15799, 0, 26299 };

    short[] test_init(short[] a0) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (short) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14143().test_init(a0);
    }
}
