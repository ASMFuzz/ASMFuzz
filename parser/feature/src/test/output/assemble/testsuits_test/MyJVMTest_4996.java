public class MyJVMTest_4996 {

    static byte[] b1 = { 119, 45, 81, 20, -99, -14, 113, -12, 116, -115 };

    static byte[] b2 = { 92, -8, -37, 14, -27, 95, 48, 83, -6, -100 };

    static int len = -530515807;

    boolean equalsBlock(byte[] b1, byte[] b2, int len) {
        for (int i = 0; i < len; i++) {
            if (b1[i] != b2[i]) {
                System.err.println("b1[" + i + "] : " + b1[i] + " b2[" + i + "] : " + b2[i]);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4996().equalsBlock(b1, b2, len));
    }
}
