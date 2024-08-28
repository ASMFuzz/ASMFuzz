public class MyJVMTest_17162 {

    static byte[] b1 = { 81, 80, -81, -59, 35, 127, 120, -8, -16, 83 };

    static byte[] b2 = { 91, -115, -113, -10, 8, 10, 32, 54, -52, 64 };

    static int len = 0;

    boolean equalsBlock(byte[] b1, byte[] b2, int len) {
        for (int i = 0; i < len; i++) {
            if (b1[i] != b2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17162().equalsBlock(b1, b2, len));
    }
}
