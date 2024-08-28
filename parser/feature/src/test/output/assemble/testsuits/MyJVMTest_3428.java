public class MyJVMTest_3428 {

    static byte[] buffer = { -39, -64, 114, 119, 50, -67, 106, -107, -38, -65 };

    static int index = 6;

    byte getByte(byte[] buffer, int index) {
        return buffer[index];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3428().getByte(buffer, index));
    }
}
