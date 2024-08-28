public class MyJVMTest_15235 {

    static short[] a = { -32768, -32768, -32768, 32767, 0, -32768, -32768, -32768, -11034, -32420 };

    static short[] b = { 17636, 13530, 32767, -32768, 32767, 0, -13600, -27337, 32767, 32767 };

    static short c = 21537;

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
        new MyJVMTest_15235().test_2vi_scl(a, b, c, d);
    }
}
