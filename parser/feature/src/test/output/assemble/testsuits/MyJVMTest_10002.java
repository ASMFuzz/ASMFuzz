import java.nio.ByteBuffer;

public class MyJVMTest_10002 {

    static Checksum checksum = null;

    static long expected = 9223372036854775807L;

    static int offset = -328727264;

    Checksum checkChecksumOffset(Checksum checksum, long expected, int offset) {
        if (checksum.getValue() != expected) {
            throw new RuntimeException("Calculated CRC32C result was invalid. Array offset " + offset + ". Expected: " + Long.toHexString(expected) + ", Got: " + Long.toHexString(checksum.getValue()));
        }
        return checksum;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10002().checkChecksumOffset(checksum, expected, offset);
    }
}
