public class MyJVMTest_13653 {

    static short[] a = { -32768, 0, 5666, 32767, 32767, 0, 0, -32768, 0, 0 };

    static short b = 0;

    static int SCALE = 2;

    short[] test_vi_scl(short[] a, short b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13653().test_vi_scl(a, b);
    }
}
