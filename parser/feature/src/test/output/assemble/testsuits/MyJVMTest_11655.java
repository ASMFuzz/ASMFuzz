public class MyJVMTest_11655 {

    static byte[] data = { 121, -10, 92, -45, -84, -124, 20, 90, 25, -87 };

    static int pos = 0;

    static int value = 3;

    int writeU32(byte[] data, int pos, int value) {
        data[pos] = (byte) (value & 0xff);
        data[pos + 1] = (byte) ((value >> 8) & 0xff);
        data[pos + 2] = (byte) ((value >> 16) & 0xff);
        data[pos + 3] = (byte) ((value >> 24) & 0xff);
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11655().writeU32(data, pos, value);
    }
}
