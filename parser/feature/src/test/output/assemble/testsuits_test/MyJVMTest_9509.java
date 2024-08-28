public class MyJVMTest_9509 {

    static byte[] a = { 23, -116, -55, -104, 115, -54, -37, -111, 32, 23 };

    static byte[] b = { -13, 123, -34, -40, -16, -127, -46, 6, -121, 22 };

    static short[] c = { 32767, 24547, 32767, 29855, 32767, -23578, 32767, 0, 0, 0 };

    static short[] d = { 32767, -32768, 0, -26822, -9740, 32767, -32768, 0, 32767, -32768 };

    byte[] test_cp(byte[] a, byte[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9509().test_cp(a, b, c, d);
    }
}
