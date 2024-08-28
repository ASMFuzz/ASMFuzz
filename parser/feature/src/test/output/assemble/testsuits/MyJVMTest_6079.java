public class MyJVMTest_6079 {

    static int offset = 1304451579;

    static byte[] data = {105,84,-100,95,19,113,84,33,81,-32};

    int readUnsignedShortAt(int offset) {
        int b1 = data[offset++] & 0xff;
        int b2 = data[offset] & 0xff;
        return (b1 << 8) + b2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6079().readUnsignedShortAt(offset));
    }
}
