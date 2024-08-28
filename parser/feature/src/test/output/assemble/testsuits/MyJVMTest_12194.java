public class MyJVMTest_12194 {

    static byte[] data = { 87, -100, -37, -91, -6, -53, -68, -56, 43, 29 };

    static int pos = 8;

    int decode4ByteInt(byte[] data, int pos) {
        int result = data[pos + 3] & 0xFF;
        result = result | ((data[pos + 2] & 0xFF) << 8);
        result = result | ((data[pos + 1] & 0xFF) << 16);
        result = result | ((data[pos] & 0xFF) << 24);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12194().decode4ByteInt(data, pos));
    }
}
