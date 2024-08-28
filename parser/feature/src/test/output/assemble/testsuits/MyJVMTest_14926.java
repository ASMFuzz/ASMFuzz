public class MyJVMTest_14926 {

    static byte[] b = { 76, 119, 13, -50, 77, -93, 32, -46, 85, 102 };

    static String name = "/[9o^9!N[g";

    static int HASH_LEN = 64;

    byte[] showArray(byte[] b, String name) {
        System.out.format("%s [%d]: ", name, b.length);
        for (int i = 0; i < Math.min(b.length, HASH_LEN); i++) {
            System.out.format("%02x ", b[i] & 0xff);
        }
        System.out.println();
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14926().showArray(b, name);
    }
}
