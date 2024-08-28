public class MyJVMTest_13316 {

    static int offset = 8;

    static byte[] data = {118,113,-13,-69,-15,-57,-119,73,-40,-8};

    int readUnsignedByteAt(int offset) {
        return data[offset++] & 0xff;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13316().readUnsignedByteAt(offset));
    }
}
