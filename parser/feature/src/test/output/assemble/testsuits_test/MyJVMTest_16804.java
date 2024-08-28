import java.nio.*;

public class MyJVMTest_16804 {

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
        new MyJVMTest_16804().test(buff, slice);
    }
}
