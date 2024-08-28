import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_8064 {

    void bug6371416() throws Exception {
        String[] charsets = { "Cp933", "Cp949", "Cp949C", "Cp970" };
        for (int n = 0; n < charsets.length; n++) {
            String charset = charsets[n];
            CharsetEncoder converter = Charset.forName(charset).newEncoder();
            converter = converter.onMalformedInput(CodingErrorAction.REPORT);
            converter = converter.onUnmappableCharacter(CodingErrorAction.REPORT);
            int errors = 0;
            for (int i = 0xd800; i < 0xe000; i++) {
                char[] in = new char[] { (char) i };
                try {
                    ByteBuffer out = converter.encode(CharBuffer.wrap(in));
                    if (out.remaining() == 0)
                        errors++;
                } catch (CharacterCodingException e) {
                }
            }
            if (errors > 0)
                throw new Exception("Charset " + charset + ": " + errors + " errors");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8064().bug6371416();
    }
}
