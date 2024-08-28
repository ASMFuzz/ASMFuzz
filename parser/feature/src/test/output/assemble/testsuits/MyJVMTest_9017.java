public class MyJVMTest_9017 {

    static byte[] bytes = { -6, 63, 99, -105, -124, -75, 111, 63, -81, -118 };

    byte[] dumpBytes(byte[] bytes) {
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b));
        }
        System.out.println();
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9017().dumpBytes(bytes);
    }
}
