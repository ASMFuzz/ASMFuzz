public class MyJVMTest_7616 {

    static byte[] b1 = { -6, 121, -99, -127, -94, 121, -122, 4, -52, 103 };

    static byte[] b2 = { -95, -91, 11, -31, -43, -49, 121, 26, -79, -100 };

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
        System.out.println(new MyJVMTest_7616().equalsBlock(b1, b2, len));
    }
}
