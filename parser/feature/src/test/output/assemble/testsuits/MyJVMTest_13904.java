public class MyJVMTest_13904 {

    int readUnsignedShortAt(int offset) {
        int b1 = data[offset++] & 0xff;
        int b2 = data[offset] & 0xff;
        return (b1 << 8) + b2;
    }

    static int offset = 0;

    static byte[] data = {-73,-83,-12,-75,-61,17,-71,96,0,-124};

    int readUnsignedShort() {
        int val = readUnsignedShortAt(offset);
        offset += 2;
        return val;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13904().readUnsignedShort());
    }
}
