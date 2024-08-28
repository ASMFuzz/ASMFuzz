public class MyJVMTest_9997 {

    static byte[] buff = { -109, -90, -78, -99, 20, 81, -115, -2, 111, -127 };

    static byte[] f = { 90, 104, 46, -96, -111, -108, -36, -94, 73, -20 };

    static byte[] t = { 29, 48, -66, -44, -1, 99, 16, 13, -93, 4 };

    static int i = 4;

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
        System.out.println(new MyJVMTest_9997().replace(buff, f, t, i));
    }
}
