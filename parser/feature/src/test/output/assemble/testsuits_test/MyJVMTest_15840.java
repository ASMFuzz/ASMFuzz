public class MyJVMTest_15840 {

    static String label = "JNShQ)jVry";

    static byte[] bytes = { -19, 86, 99, 66, -88, -67, 16, -94, 114, -14 };

    byte[] displayBytes(String label, byte[] bytes) {
        System.out.println(label + " [length=" + bytes.length + "]");
        for (byte b : bytes) {
            System.out.print("0x" + Integer.toHexString(b & 0xFF) + " ");
        }
        System.out.println();
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15840().displayBytes(label, bytes);
    }
}
