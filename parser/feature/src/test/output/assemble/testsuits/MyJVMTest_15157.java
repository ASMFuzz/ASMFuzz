import java.nio.ByteBuffer;

public class MyJVMTest_15157 {

    static ByteBuffer buffer = null;

    static char firstChar = Character.MAX_VALUE;

    static long payloadLen = -9223372036854775808L;

    static int maskingKey = 0;

    static boolean mask = true;

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
        new MyJVMTest_15157().write(buffer);
    }
}
