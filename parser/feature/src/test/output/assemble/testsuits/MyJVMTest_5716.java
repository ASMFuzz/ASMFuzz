import java.nio.ByteBuffer;

public class MyJVMTest_5716 {

    static ByteBuffer buffer = null;

    static char firstChar = Character.MIN_VALUE;

    static long payloadLen = 0;

    static int maskingKey = 6;

    static boolean mask = false;

    ByteBuffer write(ByteBuffer buffer) {
        buffer.putChar(firstChar);
        if (payloadLen >= 126) {
            if (payloadLen < 65536) {
                buffer.putChar((char) payloadLen);
            } else {
                buffer.putLong(payloadLen);
            }
        }
        if (mask) {
            buffer.putInt(maskingKey);
        }
        return buffer;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5716().write(buffer);
    }
}
