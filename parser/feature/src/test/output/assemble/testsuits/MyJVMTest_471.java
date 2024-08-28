public class MyJVMTest_471 {

    static byte[] bytes = { 20, 24, 120, 123, 11, 88, -97, 8, 31, -115 };

    byte[] dumpBytes(byte[] bytes) {
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b));
        }
        System.out.println();
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_471().dumpBytes(bytes);
    }
}
