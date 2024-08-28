public class MyJVMTest_6803 {

    static short[] a = { -32768, 0, 32767, 32767, 0, 0, -32768, 32767, 32767, -32768 };

    static short b = 0;

    static int OFFSET = 3;

    short[] test_vi_off(short[] a, short b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6803().test_vi_off(a, b);
    }
}
