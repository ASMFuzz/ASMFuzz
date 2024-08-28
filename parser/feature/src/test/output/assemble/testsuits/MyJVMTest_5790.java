public class MyJVMTest_5790 {

    static short[] a = { 32767, -28068, 32767, 0, 32767, -32768, -15844, 0, -32768, 32767 };

    static short[] b = { 32767, 8846, 26755, 0, 32767, -32768, 27413, 32767, 0, 32767 };

    static short c = -32768;

    static short d = 0;

    static int SCALE = 2;

    short[] test_2vi_scl(short[] a, short[] b, short c, short d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5790().test_2vi_scl(a, b, c, d);
    }
}
