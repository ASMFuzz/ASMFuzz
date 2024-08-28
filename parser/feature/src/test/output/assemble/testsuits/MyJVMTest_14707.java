public class MyJVMTest_14707 {

    static short[] a = { 0, -25489, -32768, 18555, -32768, 32767, 0, -3774, 32767, -25840 };

    static short[] b = { -32768, 0, 0, -32768, -11089, -32768, 0, -971, 32767, 0 };

    static short c = -32768;

    static short d = -1111;

    short[] test_2vi(short[] a, short[] b, short c, short d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14707().test_2vi(a, b, c, d);
    }
}
