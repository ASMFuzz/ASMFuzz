import java.nio.ByteBuffer;

public class MyJVMTest_823 {

    static Checksum checksum = null;

    static long expected = 0;

    static int offset = 1926308674;

    Checksum checkChecksumOffset(Checksum checksum, long expected, int offset) {
        if (checksum.getValue() != expected) {
            throw new RuntimeException("Calculated CRC32C result was invalid. Array offset " + offset + ". Expected: " + Long.toHexString(expected) + ", Got: " + Long.toHexString(checksum.getValue()));
        }
        return checksum;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_823().checkChecksumOffset(checksum, expected, offset);
    }
}
