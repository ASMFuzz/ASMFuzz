public class MyJVMTest_116 {

    static byte[] data = { 106, 18, 123, -31, -60, -2, -123, 83, 92, -23 };

    static int pos = 19744998;

    int decode2ByteInt(byte[] data, int pos) {
        return (((data[pos] & 0xFF) << 8) | (data[pos + 1] & 0xFF));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_116().decode2ByteInt(data, pos));
    }
}
