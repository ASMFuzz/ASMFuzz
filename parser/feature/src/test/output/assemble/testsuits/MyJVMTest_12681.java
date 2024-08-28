public class MyJVMTest_12681 {

    int readUnsignedShortAt(int offset) {
        int b1 = data[offset++] & 0xff;
        int b2 = data[offset] & 0xff;
        return (b1 << 8) + b2;
    }

    static int offset = 2;

    static byte[] data = {-25,-90,61,-24,-70,-28,90,43,117,95};

    int readIntAt(int offset) {
        int s1 = readUnsignedShortAt(offset);
        int s2 = readUnsignedShortAt(offset + 2);
        return (s1 << 16) + s2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12681().readIntAt(offset));
    }
}
