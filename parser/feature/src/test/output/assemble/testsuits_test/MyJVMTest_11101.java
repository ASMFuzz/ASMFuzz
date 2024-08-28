public class MyJVMTest_11101 {

    static short[] a = { 0, -32768, 32767, -19087, 0, -3169, 0, -9969, 32767, 0 };

    static short[] b = { 32767, 0, 6415, -32768, 32767, 32767, -32768, -32768, 0, 0 };

    static short c = 32767;

    static short d = -10870;

    static int OFFSET = 3;

    short[] test_2vi_off(short[] a, short[] b, short c, short d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11101().test_2vi_off(a, b, c, d);
    }
}
