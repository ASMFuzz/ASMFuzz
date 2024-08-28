public class MyJVMTest_15537 {

    static int offset = 1372522441;

    static byte[] data = {-106,110,37,31,49,21,4,56,105,-30};

    int readUnsignedShortAt(int offset) {
        int b1 = data[offset++] & 0xff;
        int b2 = data[offset] & 0xff;
        return (b1 << 8) + b2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15537().readUnsignedShortAt(offset));
    }
}
