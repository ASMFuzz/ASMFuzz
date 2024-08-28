import java.util.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_5088 {

    static CharsetEncoder enc = null;

    static String str = "[a{&XLuB0Z";

    byte[] getBytes(CharsetEncoder enc, String str) throws Throwable {
        ByteBuffer bf = enc.reset().encode(CharBuffer.wrap(str.toCharArray()));
        byte[] ba = new byte[bf.limit()];
        bf.get(ba, 0, ba.length);
        return ba;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5088().getBytes(enc, str)));
    }
}
