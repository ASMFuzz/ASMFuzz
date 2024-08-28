public class MyJVMTest_11931 {

    static byte[] buffer = { 16, -88, 54, -116, -50, 62, -82, -58, -1, -65 };

    static int index = 0;

    static byte value = 40;

    byte putByte(byte[] buffer, int index, byte value) {
        buffer[index] = value;
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11931().putByte(buffer, index, value);
    }
}
