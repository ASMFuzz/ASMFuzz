public class MyJVMTest_5496 {

    static byte[] b = { -128, 124, 24, 120, -39, -76, 45, 26, -124, -116 };

    static String name = "(~a(?}fiM%";

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
        new MyJVMTest_5496().showArray(b, name);
    }
}
