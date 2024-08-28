import java.nio.*;

public class MyJVMTest_7280 {

    static CharBuffer buff = null;

    static CharBuffer slice = null;

    CharBuffer test(CharBuffer buff, CharBuffer slice) throws RuntimeException {
        boolean marked = false;
        try {
            slice.reset();
            marked = true;
        } catch (InvalidMarkException ime) {
        }
        if (marked || slice.position() != 0 || buff.remaining() != slice.limit() || buff.remaining() != slice.capacity()) {
            throw new RuntimeException("Calling the CharBuffer.slice method failed.");
        }
        return slice;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7280().test(buff, slice);
    }
}
