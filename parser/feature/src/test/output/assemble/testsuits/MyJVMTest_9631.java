public class MyJVMTest_9631 {

    static byte[] bytes = { 88, 41, -63, 39, 57, -108, -84, -128, 48, -101 };

    byte[] dumpBytes(byte[] bytes) {
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b));
        }
        System.out.println();
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9631().dumpBytes(bytes);
    }
}
