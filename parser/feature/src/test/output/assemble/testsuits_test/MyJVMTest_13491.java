public class MyJVMTest_13491 {

    static short[] a = { -32768, -32768, 0, -32768, 32767, 32767, -32768, 5211, 32767, -32768 };

    static short b = 0;

    short[] test_vi(short[] a, short b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13491().test_vi(a, b);
    }
}
