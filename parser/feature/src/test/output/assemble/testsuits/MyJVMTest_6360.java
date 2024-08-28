public class MyJVMTest_6360 {

    static String label = ">7fN[31$Tx";

    static byte[] bytes = { -125, -8, 127, -37, -86, -32, 70, -17, -95, -27 };

    byte[] displayBytes(String label, byte[] bytes) {
        System.out.println(label + " [length=" + bytes.length + "]");
        for (byte b : bytes) {
            System.out.print("0x" + Integer.toHexString(b & 0xFF) + " ");
        }
        System.out.println();
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6360().displayBytes(label, bytes);
    }
}
