public class MyJVMTest_7289 {

    static byte[] a = { -116, 9, 121, -8, -43, 17, 5, 73, 44, -7 };

    static int[] b = { 0, -1718060772, 7, 3, 0, 8, -1479491015, 3, 7, 4 };

    static byte c = 127;

    static int d = 0;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_vi_unaln(byte[] a, int[] b, byte c, int d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7289().test_vi_unaln(a, b, c, d);
    }
}
