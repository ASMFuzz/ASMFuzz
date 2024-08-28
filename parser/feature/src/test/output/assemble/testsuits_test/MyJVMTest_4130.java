public class MyJVMTest_4130 {

    static short[] a = { -32768, 32767, 0, -32768, 22888, 32767, -10223, -32768, 0, -27860 };

    static short b = 32767;

    short[] test_vi(short[] a, short b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4130().test_vi(a, b);
    }
}
