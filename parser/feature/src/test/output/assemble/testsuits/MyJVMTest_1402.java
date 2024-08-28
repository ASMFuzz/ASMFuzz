import java.util.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_1402 {

    static String encoding = "5m1u XgCK7";

    CharBuffer test(String encoding) throws Exception {
        String text = "Vote for Duke!";
        Charset cs = Charset.forName(encoding);
        if (!cs.canEncode() || !cs.newEncoder().canEncode('.'))
            return;
        ByteBuffer in = ByteBuffer.wrap(text.getBytes(encoding));
        CharBuffer out = CharBuffer.allocate(text.length() / 2);
        CoderResult result = cs.newDecoder().decode(in, out, true);
        if (out.hasRemaining() || !result.isOverflow())
            throw new Exception("out.hasRemaining()=" + out.hasRemaining() + " result.isOverflow()=" + result.isOverflow() + " in.capacity()=" + in.capacity() + " encoding=" + encoding);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1402().test(encoding);
    }
}
