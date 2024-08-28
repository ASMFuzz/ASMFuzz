public class MyJVMTest_3353 {

    int readUnsignedShortAt(int offset) {
        int b1 = data[offset++] & 0xff;
        int b2 = data[offset] & 0xff;
        return (b1 << 8) + b2;
    }

    static int offset = 0;

    static byte[] data = {37,22,-18,-20,46,-106,87,21,4,-68};

    int readIntAt(int offset) {
        int s1 = readUnsignedShortAt(offset);
        int s2 = readUnsignedShortAt(offset + 2);
        return (s1 << 16) + s2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3353().readIntAt(offset));
    }
}
