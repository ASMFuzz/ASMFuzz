public class MyJVMTest_5284 {

    static short[] a = { 32767, 0, 32767, -32768, 32767, 32767, 32767, 32767, 0, 32767 };

    static short[] b = { 32668, -23878, -32768, 0, -32156, 4683, -32768, 0, -32768, 32767 };

    static short c = -32768;

    static short d = 0;

    short[] test_2vi(short[] a, short[] b, short c, short d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5284().test_2vi(a, b, c, d);
    }
}
