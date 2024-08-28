import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_17410 {

    void bug6371437() throws Exception {
        CharsetEncoder converter = Charset.forName("Cp933").newEncoder();
        converter = converter.onMalformedInput(CodingErrorAction.REPORT);
        converter = converter.onUnmappableCharacter(CodingErrorAction.REPORT);
        CharBuffer in = CharBuffer.wrap(new char[] { (char) 4352 });
        try {
            ByteBuffer out = converter.encode(in);
        } catch (CharacterCodingException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17410().bug6371437();
    }
}
