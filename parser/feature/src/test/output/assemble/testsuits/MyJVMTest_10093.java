public class MyJVMTest_10093 {

    static short[] a = { -32768, -32768, 0, 32767, 32767, -32768, -32768, 0, -32768, 32767 };

    static short[] b = { 0, 2773, 0, -32768, 0, 19657, -32768, -32768, 0, -32768 };

    static int[] c = { 1, 8, 1360386504, 1245844831, 0, 0, 9, 0, -1377881868, -1354242765 };

    static int[] d = { 5, 0, 0, 1370094733, -507696700, 7, 2, 1, 4, 2009583858 };

    static int ALIGN_OFF = 8;

    short[] test_cp_alnsrc(short[] a, short[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10093().test_cp_alnsrc(a, b, c, d);
    }
}
