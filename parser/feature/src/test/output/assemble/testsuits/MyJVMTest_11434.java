import java.nio.ByteBuffer;

public class MyJVMTest_11434 {

    static Checksum checksum = null;

    static long expected = 9223372036854775807L;

    Checksum checkChecksum(Checksum checksum, long expected) {
        if (checksum.getValue() != expected) {
            throw new RuntimeException("Calculated checksum result was invalid." + " Expected " + Long.toHexString(expected) + ", but got " + Long.toHexString(checksum.getValue()) + ".");
        }
        return checksum;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11434().checkChecksum(checksum, expected);
    }
}
