public class MyJVMTest_2391 {

    static byte[] data = { 16, -109, -68, -109, -57, -7, 70, 76, 119, -89 };

    static int pos = 1;

    static int value = 2027067436;

    int writeU32(byte[] data, int pos, int value) {
        data[pos] = (byte) (value & 0xff);
        data[pos + 1] = (byte) ((value >> 8) & 0xff);
        data[pos + 2] = (byte) ((value >> 16) & 0xff);
        data[pos + 3] = (byte) ((value >> 24) & 0xff);
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2391().writeU32(data, pos, value);
    }
}
