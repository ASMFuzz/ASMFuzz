public class MyJVMTest_3042 {

    static byte[] b1 = { 60, -71, -65, -3, -34, -109, 18, 109, -11, -5 };

    static byte[] b2 = { 50, 102, 44, -34, 16, -34, 57, -127, 90, -90 };

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
        System.out.println(new MyJVMTest_3042().equalsBlock(b1, b2));
    }
}
