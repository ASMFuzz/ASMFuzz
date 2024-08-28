public class MyJVMTest_3966 {

    static int offset = 0;

    static byte[] data = {52,-124,-128,-99,101,16,-44,81,-72,-65};

    int readUnsignedByteAt(int offset) {
        return data[offset++] & 0xff;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3966().readUnsignedByteAt(offset));
    }
}
