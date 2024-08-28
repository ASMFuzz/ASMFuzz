public class MyJVMTest_2895 {

    static byte[] data = { -42, 58, 94, -7, 59, 9, 34, -98, 85, -84 };

    static int pos = 7;

    int decode4ByteInt(byte[] data, int pos) {
        int result = data[pos + 3] & 0xFF;
        result = result | ((data[pos + 2] & 0xFF) << 8);
        result = result | ((data[pos + 1] & 0xFF) << 16);
        result = result | ((data[pos] & 0xFF) << 24);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2895().decode4ByteInt(data, pos));
    }
}
