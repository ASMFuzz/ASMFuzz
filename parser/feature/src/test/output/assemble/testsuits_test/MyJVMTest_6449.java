import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_6449 {

    boolean decodeTest6392664() {
        try {
            CharsetDecoder dec = Charset.forName("ISO-2022-CN-GB").newDecoder();
            dec.decode(ByteBuffer.wrap(new byte[] { (byte) 0x0e, (byte) 0x42, (byte) 0x43 }));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6449().decodeTest6392664());
    }
}
