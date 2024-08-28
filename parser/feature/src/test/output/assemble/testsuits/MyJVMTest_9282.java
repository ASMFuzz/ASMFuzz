public class MyJVMTest_9282 {

    static byte[] a = { -9, 103, -77, -66, -127, 15, -124, -119, -110, 45 };

    static byte[] b = { -109, 33, 92, 26, 71, 101, -104, 112, 93, 63 };

    static int[] c = { 579241037, -747464022, 1238704372, 7, 377152619, 0, 1526273121, 716304475, 7, 2 };

    static int[] d = { 4, -1426482711, 9, 0, 0, 7, -491292588, 0, 0, 4 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alnsrc(byte[] a, byte[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9282().test_cp_alnsrc(a, b, c, d);
    }
}
