public class MyJVMTest_14403 {

    static byte[] b1 = { 38, 13, 50, -104, 55, -11, -107, 107, 39, -4 };

    static byte[] b2 = { 83, -39, 90, -59, 43, -74, 56, -52, -26, 56 };

    static int len = -1740326746;

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
        System.out.println(new MyJVMTest_14403().equalsBlock(b1, b2, len));
    }
}
