public class MyJVMTest_12348 {

    static byte[] b1 = { -75, -28, 119, 16, 3, 118, -127, 9, -35, -4 };

    static byte[] b2 = { 79, 6, -110, -127, -103, 16, 13, 64, 18, 18 };

    boolean equalsBlock(byte[] b1, byte[] b2) {
        if (b1.length != b2.length) {
            return false;
        }
        for (int i = 0; i < b1.length; i++) {
            if (b1[i] != b2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12348().equalsBlock(b1, b2));
    }
}
