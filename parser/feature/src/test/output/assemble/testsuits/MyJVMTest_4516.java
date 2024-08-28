public class MyJVMTest_4516 {

    int readUnsignedShortAt(int offset) {
        int b1 = data[offset++] & 0xff;
        int b2 = data[offset] & 0xff;
        return (b1 << 8) + b2;
    }

    static int offset = 5;

    static byte[] data = {36,72,5,-72,-51,-27,-49,-14,93,31};

    int readUnsignedShort() {
        int val = readUnsignedShortAt(offset);
        offset += 2;
        return val;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4516().readUnsignedShort());
    }
}
