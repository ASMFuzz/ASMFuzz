import java.nio.ByteBuffer;

public class MyJVMTest_2181 {

    static Checksum checksum = null;

    static long expected = 2660928739845423040L;

    Checksum checkChecksum(Checksum checksum, long expected) {
        if (checksum.getValue() != expected) {
            throw new RuntimeException("Calculated checksum result was invalid." + " Expected " + Long.toHexString(expected) + ", but got " + Long.toHexString(checksum.getValue()) + ".");
        }
        return checksum;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2181().checkChecksum(checksum, expected);
    }
}
