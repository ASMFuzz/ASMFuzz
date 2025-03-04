import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_15142 {

    static String outputString = "\u4e02\u4e04\u4e05\u4e0c\u4e12\u4e1f\u4e23";

    static byte[] inputBytes = new byte[] { (byte) 0x30, (byte) 0x21, (byte) 0x30, (byte) 0x22, (byte) 0x30, (byte) 0x23, (byte) 0x30, (byte) 0x24, (byte) 0x30, (byte) 0x25, (byte) 0x30, (byte) 0x26, (byte) 0x30, (byte) 0x27 };

    void test() throws Exception {
        CharsetDecoder dec = Charset.forName("JIS0212").newDecoder();
        try {
            String ret = dec.decode(ByteBuffer.wrap(inputBytes)).toString();
            if (ret.length() != outputString.length() || !outputString.equals(ret)) {
                throw new Exception("JIS0212 decoder does not work correctly");
            }
        } catch (Exception e) {
            throw new Exception("JIS0212 encoder does not work correctly");
        }
        if (!"\u2116".equals(new String(new byte[] { (byte) 0x8f, (byte) 0xf4, (byte) 0xac }, "x-eucJP-Open"))) {
            throw new RuntimeException("JIS0212_Solaris nr mapping failed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15142().test();
    }
}
