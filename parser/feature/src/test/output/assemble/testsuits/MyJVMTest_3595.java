public class MyJVMTest_3595 {

    static byte[] a = { 49, 61, 95, 97, -15, 22, 61, 105, 65, 56 };

    static int[] b = { 0, 7, 2000978839, 1687877340, 6, -1764811796, 4, 1161728593, 0, 879075326 };

    static byte c = -128;

    static int d = 6;

    byte[] test_vi(byte[] a, int[] b, byte c, int d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3595().test_vi(a, b, c, d);
    }
}
