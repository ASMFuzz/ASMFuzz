public class MyJVMTest_1872 {

    static short[] a = { 32767, -32768, 32767, -23360, 0, 0, 0, -32768, -32768, 27583 };

    static short[] b = { 32767, -32768, -32768, 0, 0, 2621, 32767, -32768, -32768, -32768 };

    static short c = 288;

    static short d = 32767;

    static int OFFSET = 3;

    short[] test_2vi_off(short[] a, short[] b, short c, short d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1872().test_2vi_off(a, b, c, d);
    }
}
