public class MyJVMTest_818 {

    static byte[] buff = { -38, 107, -119, -97, -60, -48, -62, 104, -128, -36 };

    static byte[] f = { -59, 82, -66, -5, -94, -65, 10, -5, -60, 121 };

    static byte[] t = { 56, -113, 72, -75, -38, -105, 87, 34, -106, -29 };

    static int i = 6;

    boolean replace(byte[] buff, byte[] f, byte[] t, int i) {
        for (int x = 0; x < f.length; x++) {
            if (buff[x + i] != f[x]) {
                return false;
            }
        }
        for (int x = 0; x < f.length; x++) {
            buff[x + i] = t[x];
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_818().replace(buff, f, t, i));
    }
}
