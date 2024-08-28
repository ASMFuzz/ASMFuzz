public class MyJVMTest_4283 {

    static short[] a = { 32767, 32767, -28255, 0, 32767, 0, -32768, -24824, -32768, 0 };

    static short b = 32767;

    static int SCALE = 2;

    short[] test_vi_scl(short[] a, short b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4283().test_vi_scl(a, b);
    }
}
