public class MyJVMTest_2927 {

    int readUnsignedByteAt(int offset) {
        return data[offset++] & 0xff;
    }

    static int offset = 0;

    static byte[] data = {-40,-11,-50,123,104,-102,126,-67,-18,-73};

    int readUnsignedByte() {
        int val = readUnsignedByteAt(offset);
        offset += 1;
        return val;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2927().readUnsignedByte());
    }
}
