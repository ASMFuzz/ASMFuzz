public class MyJVMTest_9261 {

    static byte[] data = { -95, 6, 92, 106, 47, -19, -62, 98, -9, 76 };

    static int pos = -1321315436;

    int decode2ByteInt(byte[] data, int pos) {
        return (((data[pos] & 0xFF) << 8) | (data[pos + 1] & 0xFF));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9261().decode2ByteInt(data, pos));
    }
}
