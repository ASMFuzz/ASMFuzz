public class MyJVMTest_12227 {

    int readUnsignedByteAt(int offset) {
        return data[offset++] & 0xff;
    }

    static int offset = 0;

    static byte[] data = {27,-95,-121,-108,-92,-112,-40,-25,0,70};

    int readUnsignedByte() {
        int val = readUnsignedByteAt(offset);
        offset += 1;
        return val;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12227().readUnsignedByte());
    }
}
