public class MyJVMTest_2649 {

    static byte[] buffer = { 107, -67, -6, -56, 67, -41, -98, -19, 51, 81 };

    static int index = 4;

    static byte value = 0;

    byte putByte(byte[] buffer, int index, byte value) {
        buffer[index] = value;
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2649().putByte(buffer, index, value);
    }
}
